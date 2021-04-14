/*
  Criamos o pacote colocando a procedure e as duas functions necessárias para se 
  fazer o package
*/
CREATE OR REPLACE PACKAGE pck_licitacao AS
  PROCEDURE prc_get_empresa (
    p_cnpj                            IN OUT  VARCHAR2,
    p_nome_empresa                    OUT     VARCHAR2,
    p_nome_cidade                     OUT     VARCHAR2,
    p_faturamento_anual               OUT     VARCHAR2,
    p_situacao                        OUT     VARCHAR2,
    p_posicao_perc_geral_faturamento  OUT     NUMBER,
    p_pos_qtd_rank_fat_emp            OUT     NUMBER
  );

  FUNCTION fnc_get_pos_perc_fat_geral (
    p_id_empresa IN INT
  ) RETURN NUMBER;

  FUNCTION fnc_get_pos_qtd_rank_fat (
    p_id_empresa IN INT
  ) RETURN INT;

  TYPE registro_empresa IS RECORD (
    nome_empresa VARCHAR2(255)
  );
  
  TYPE table_registro_empresa IS
    TABLE OF registro_empresa;
  FUNCTION fnc_get_empresas (
    p_list_ids_empresas VARCHAR2
  ) RETURN table_registro_empresa
    PIPELINED;

END;

--------------------------------------------------------------------------------

CREATE OR REPLACE PACKAGE BODY pck_licitacao AS
/*
  Criação da function que retorna o percentual de faturamento geral com base no 
  id da empresa passado como parametro. Foi necessário criar uma variável para 
  que ela armazenasse a soma de todos os faturamentos anuais das empresas ativas
  e uma variavel de retorno com casas decimais limitadas. Dentro da função 
  somamos todos os faturamentos anuais dentro de um select e armazenamos dentro 
  da variavel v_valor_total. Após esse primeiro select fazemos um segundo select
  que faz o calculo de porcentagem e retorna a porcentagem da empresa passada
  como parâmetro.
*/
              FUNCTION fnc_get_pos_perc_fat_geral (
    p_id_empresa IN INT
  ) RETURN NUMBER AS
    r_posicao_perc_geral_faturamento  NUMBER;
    v_valor_total                     lic_empresa.faturamento_anual%TYPE;
  BEGIN
    SELECT
      SUM(faturamento_anual)
    INTO v_valor_total
    FROM
      lic_empresa
    WHERE
      situacao = 'S';

    SELECT
      round((faturamento_anual * 100) / v_valor_total, 3) AS percentual
    INTO r_posicao_perc_geral_faturamento
    FROM
      lic_empresa
    WHERE
        p_id_empresa = idempresa
      AND situacao = 'S';

    RETURN r_posicao_perc_geral_faturamento;
  END fnc_get_pos_perc_fat_geral;
/*
  Novamente criamos duas variaveis, uma para o retorno do ranking e outra para 
  armazenar o valor total. Executamos o primeiro select para armazenar o valor 
  total das somas de faturmento anual. No segundo select retorna-se o ranking da 
  empresa com base em seu percentual.
*/
              FUNCTION fnc_get_pos_qtd_rank_fat (
    p_id_empresa IN INT
  ) RETURN INT AS
    r_pos_qtd_rank_fat_emp  INT;
    v_valor_total           lic_empresa.faturamento_anual%TYPE;
  BEGIN
    SELECT
      SUM(faturamento_anual)
    INTO v_valor_total
    FROM
      lic_empresa
    WHERE
      situacao = 'S';

    SELECT
      ranking
    INTO r_pos_qtd_rank_fat_emp
    FROM
      (
        SELECT
          idempresa,
          percentual,
          ROWNUM AS ranking
        FROM
          (
            SELECT
              e.idempresa,
              ( e.faturamento_anual * 100 ) / v_valor_total AS percentual
            FROM
              lic_empresa e
            WHERE
              situacao = 'S'
            ORDER BY
              percentual DESC
          )
      )
    WHERE
      idempresa = p_id_empresa;

    RETURN r_pos_qtd_rank_fat_emp;
  END fnc_get_pos_qtd_rank_fat;
