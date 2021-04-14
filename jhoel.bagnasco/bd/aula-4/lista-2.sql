-- 1
SELECT
  to_char(data_fechamento, 'DD-mon-YYYY'),
  round(valor_estimado_min),
  titulo
FROM
  lic_licitacao
WHERE
    inicio_vigencia >= TO_DATE('01/01/2018', 'DD/MM/YYYY')
  AND fim_vigencia <= TO_DATE('30/06/2018', 'DD/MM/YYYY');
  
-- 2
SELECT
  idcontratante,
  round(AVG(valor_estimado_min), 2)         valorminmedioestimado,
  round(AVG(valor_estimado_max), 2)         valormaxmedioestimado
FROM
  lic_licitacao
WHERE
  idcontratante = 705
  OR idcontratante = 738
GROUP BY
  idcontratante;
  
-- 3
SELECT
  idcontratante,
  COUNT(idcontratante) ndevezes
FROM
  lic_licitacao
GROUP BY
  idcontratante
ORDER BY
  ndevezes DESC,
  idcontratante
FETCH NEXT 6 ROWS ONLY;

-- 4
SELECT
  CASE
    WHEN lower(situacao) = 's'     THEN
      'selecionada'
    WHEN lower(situacao) = 'd'     THEN
      'desqualificada'
    WHEN lower(situacao) = 'n'     THEN
      'não selecionada'
  END AS situacao,
  idlicitacao,
  idempresa
FROM
  lic_proposta
WHERE
  data_inscricao >= TO_DATE('01/06/2018', 'DD/MM/YYYY');
  
-- 5

SELECT
  idproposta proposta,
  abs(valor_inicial),
  abs(valor_final)
FROM
  lic_proposta;
  
-- 6
SELECT
  idlicitacao                    licitacao,
  trunc(MAX(valor_final))        maiorvalor
FROM
  lic_proposta
WHERE
  situacao = 'S'
GROUP BY
  idlicitacao
ORDER BY
  abs(MAX(valor_final)) DESC;
  
-- 7
SELECT
  situacao,
  to_char(data_inscricao, 'MM-YYYY')      "Mês - Ano",
  COUNT(1)                                "Quantidade de propostas"
FROM
  lic_proposta
WHERE
  EXTRACT(YEAR FROM data_inscricao) = '2018'
GROUP BY
  situacao,
  to_char(data_inscricao, 'MM-YYYY')
ORDER BY
  to_char(data_inscricao, 'MM-YYYY'),
  situacao;

-- 8
SELECT
  *
FROM
  lic_material
WHERE
    idclasse_material = 13
  AND nome LIKE '%ALTURA 925 MM%';
  
-- 9
select
  iditem_licitacao,
  idlicitacao,
  quantidade Quantidade,
  valor_minimo "Valor Mínimo",
  (valor_minimo * quantidade) "Valor Min Total",
  valor_maximo "Valor máximo",
  (valor_maximo * quantidade) "Valor Max Total"
from
  lic_item_licitacao
order by
  idlicitacao;
