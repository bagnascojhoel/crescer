-- 1
SELECT
  idempregado                                               id,
  nomeempregado                                             nome,
  trunc(months_between(sysdate, dataadmissao) / 12)         "Anos desde admissão"
FROM
  empregado
WHERE
  EXTRACT(YEAR FROM dataadmissao) = '1981';

-- 2
SELECT
  cargo
FROM
  empregado
GROUP BY
  cargo
ORDER BY
  COUNT(1) DESC
FETCH NEXT 1 ROWS ONLY;

-- 3
SELECT
  uf,
  COUNT(1) quantidade
FROM
  cidade
GROUP BY
  uf
ORDER BY
  quantidade DESC;
  
-- 4
INSERT INTO departamento VALUES (
  50,
  'Inovação',
  'SAO LEOPOLDO'
);

UPDATE empregado
SET
  iddepartamento = 50
WHERE
    EXTRACT(MONTH FROM dataadmissao) = '12'
  AND lower(cargo) != 'atendente';
  
  