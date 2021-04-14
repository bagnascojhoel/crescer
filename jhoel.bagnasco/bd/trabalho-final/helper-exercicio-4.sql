declare
  v_dml varchar2(1) := :dml;
  v_idempresa lic_empresa.idempresa%type := :idempresa;
  v_nome lic_empresa.nome%type := :nome;
  v_idcidade lic_empresa.idcidade%type := :idcidade;
  v_cnpj lic_empresa.cnpj%type := :cnpj;
  v_faturamento_anual lic_empresa.faturamento_anual%type := :faturamento_anual;
  v_data_abertura lic_empresa.data_abertura%type := :data_abertura;
  v_situacao lic_empresa.situacao%type := :situacao;
  v_cpf lic_empresa.cpf%type := :cpf;
  v_tipo_pessoa lic_empresa.tipo_pessoa%type := :tipo_pessoa;
  v_log varchar2(255) := :log;
begin
  prc_dml_empresas(
    v_dml,
    v_idempresa,
    v_nome,
    v_idcidade,
    v_cnpj,
    v_faturamento_anual,
    v_data_abertura,
    v_situacao,
    v_cpf,
    v_tipo_pessoa,
    v_log
  );
  dbms_output.put_line(v_log);
  dbms_output.put_line('p_dml -> ' || v_dml);
  dbms_output.put_line('p_idempresa -> ' || v_idempresa);
  dbms_output.put_line('p_nome -> ' || v_nome);
  dbms_output.put_line('p_idcidade -> ' || v_idcidade);
  dbms_output.put_line('p_cnpj -> ' || v_cnpj);
  dbms_output.put_line('p_faturamento_anual -> ' || v_faturamento_anual);
  dbms_output.put_line('p_data_abertura -> ' || v_data_abertura);
  dbms_output.put_line('p_situacao -> ' || v_situacao);
  dbms_output.put_line('p_cpf -> ' || v_cpf);
  dbms_output.put_line('p_tipo_pessoa -> ' || v_tipo_pessoa);
end;
select * from lic_empresa where idempresa = 11309;