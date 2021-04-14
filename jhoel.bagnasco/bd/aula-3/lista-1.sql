-- 1
SELECT
  idempregado    "ID",
  nomeempregado  nome
FROM
  empregado
ORDER BY
  dataadmissao;

-- 2
SELECT
  nomeempregado nome,
  salario
FROM
  empregado
WHERE
  nvl(comissao, 0) = 0
ORDER BY
  salario;

-- 3
SELECT
  idempregado                                           "ID do Empregado",
  nomeempregado                                         "Nome",
  ( salario * 13 )                                      "Salário Anual",
  ( nvl(comissao, 0) * 12 )                             "Comissão Anual",
  ( ( salario * 13 ) + ( nvl(comissao, 0) * 12 ) )      "Renda Anual"
FROM
  empregado
ORDER BY
  nomeempregado;

-- 4
SELECT
  idempregado       "ID do Empregado",
  nomeempregado     "Nome",
  cargo             "Cargo",
  ( salario * 13 )  "Salário Anual"
FROM
  empregado
WHERE
  ( ( salario * 13 ) < 18500 )
  OR ( lower(cargo) = 'atendente' )
ORDER BY
  empregado.nomeempregado;

-- 5
SELECT
  nomeempregado  "Nome",
  cargo          "Cargo"
FROM
  empregado
WHERE
  ( lower(cargo) = 'atendente' )
  OR idgerente = 7698
ORDER BY
  empregado.nomeempregado;

-- 6
SELECT
  iddepartamento    "ID do Departamento",
  nomedepartamento  "Nome Departamento"
FROM
  departamento
WHERE
  localizacao LIKE 'SAO%'
ORDER BY
  nomedepartamento;

-- 7
SELECT
  *
FROM
  cidade
WHERE
  idcidade BETWEEN 4 AND 9
ORDER BY
  idcidade;

-- 8
SELECT
  *
FROM
  departamento dpt
WHERE
  NOT EXISTS (
    SELECT
      iddepartamento
    FROM
      empregado emp
    WHERE
      dpt.iddepartamento = emp.iddepartamento
  )
ORDER BY
  iddepartamento;
  
-- 9
SELECT
  nomeempregado  "Nome Empregado",
  cargo          "Cargo"
FROM
  empregado
WHERE
  iddepartamento IS NULL
ORDER BY
  empregado.nomeempregado;
  
-- 10
select 
    nomeempregado "Nome Empregado"
from 
    empregado
where 
    idgerente in (7566, 7698, 7782)
order by empregado.nomeempregado