/*
  Criamos a procedure que recebem como parametro o cnpj e com base no cnpj, 
  formatado pelo regex de maneira que os dois primeiros numeros recebem um 
  ponto, após isso os próximos 3 numeros recebm um ponto, após isso os próximos 
  3 numeros recebem uma "/" e os 2 numeros finais recebem um "-" buscamos o 
  resto das informações dos parametros e formatamos o faturamento anual da forma
  que entre as casas dos milhares entre uma vírgula e nos centavos entre um 
  decimal. Executando as funções pegamos os outros dois parametros que restaram.
*/
            PROCEDURE prc_get_empresa (
    p_cnpj                            IN OUT  VARCHAR2,
    p_nome_empresa                    OUT     VARCHAR2,
    p_nome_cidade                     OUT     VARCHAR2,
    p_faturamento_anual               OUT     VARCHAR2,
    p_situacao                        OUT     VARCHAR2,
    p_posicao_perc_geral_faturamento  OUT     NUMBER,
    p_pos_qtd_rank_fat_emp            OUT     NUMBER
  ) AS
    v_id_empresa INT;
  BEGIN
    IF length(p_cnpj) = 17 THEN
      p_cnpj := lpad(p_cnpj, 18, '0');
    ELSIF length(p_cnpj) = 13 THEN
      p_cnpj := regexp_replace(lpad(p_cnpj, 14, 0), '([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})', '\1.\2.\3/\4-');
    END IF;

    SELECT
      e.idempresa,
      e.nome,
      c.nome
      || ' - '
      || c.uf nomecombinado,
      e.situacao,
      e.faturamento_anual
    INTO
      v_id_empresa,
      p_nome_empresa,
      p_nome_cidade,
      p_situacao,
      p_faturamento_anual
    FROM
           lic_empresa e
      INNER JOIN lic_cidade c ON c.idcidade = e.idcidade
    WHERE
      e.cnpj = p_cnpj;

    p_faturamento_anual := to_char(p_faturamento_anual, '999G999G999G999D99');
    IF ( p_situacao = 'S' ) THEN
      SELECT
        fnc_get_pos_perc_fat_geral(v_id_empresa)
      INTO p_posicao_perc_geral_faturamento
      FROM
        lic_empresa
      WHERE
          situacao = 'S'
        AND idempresa = v_id_empresa;

    END IF;

    IF ( p_situacao = 'S' ) THEN
      SELECT
        fnc_get_pos_qtd_rank_fat(v_id_empresa)
      INTO p_pos_qtd_rank_fat_emp
      FROM
        lic_empresa
      WHERE
          situacao = 'S'
        AND idempresa = v_id_empresa;

    END IF;

    p_situacao :=
      CASE
        WHEN p_situacao = 'S' THEN
          'Ativa'
        WHEN p_situacao = 'N' THEN
          'Não ativa'
      END;
  END prc_get_empresa;
  
--------------------------------------------------------------------------------
/*
  Criamos a função passando como parametro uma lista de ids em string e 
  retornamos uma tabela com os nomes corretamente. Iteramos um while dentro da 
  lista de ids quebrando o id em uma variavel local e transformando o id em um 
  number para que dentro do select ele possa fazer a comparação corretamente. A 
  cada iteração do while ele quebrava a lista de ids em 1 e pegava sempre o 
  valor seguinte assim atribuimos todas as empresas passadas como parâmetro.
*/
    FUNCTION fnc_get_empresas (
    p_list_ids_empresas IN VARCHAR2
  ) RETURN table_registro_empresa
    PIPELINED
  AS
    v_variavel_local  VARCHAR2(255);
    v_lista_ids       VARCHAR2(255) := p_list_ids_empresas;
    rec               registro_empresa;
  BEGIN
    WHILE ( length(v_lista_ids) > 0 ) LOOP
      v_variavel_local := substr(v_lista_ids, 1, instr(v_lista_ids, ':') -1);
      
      IF ( instr(v_lista_ids, ':') = 0 ) THEN
        v_variavel_local := v_lista_ids;
        v_lista_ids := null;
      END IF;
      
      v_lista_ids := substr(v_lista_ids, instr(v_lista_ids, ':') + 1, length(v_lista_ids));

      SELECT
        nome
      INTO rec
      FROM
        lic_empresa
      WHERE
        to_number(v_variavel_local) = idempresa;

      PIPE ROW ( rec );
    END LOOP;

    return;
  END fnc_get_empresas;

END;