DECLARE
  p_cnpj                        VARCHAR2(100);
  p_nome_empresa                VARCHAR2(100);
  p_nome_cidade                 VARCHAR2(100);
  p_faturamento_anual           VARCHAR2(100);
  p_situacao                    VARCHAR2(100);
  p_pos_perc_geral_faturamento  NUMBER;
  p_pos_qtd_rank_fat_emp        NUMBER;
BEGIN
 --
 /* Formas que podem ser inseridas o cnpj */
     p_cnpj := '1384660000186';
 --p_cnpj := '01.384.660/0001-86';
 --p_cnpj := '1.384.660/0001-86';
 --
     pck_licitacao.prc_get_empresa(p_cnpj, p_nome_empresa, p_nome_cidade, p_faturamento_anual, p_situacao,
                               p_pos_perc_geral_faturamento,
                               p_pos_qtd_rank_fat_emp);
 --
     dbms_output.put_line('p_cnpj -> ' || p_cnpj);
  dbms_output.put_line('p_nome_empresa -> ' || p_nome_empresa);
  dbms_output.put_line('p_nome_cidade -> ' || p_nome_cidade);
  dbms_output.put_line('p_faturamento_anual -> ' || p_faturamento_anual);
  dbms_output.put_line('p_situacao -> ' || p_situacao);
  dbms_output.put_line('p_pos_perc_geral_faturamento -> ' || p_pos_perc_geral_faturamento);
  dbms_output.put_line('p_pos_qtd_rank_fat_emp -> ' || p_pos_qtd_rank_fat_emp);
 --
END;