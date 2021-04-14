-- 1
select
  to_char(sysdate, 'DD-mon-YYYY HH24:MI:SS') as Data
from
  dual;
  
-- 2  
select
  lower(substr(nomeempregado, 1, 4))
from
  empregado;

-- 3
select
  concat(nomeempregado, cargo) NomeCargo1,
  rpad(nomeempregado, length(nomeempregado) + length(cargo), cargo) NomeCargo2
from
  empregado;

-- 4
select
  to_date(concat(to_char(dataadmissao, 'DD/MM/YYYY'), ' 08:00:00'), 'DD/MM/YYYY HH24:MI:SS')
from
  empregado;
