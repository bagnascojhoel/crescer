declare
  vQtdMesesInativos integer := 6;
  cursor cr_clientes_inativos (pQtdMesesInativos in integer) is
    select cliente.idcliente
    from cliente
    inner join pedido
    on pedido.idcliente = cliente.idcliente
    where to_char(datapedido, 'MM/YYYY')
      = to_char(add_months(sysdate, pQtdMesesInativos), 'MM/YYYY');
begin
  for reg_cliente in cr_clientes_inativos(vQtdMesesInativos) loop
    update cliente
    set situacao = 'I'
    where idcliente = reg_cliente.idcliente;
  end loop;
  dbms_output.put_line(
    'Clientes sem atividade nos últimos '
    || vQtdMesesInativos
    || ' meses foram inativados com sucesso!'
  );
exception
  when others then
    dbms_output.put_line(
      'Ocorreu algum erro ao atualizar clientes inativos: '
      || sqlcode
    );
end;