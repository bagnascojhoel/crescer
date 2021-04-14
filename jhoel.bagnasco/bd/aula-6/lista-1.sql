-- [ 1 ]
---------------------------------------------------------------------
-- A) Está certa
--DECLARE
--	vid number(4);
	
---------------------------------------------------------------------
-- B) Está incorreto. Não é possível declarar multiplas variaveis
--    em uma mesma linha.

--DECLARE
--	vId, vIdCidade integer;
	
---------------------------------------------------------------------
-- C) Está incorreto. Está definindo uma variável que não pode ser
--    nula com um valor nulo.

--DECLARE
--	vData DATE NOT NULL;
	
---------------------------------------------------------------------
-- D) Está certa

--DECLARE
--	vFlag boolean := 1;
	

---------------------------------------------------------------------
-- [ 2 ]

DECLARE
  vLIMIT_ORDER_VALUE integer := 9000; 
  vIdOrder pedido.idpedido%TYPE := 8420;
  vDeliverDate pedido.dataentrega%TYPE;   
  vOrderValue pedido.valorpedido%TYPE;
BEGIN
  SELECT dataentrega, valorpedido
  INTO vDeliverDate, vOrderValue
  FROM pedido
  WHERE IDPEDIDO = vIdOrder;

  
  IF vDeliverDate > sysdate AND vOrderValue > vLIMIT_ORDER_VALUE THEN 
    UPDATE pedido SET valorpedido = valorpedido * 0.995 WHERE idpedido = vIdOrder;
    dbms_output.put_line('Valor do pedido ' || vIdOrder || ' reajustado!');
  END IF;

END;
	
	
	
	
	