-- 1

clear scr;
desc questionario;
desc questao;
desc opcao;

with qo as (
  select
    qo.idquestionario,
    qo.idquestao,
    qo.descricao,
    qo.quantidadeescalas,
    count(1) quantidade_opcoes
  from
    questao qo
  inner join opcao op on qo.idquestao = op.idquestao
  group by
    qo.idquestionario,
    qo.idquestao,
    qo.descricao,
    qo.quantidadeescalas
)
select
  qn.titulo,
  qo.descricao,
  qo.quantidade_opcoes,
  rownum ranking
from
  questionario qn
inner join qo on qn.idquestionario = qo.idquestionario
order by qo.quantidade_opcoes desc
fetch first 1 row only;

--------------------------------------------------------------------------------  
-- 2

select
  qn.descricao,
  qn_pre.descricao
from
  questionario qn
inner join prerequisito pr on qn.idquestionario = pr.idquestionario
inner join questionario qn_pre
on pr.idquestionarioprerequisito = qn_pre.idquestionario;

--------------------------------------------------------------------------------  
-- 3

select
  mes
from (
  select
    extract(month from qo.dataultimaalteracao) mes,
    count(1) alt_qtd
  from
    questao qo
  group by
    extract(month from qo.dataultimaalteracao)
)
where alt_qtd = 1;

--------------------------------------------------------------------------------  
-- 4

clear scr;
desc questionario;
desc questao;
desc opcao;

select
  qn.idquestionario,
  qn.datacriacao,
  qn.dataultimaalteracao,
  qn.descricao,
  qn.status,
  qn.titulo,
  qo.datacriacao,
  qo.dataultimaalteracao,
  qo.descricao,
  qo.idquestao,
  nvl(qo.quantidadeescalas, 0) quantidadeescalas,
  qo.tipoquestao,
  nvl(op.idopcao, 0) idopcao,
  nvl(op.conteudoopcao, 0) conteudoopcao
from
  opcao op
right join questao qo on op.idquestao = qo.idquestao
inner join questionario qn on qo.idquestionario = qn.idquestionario
order by length(qn.titulo) desc;

--------------------------------------------------------------------------------  
-- 5

clear scr;
desc questao;

select
  tipoquestao,
  count(1) qtd
from questao
where 
  to_char(dataultimaalteracao, 'MM/YYYY')
    = to_char(add_months(sysdate, -1), 'MM/YYYY')
group by tipoquestao, idquestao
order by
  qtd desc,
  idquestao desc
fetch first 3 rows only;














