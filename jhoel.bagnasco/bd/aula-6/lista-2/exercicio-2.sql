declare
  vIdPedido pedidoitem.idpedido%type:= 1024;
  vValorPedidoAtual pedido.valorpedido%type;
  vValorPedidoCorreto pedido.valorpedido%type;
  
  cursor cr_pedido_itens (pIdPedido in pedidoitem.idpedido%type) is
    select sum(precounitario * quantidade)
    from pedidoitem
    where idpedido = pIdPedido;
    
  cursor cr_pedido (pIdPedido in pedido.idpedido%type) is
    select valorpedido
    from pedido
    where idpedido = pIdPedido;
    
begin
  open cr_pedido(vIdPedido);
    fetch cr_pedido into vValorPedidoAtual;
  close cr_pedido;
  
  open cr_pedido_itens(vIdPedido);
    fetch cr_pedido_itens into vValorPedidoCorreto;
  close cr_pedido_itens;

  if (vValorPedidoAtual = vValorPedidoCorreto) then
    dbms_output.put_line('Valor total do pedido já está correto!');
  else
    update pedido
    set valorpedido = vValorPedidoCorreto
    where idpedido = vIdPedido;
    dbms_output.put_line('Valor total do pedido foi corrigido com sucesso!');
  end if;
end;