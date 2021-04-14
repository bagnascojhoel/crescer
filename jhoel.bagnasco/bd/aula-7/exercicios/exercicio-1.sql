--desc produto;
--
--create table produto_copy as select * from produto;
--select * from produto_copy;
--drop table produto_copy;


create or replace procedure proc_aumentar_preçovenda_produto
is
  cursor cr_produto is
    select idproduto
    from produto;
begin
  for it_produto in cr_produto loop
    if (upper(fetch_produto_situacao(it_produto.idproduto)) = 'A') then
      update produto
      set precovenda = precovenda * 1.05
      where idproduto = it_produto.idproduto;
      dbms_output.put_line('Preço atualizado com sucesso!');
    end if;
  end loop;  
end;


CREATE OR REPLACE function fetch_produto_situacao
  (pIdProduto in produto.idproduto%type)
  return produto.situacao%type
is  
  vSituacao is produto.situacao%type;
begin
  select situacao
  into vSituacao
  from produto
  where idproduto = pIdProduto;
  
  return vSituacao;
end;

