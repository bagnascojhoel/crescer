/*
  No exercício 4:
    a) definimos os parâmentros conforme solicitado, indicando as que propagam
      alterações nas variáveis do local que iniciou a procedure e as que apenas
      recebem um valor;
    b) utilizamos uma variável intermediária para aceitar também valores
      em minúsculo, mas que correspondam a alguma ação; utilizando o if,
      determinamos qual trecho de código deve ser executado conforme o valor
      do parâmetro;
    c) utilizando a exception customizada "er_comando_dml_invalido", lançamos
      uma exceção quando o comando dml solicitado não corresponde a nenhum
      que nossa procedure atenda, e retornamos uma mensagem através do parâmetro
      p_log;
    d) utilizando a diretiva pragma, que delimita um trecho de código a ser 
      executado em momento de compilação, executamos a função exception_init,
      que nos permite relacionar um erro do oracle a uma exception customizada (
      utilizamos como exception customizada a er_idcidade_invalido);
    e) utilizando a função nvl, definimos valores padrão para faturamento_anual,
      data_abertura e situacao; utilizamos também o nvl para evitar ocorrer um 
      erro de valor nulo ao atualizar o faturamento_anual de um registro;
    f) após remover o registro encotrado através do p_idempresa dado, definimos
      os parametros passíveis de alteração para nulo (com exceção do p_log e 
      p_dml que recebem uma mensagem de sucesso e o código dado previamente,
      respectivamente);
    g) utilizando o parâmetro p_log, retornamos uma mensagem de sucesso respec-
      tiva a cada operação dml.
*/
CREATE OR REPLACE PROCEDURE prc_dml_empresas (
  p_dml                IN      VARCHAR2,
  p_idempresa          IN OUT  NUMBER,
  p_nome               IN OUT  VARCHAR2,
  p_idcidade           IN OUT  NUMBER,
  p_cnpj               IN OUT  VARCHAR2,
  p_faturamento_anual  IN OUT  NUMBER,
  p_data_abertura      IN OUT  DATE,
  p_situacao           IN OUT  VARCHAR2,
  p_cpf                IN OUT  VARCHAR2,
  p_tipo_pessoa        IN OUT  VARCHAR2,
  p_log                IN OUT  VARCHAR2
) IS

  er_comando_dml_invalido EXCEPTION;
  er_idcidade_invalido EXCEPTION;
  v_comando_dml VARCHAR2(1) := upper(p_dml);
  PRAGMA exception_init ( er_idcidade_invalido, -2291 );
BEGIN
  IF ( v_comando_dml = 'I' ) THEN
    INSERT INTO lic_empresa (
      nome,
      idcidade,
      cnpj,
      faturamento_anual,
      data_abertura,
      situacao,
      cpf,
      tipo_pessoa
    ) VALUES (
      p_nome,
      p_idcidade,
      p_cnpj,
      nvl(p_faturamento_anual, 0),
      nvl(p_data_abertura, sysdate),
      nvl(p_situacao, 'A'),
      p_cpf,
      p_tipo_pessoa
    ) RETURNING idcidade,
                faturamento_anual,
                data_abertura,
                situacao INTO p_idcidade, p_faturamento_anual, p_data_abertura, p_situacao;

    p_log := 'Registro inserido com sucesso!';
  ELSIF ( v_comando_dml = 'U' ) THEN
    UPDATE lic_empresa
    SET
      nome = p_nome,
      idcidade = p_idcidade,
      cnpj = p_cnpj,
      faturamento_anual = nvl(p_faturamento_anual, 0),
      data_abertura = p_data_abertura,
      situacao = p_situacao,
      cpf = p_cpf,
      tipo_pessoa = p_tipo_pessoa
    WHERE
      idempresa = p_idempresa;

    p_log := 'Registro alterado com sucesso!';
  ELSIF ( v_comando_dml = 'D' ) THEN
    DELETE FROM lic_empresa
    WHERE
      idempresa = p_idempresa;

    p_idempresa := NULL;
    p_nome := NULL;
    p_idcidade := NULL;
    p_cnpj := NULL;
    p_faturamento_anual := NULL;
    p_data_abertura := NULL;
    p_situacao := NULL;
    p_cpf := NULL;
    p_tipo_pessoa := NULL;
    p_log := 'Registro deletado com sucesso!';
  ELSE
    RAISE er_comando_dml_invalido;
  END IF;
EXCEPTION
  WHEN er_comando_dml_invalido THEN
    p_log := 'O valor passado para o parâmetro "dml" não é valido.' || ' Os comandos válidos são "I" (insert), "U" (update) e "D" (delete).';
  WHEN er_idcidade_invalido THEN
    p_log := 'O valor passado para "idcidade" não é valido.';
  WHEN OTHERS THEN
    p_log := 'Erro não tratado encontrado. '
             || sqlcode
             || ':'
             || sqlerrm;
END;