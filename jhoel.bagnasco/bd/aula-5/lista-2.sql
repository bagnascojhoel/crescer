-- 1

WITH empr AS (
  SELECT
    e.idgerente,
    e.idempregado,
    e.nomeempregado,
    d.nomedepartamento
  FROM
    empregado     e
    LEFT JOIN departamento  d ON e.iddepartamento = d.iddepartamento
)
SELECT
  e.idgerente,
  e.nomeempregado,
  g.nomeempregado nomegerente,
  e.nomedepartamento,
  g.nomedepartamento
FROM
       empr e
  INNER JOIN empr g ON e.idgerente = g.idempregado;

-- 2

SELECT
  e.iddepartamento,
  d.nomedepartamento
FROM
       (
    SELECT
      *
    FROM
      empregado
    ORDER BY
      salario DESC
  ) e
  INNER JOIN departamento d ON e.iddepartamento = d.iddepartamento
FETCH FIRST 1 ROW ONLY;

-- 3
CREATE TABLE empregado_copy
  AS
    SELECT
      *
    FROM
      empregado;

--UPDATE empregado
--SET
--  salario = salario * 1.173
--WHERE
--  idempregado IN (
--    SELECT
--      e.idempregado
--    FROM
--           empregado e
--      INNER JOIN departamento d ON e.iddepartamento = d.iddepartamento
--    WHERE
--      lower(d.localizacao) = 'sao paulo'
--  );
  
MERGE INTO empregado e0
USING (
        SELECT
          e.idempregado
        FROM
               empregado e
          INNER JOIN departamento d ON e.iddepartamento = d.iddepartamento
        WHERE
          lower(d.localizacao) = 'sao paulo'
      )
e1 ON ( e0.idempregado = e1.idempregado )
WHEN MATCHED THEN UPDATE
SET e0.salario = e0.salario * 1.173;

DROP TABLE empregado_copy;
-- 4

SELECT
  nome,
  uf,
  COUNT(1) ocorrencias
FROM
  cidadeex
GROUP BY
  nome,
  uf
HAVING
  COUNT(1) > 1;
  
-- 5

CREATE TABLE cidadeex_copy
  AS
    SELECT
      *
    FROM
      cidadeex;

CREATE VIEW vw_cidadeex_duplicados AS
  SELECT
    nome,
    uf,
    COUNT(1) ocorrencias
  FROM
    (
      SELECT
        *
      FROM
        cidadeex
      ORDER BY
        idcidade DESC
    )
  GROUP BY
    nome,
    uf
  HAVING
    COUNT(1) > 1;

MERGE INTO cidadeex c
USING (
        SELECT
          MAX(e.idcidade) idcidade,
          e.nome,
          e.uf
        FROM
               cidadeex e
          INNER JOIN vw_cidadeex_duplicados d ON e.nome || e.uf = d.nome || d.uf
        GROUP BY
          e.nome,
          e.uf
      )
t ON ( c.idcidade = t.idcidade )
WHEN MATCHED THEN UPDATE
SET nome = nome || '*';

DROP TABLE cidadeex_copy;


