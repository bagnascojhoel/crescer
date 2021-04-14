declare
  vDataMesAno date := to_date('07/2018', 'MM/YYYY');
  vIdProduto produto.idproduto%type := 3;
  
  cursor cr_materias_necessarios(
    pIdProduto in produto.idproduto%type,
    pDataMesAno in date
  ) is
    select
      m.descricao,
      (pi.quantidade * nvl(pm.quantidade, 1)) quantidade
    from
      produto p
    inner join pedidoitem pi on p.idproduto = pi.idproduto
    inner join pedido pd on pi.idpedido = pd.idpedido
    inner join produtomaterial pm on p.idproduto = pm.idproduto
    inner join material m on pm.idmaterial = m.idmaterial
    where
      p.idproduto = pIdProduto
      and to_char(pd.dataentrega, 'MM/YYYY')
        = to_char(pDataMesAno, 'MM/YYYY');
  
begin
  dbms_output.put_line(
    'Precisará para o mês '
    || extract(month from vDataMesAno)
    || ' de '
    || extract(year from vDataMesAno)
    || ' a seguinte lista de materiais:');
    
  for reg_material in cr_materias_necessarios(vIdProduto, vDataMesAno) loop
    dbms_output.put_line(
      reg_material.descricao
      || ' X '
      || reg_material.quantidade);
  end loop;
  
  dbms_output.put_line('--- fim da lista ---');
end;

