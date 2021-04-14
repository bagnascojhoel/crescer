-- 1
desc lic_contratante;
desc lic_cidade;

select
  p.idcontratante Contratante,
  p.nome Nome,
  case
    when lower(p.esfera) = 'm' then 'Municipal'
    when lower(p.esfera) = 'e' then 'Estadual'
  end Esfera,
  f.nome Cidade,
  f.uf Estado
from
  lic_contratante p
inner join lic_cidade f on p.idcidade = f.idcidade
where lower(f.nome || f.uf) = 'santossp';

--------------------------------------------------------------------------------
-- 2

desc lic_empresa;
desc lic_cidade;

select
  m.nome Empresa,
  f.nome Cidade
from
  lic_empresa m
inner join lic_cidade f on m.idcidade = f.idcidade
where
  m.cnpj like '%86';
  
select
  m.nome Empresa,
  f.nome Cidade  
from
  lic_empresa m
inner join lic_cidade f on m.idcidade = f.idcidade
where
  substr(m.cnpj, (length(m.cnpj) -1), length(m.cnpj)) = '86';
  
--------------------------------------------------------------------------------
-- 3

desc lic_item_licitacao;
desc lic_material;

select
  rpad(f.nome, 20) Material,
  m.quantidade Quantidade,
  ((((m.valor_maximo
  - m.valor_minimo)
  /2
  )+ m.valor_minimo)
  * m.quantidade) ValorMedioTotal
from
  lic_item_licitacao m
inner join lic_material f on m.idmaterial = f.idmaterial
where
  m.idlicitacao = 60
order by m.quantidade;

--------------------------------------------------------------------------------
-- 4

clear scr;
desc lic_licitacao;
desc lic_item_licitacao;
desc lic_material;
desc lic_classe_material;

with f as (
  select
    m.idlicitacao,
    m.quantidade,
    f.nome_material,
    f.nome_classe_material
  from
    lic_item_licitacao m
  inner join (
    select
      m1.idmaterial,
      m1.nome nome_material,
      f1.nome nome_classe_material
    from
      lic_material m1
    inner join lic_classe_material f1
      on m1.idclasse_material = f1.idclasse_material
  ) f on m.idmaterial = f.idmaterial
)
select
  m.titulo "Titulo",
  to_char(m.inicio_vigencia, 'DD/MM/YYYY') "Inicio Vigencia",
  f.quantidade "Quantidade",
  f.nome_material "Nome Material",
  f.nome_classe_material "Nome Classe Material"
from
  lic_licitacao m
inner join f on m.idlicitacao = f.idlicitacao
where
  m.idcontratante = 408
  and to_char(m.data_fechamento, 'MM-YYYY') = '03-2018';

--------------------------------------------------------------------------------
-- 5

clear scr;
desc lic_proposta;

select
  (max(prop.valor_final) - min(prop.valor_final)) "Diferença",
  prop.idlicitacao "Id Licitação"
from
  lic_proposta prop
group by
  prop.idlicitacao
order by
  "Diferença" desc;

--------------------------------------------------------------------------------
-- 6

clear scr;
desc lic_proposta;
desc lic_empresa;
desc lic_licitacao;
desc lic_cidade;
desc lic_item_licitacao;
desc lic_material;

select
  proposta.idproposta "ID Proposta",
  proposta.data_inscricao "Data de inscrição da proposta",
  empresa.nome "Nome da Empresa",
  empresa.cidade_nome "Nome da Cidade da Empresa",
  empresa.cidade_uf "Estado da Empresa",
  case
    when (empresa.cnpj is null) then empresa.cpf
    when (empresa.cpf is null)  then empresa.cnpj  
  end "CPF / CNPJ",
  licitacao.titulo "Título da Licitação",
  licitacao.situacao "Situação da Licitação",
  licitacao.item_licitacao_quantidade "Quantidade por Item",
  licitacao.item_licitacao_observacao "Obervação por Item",
  licitacao.item_licitacao_material_nome "Nome do Material"
from
  lic_proposta proposta
inner join (
  select
    empresa.idempresa,
    empresa.nome nome,
    empresa.cnpj cnpj,
    empresa.cpf cpf,
    cidade.nome cidade_nome,
    cidade.uf cidade_uf
  from
    lic_empresa empresa
  inner join lic_cidade cidade on empresa.idcidade = cidade.idcidade
) empresa on proposta.idempresa = empresa.idempresa
inner join (
  select
    lic.idlicitacao,
    lic.titulo,
    lic.situacao,
    it_lic.quantidade item_licitacao_quantidade,
    it_lic.observacao item_licitacao_observacao,
    it_lic.material_nome item_licitacao_material_nome
  from
    lic_licitacao lic
  inner join (
    select
      item.idlicitacao,
      item.quantidade,
      item.observacao,
      mat.nome material_nome
    from
      lic_item_licitacao item
    inner join lic_material mat on item.idmaterial = mat.idmaterial
  ) it_lic on lic.idlicitacao = it_lic.idlicitacao
) licitacao on proposta.idlicitacao = licitacao.idlicitacao;

--------------------------------------------------------------------------------
-- 7

clear scr;
desc lic_material;
desc lic_item_licitacao;

select
  count(1) quantidade
from
  lic_material
where
  idmaterial not in (
    select
      idmaterial
    from
      lic_item_licitacao
  );

select
  count(1) quantidade
from
  lic_material mat
left join lic_item_licitacao it_lic on mat.idmaterial = it_lic.idmaterial
where
  it_lic.idlicitacao is null;

--------------------------------------------------------------------------------
-- 8

clear scr;
desc lic_contratante;

create table lic_contratante_copy as select * from lic_contratante;

INSERT INTO lic_contratante (NOME,IDCIDADE,ESFERA) values ('Teste1',3812,'T');
/*
  *Não funiona* pois o valor pasaado para a coluna ESFERA não respeita a 
  CONSTRAINT de check que aceita apenas os valores 'E', 'F' e 'M'.
*/

INSERT INTO lic_contratante (NOME,IDCIDADE,ESFERA) values ('Teste2',9999,'E');
/* 
  *Não funciona* pois a coluna IDCIDADE possui uma CONSTRAINT de FOREIGN KEY e o
  valor provisionado para essa coluna não representa um valor válido na sua 
  respective coluna da tabela LIC_CIDADE.
*/

INSERT INTO lic_contratante (IDCONTRATANTE,NOME,IDCIDADE,ESFERA) values (9999,'Teste3',3812,'E');
/*
  *Funciona* pois todas CONSTRAINTS são satisfeitas e os valores são válidos.
*/

INSERT INTO lic_contratante (NOME,IDCIDADE,ESFERA) values ('Teste4',3812,'E');  
/*
  *Funciona* pois todas CONSTRAINTS são satisfeitas e os valores são válidos. 
  Como a tabela LIC_CONTRATANTE possui uma TRIGGER que toma a responsabilidade
  de criação de um valor válido para IDCONTRATANTE, executada para cada
  registro inserido na tabela, um registro não precisa ser inserido com um valor
  para IDCONTRATANTE.
*/

  
drop table lic_contratante_copy;

  
  

