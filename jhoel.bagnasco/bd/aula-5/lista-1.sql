-- 1
SELECT
  substr(nome, 1, instr(nome, ' '))           primeiro_nome,
  COUNT(1)                                    total
FROM
  cliente
GROUP BY
  substr(nome, 1, instr(nome, ' '))
ORDER BY
  total DESC
FETCH FIRST 1 ROW ONLY;

-- 2
SELECT
  COUNT(1)             pedidos_realizados,
  SUM(valorpedido)     valor_total
FROM
  pedido
WHERE
  to_char(datapedido, 'MM/YYYY') = '03/2018';

SELECT
  COUNT(1)             pedidos_realizados,
  SUM(valorpedido)     valor_total
FROM
  pedido
WHERE
    EXTRACT(YEAR FROM datapedido) = 2018
  AND EXTRACT(MONTH FROM datapedido) = 3;
  
-- 3

SELECT
  *
FROM
  (
    SELECT
      cd.uf,
      COUNT(1) total
    FROM
           cidade cd
      INNER JOIN cliente cl ON cd.idcidade = cl.idcidade
    GROUP BY
      cd.uf
    ORDER BY
      total DESC
    FETCH FIRST 1 ROW ONLY
  )
UNION
SELECT
  *
FROM
  (
    SELECT
      cd.uf,
      COUNT(1) total
    FROM
           cidade cd
      INNER JOIN cliente cl ON cd.idcidade = cl.idcidade
    GROUP BY
      cd.uf
    ORDER BY
      total
    FETCH FIRST 1 ROW ONLY
  );
  
-- 4

INSERT INTO produto (
  idproduto,
  nome,
  precocusto,
  precovenda,
  situacao
) VALUES (
  8001,
  'Coturno Pica-Pau',
  29.25,
  77.95,
  'A'
);

-- 5

SELECT
  *
FROM
  produto     pr
  LEFT JOIN pedidoitem  pe ON pr.idproduto = pe.idproduto
WHERE
  pe.idproduto IS NULL;

SELECT
  *
FROM
  produto
WHERE
  idproduto NOT IN (
    SELECT
      idproduto
    FROM
      pedidoitem
  );
  
  
-- 6

-- pelo lucro
WITH items AS (
  SELECT
    SUM(pi.quantidade) quantidade,
    pi.idproduto
  FROM
         pedidoitem pi
    INNER JOIN pedido p ON pi.idpedido = p.idpedido
  WHERE
    EXTRACT(YEAR FROM p.datapedido) = 2018
  GROUP BY
    pi.idproduto
)
SELECT
  p.nome,
  ( ( p.precovenda - p.precocusto ) * i.quantidade ) lucro
FROM
       produto p
  INNER JOIN items i ON p.idproduto = i.idproduto
ORDER BY
  lucro DESC
FETCH FIRST 30 ROW ONLY;

-- pela receita
WITH items AS (
  SELECT
    SUM(pi.quantidade) quantidade,
    pi.idproduto
  FROM
         pedidoitem pi
    INNER JOIN pedido p ON pi.idpedido = p.idpedido
  WHERE
    EXTRACT(YEAR FROM p.datapedido) = 2018
  GROUP BY
    pi.idproduto
)
SELECT
  p.nome,
  ( ( p.precovenda ) * i.quantidade ) lucro
FROM
       produto p
  INNER JOIN items i ON p.idproduto = i.idproduto
ORDER BY
  lucro DESC
FETCH FIRST 30 ROW ONLY;