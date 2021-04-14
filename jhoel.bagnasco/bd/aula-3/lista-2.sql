-- 1
SELECT
  idpedido,
  idcliente,
  datapedido,
  valorpedido,
  situacao
FROM
  pedido
WHERE
  ( upper(situacao) = 'A'
    AND idcliente = 11518 )
  OR valorpedido > 9000
ORDER BY
  valorpedido;
    
-- 2
SELECT
  *
FROM
  material
WHERE
    pesoliquido > 4
  AND precocusto < 0.3;

-- 3
SELECT
  uf,
  nome
FROM
  cidade c0
WHERE
  c0.idcidade IN (
    SELECT
      MIN(c1.idcidade)
    FROM
      cidade c1
    GROUP BY
      c1.nome
  )
  AND lower(c0.uf) = 'rs';
  
-- 4
SELECT
  *
FROM
  pedidoitem pi
WHERE
  pi.idpedido IN (
    SELECT
      p.idpedido
    FROM
      pedido p
    WHERE
        p.valorpedido = 480.25
      AND lower(p.situacao) = 'q'
  )
ORDER BY
  pi.precounitario;

-- 5
SELECT
  *
FROM
  cliente
WHERE
    lower(situacao) = 'a'
  AND cep IS NULL;

-- 6

SELECT
  idpedido,
  idproduto,
  ( quantidade * precounitario ) AS calculovalor
FROM
  (
    SELECT
      *
    FROM
      pedidoitem
    WHERE
      idpedido = 168
  )
ORDER BY
  calculovalor;
    
-- 7
SELECT
  *
FROM
  material
WHERE
  pesoliquido BETWEEN 0.5 AND 0.6;

-- 8
SELECT
  *
FROM
  pedido
WHERE
  EXISTS (
    SELECT
      idpedido
    FROM
      pedidoitem
  )
  AND lower(situacao) = 'a'
  AND valorpedido > 9500;

-- 9
SELECT
  nvl(quantidade, 1) * 5
FROM
  produtomaterial
WHERE
  idproduto = 2492;
    
-- 10
SELECT
  *
FROM
  pedido
WHERE
  ( lower(situacao) = 'a'
    OR lower(situacao) = 'c'
    OR lower(situacao) = 'i' )
  AND valorpedido >= 9800;