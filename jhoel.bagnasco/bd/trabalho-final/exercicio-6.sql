/*
  No exercício 6: 
    - para ter controle dos feriados, foi criada a tabela feriado, que conta
    com os campos de data (que é unico para não haver dois feriados no mesmo
    dia), descricao e idferiado;
    - criamos a função "fnc_get_next_day_as_date" que recebe uma data inical
    e um dia e retorna a data do próximo dia igual o desejado, apartir da data 
    inicial dada; caso seja passado um dia inválido, a função envia uma mensagem
    para o dbms;
    - restante da explicação no código;
    
*/
CREATE OR REPLACE FUNCTION fnc_get_qtd_dias_next_vr (
  p_data_admissao  IN  DATE,
  p_dia_pagamento  IN  NUMBER
) RETURN NUMBER IS

  v_qtd_dias                 NUMBER;
  v_proximo_dia_pgmt         DATE := fnc_get_next_day_as_date(p_data_admissao, p_dia_pagamento);
  v_proximo_pgmt_dia_semana  VARCHAR(10) := to_char(v_proximo_dia_pgmt, 'DAY');
  /*
    pega a próxima data em que o dia da semana é igual ao dia da semana
    em que o próximo pagamento deverá ocorrer
  */
    v_inicio_semana            DATE :=
    CASE
      WHEN v_proximo_pgmt_dia_semana = to_char(p_data_admissao, 'DAY') THEN
        p_data_admissao
      ELSE next_day(p_data_admissao, v_proximo_pgmt_dia_semana)
    END;
  /*
    cursor para poder iterar sobre todos feriados que ainda não ocorreram
    e também vão ocorrer até o próximo dia de pagamento
  */
    CURSOR cr_feriados IS
  SELECT
    *
  FROM
    feriado
  WHERE
      data >= p_data_admissao
    AND data <= v_proximo_dia_pgmt;

BEGIN
  /*
    quantidade de dias da data de admissão até o início encontrado da semana
  */
    v_qtd_dias := v_inicio_semana - ( p_data_admissao - 1 );

  /*
    agora, andando de semana em semana (7 em 7 dias), podemos iterar até que
    o inicio da semana seja igual a data do proximo pagamento e adicionar apenas
    a quantidade de dias úteis a cada iteração
  */
    WHILE v_inicio_semana < v_proximo_dia_pgmt LOOP
    v_inicio_semana := v_inicio_semana + 7;
    v_qtd_dias := v_qtd_dias + 5;
  END LOOP;
  
  /*
    loop para remover os dias que são feriados e ocorrem em dias úteis
  */
    FOR reg_feriado IN cr_feriados LOOP
    IF ( to_char(reg_feriado.data, 'DAY') NOT IN ( 'SUN', 'SAT' ) ) THEN
      v_qtd_dias := v_qtd_dias - 1;
    END IF;
  END LOOP;

  RETURN v_qtd_dias;
END;

--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION fnc_get_next_day_as_date (
  p_initial_date  IN  DATE,
  p_day           IN  NUMBER
) RETURN DATE IS
  ex_invalid_day EXCEPTION;
  r_result  DATE;
  v_today   NUMBER := extract(DAY FROM p_initial_date);
BEGIN
  IF ( p_day > 31 OR p_day < 1 ) THEN
    RAISE ex_invalid_day;
  END IF;
  r_result :=
    CASE
      WHEN v_today <= p_day THEN
        to_date(p_day || to_char(p_initial_date, 'MMYYYY'), 'DDMMYYYY')
      WHEN v_today > p_day THEN
        to_date(p_day
                || to_char(add_months(p_initial_date, 1), 'MMYYYY'), 'DDMMYYYY')
    END;

  RETURN r_result;
EXCEPTION
  WHEN ex_invalid_day THEN
    dbms_output.put_line('Invalid day. A day must be between 1 and 31.');
END;

--------------------------------------------------------------------------------

INSERT INTO feriado (
  descricao,
  data
) VALUES (
  'Dia dos mortos',
  TO_DATE('12/10/2020', 'DD/MM/YYYY')
);

--------------------------------------------------------------------------------

CREATE TABLE feriado (
  idferiado  NUMBER
    GENERATED ALWAYS AS IDENTITY,
  descricao  VARCHAR(50),
  data       DATE NOT NULL UNIQUE,
  CONSTRAINT pk_feriado PRIMARY KEY ( idferiado )
);

--------------------------------------------------------------------------------