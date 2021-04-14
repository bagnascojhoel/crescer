/*
Criar uma tabela de backup da tabela de pedido e item pedido
Pedido_Bkp, PedidoItem_Bkp
*/
create table pedido_bkp as select * from pedido;
create table pedidoitem_bkp as select * from pedidoitem;

/*
 1 - Qual estado teve mais venda em 2018, ordenar por estado
*/
desc pedido;
desc cliente;
desc cidade;
/* pedidos por estado */
select
  uf,
  count(1) pedidos
from cidade cd
inner join cliente cl on cd.idcidade = cl.idcidade
inner join pedido pd on cl.idcliente = pd.idcliente
where extract(year from pd.datapedido) = 2018
group by uf
order by uf;

/* estado com maior número de pedidos */
select uf
from
  (select
    uf,
    count(1) pedidos
  from cidade cd
  inner join cliente cl on cd.idcidade = cl.idcidade
  inner join pedido pd on cl.idcliente = pd.idcliente
  where extract(year from pd.datapedido) = 2018
  group by uf
  order by pedidos desc
  fetch first 1 row only)
order by uf;

/*
 2 - Saber todos os produtos que tem pedido em Janeiro de 2019, onde o pedido esta "C" ou "I"
 Só precisamos saber o Id do produto e o valor total deste produto vendido nestes pedidos.
*/
create or replace view vw_produtos_de_pedidos_cancelados_ou_inativos_janeiro_2019 as
  with pd as (select *
  from pedido pd
  where
    to_char(pd.datapedido, 'MM/YYYY') = '01/2019'
    and (
      upper(pd.situacao) = 'C'
      or upper(pd.situacao) = 'I'))
  select 
    pr.*,
    (pi.quantidade * pi.precounitario) valorVendidoTotal
  from pd
  inner join pedidoitem pi on pd.idpedido = pi.idpedido
  inner join produto pr on pi.idproduto = pr.idproduto;
  
  
select
  idproduto,
  valorVendidoTotal
from vw_produtos_de_pedidos_cancelados_ou_inativos_janeiro_2019;
  
/*
 3 - Saber todos os produtos que tem pedido em Janeiro de 2019, onde o pedido esta "C" ou "I"
 Só precisamos saber o Id do produto e o valor total deste produto vendido nestes pedidos.
 Agora quero o nome do produto junto
*/

select
  idproduto,
  nome,
  valorVendidoTotal
from vw_produtos_de_pedidos_cancelados_ou_inativos_janeiro_2019;

/*
 4 - Buscar todos empregados com seu departamento mesmo não tendo, e o nome do seu gerente mesmo que não tenha gerente
 Com salario entre 2500 a 5100
 Projetar Nome do empregado, nome do gerente(se tiver) e todos os campos da tabela departamento
*/ 
desc empregado;
desc departamento;

select
  e.nomeempregado,
  nvl(g.nomeempregado, '-') nomegerente,
  d.*
from empregado e
left join empregado g on e.idgerente = g.idempregado
left join departamento d on e.iddepartamento = d.iddepartamento
where e.salario between 2500 and 5100;

/*
 5 - do pedido 39969 produto 320
 Quero saber o nome do produto e os materiais dele (id e nome dos materiais)
*/
clear scr;
desc pedido;
desc produto;
desc pedidoitem;
desc produtomaterial;
desc material;

select 
  pr.nome,
  mt.idmaterial,
  mt.descricao
from material mt
inner join produtomaterial pm
on
  mt.idmaterial = pm.idmaterial
  and pm.idproduto = 320
inner join produto pr on pm.idproduto = pr.idproduto
inner join pedidoitem pi
on
  pr.idproduto = pi.idproduto
  and pi.idpedido = 39969;
--
--with pi as (
--  select *
--  from pedidoitem
--  where
--    idpedido = 39969
--    and idproduto = 320)
--select
--  pr.nome,
--  mt.idmaterial,
--  mt.descricao
--from pi
--inner join produtomaterial pm on pi.idproduto = pm.idproduto
--inner join material mt on pm.idmaterial = mt.idmaterial
--inner join produto pr on pi.idproduto = pr.idproduto;

/*
 6 - Criar uma function que passo o ID do cliente e retorna a RazaoSocial
 No select quero que retorne o nome do cliente e a RazaoSocial (usando a function)
*/

CREATE OR REPLACE FUNCTION BUSCA_RAZAOSOCIAL_CLIENTE (p_idcliente number)
  return cliente.razaosocial%type
is
  v_razaosocial cliente.razaosocial%type;
  v_nome_cliente cliente.nome%type;
begin
  select
    nome,
    razaosocial
  into 
    v_nome_cliente,
    v_razaosocial
  from cliente
  where idcliente = p_idcliente;
  
  return v_razaosocial;
end;

/*
 7 - Criar uma function que retorno o valor total do pedido, sendo calculado pelos seus itens
 Depois atualize todos os pedidos usando a function
*/
CREATE OR REPLACE FUNCTION PRECOTOTAL_ITEMPEDIDO
  (p_idpedido pedidoitem.idpedido%type)
  return number
is
  v_total number;
begin
  select sum(quantidade * precounitario) total
  into v_total
  from pedidoitem
  where idpedido = p_idpedido;
  
  return v_total;
end;

begin
  update pedido
  set valorpedido = PRECOTOTAL_ITEMPEDIDO(idpedido);
end;

/*
 8- Criar uma trigger para atualizar o pedido (valorpedido) quando atualizar ou deletar um item (pedidoitem)
*/
create or replace trigger tr_ajusta_pedido_valorpedido
  after
  update or delete
  on pedidoitem
  for each row
declare
  v_valorpedido_ajuste pedido.valorpedido%type := - (:old.quantidade * :old.precounitario);
begin
  
  if UPDATING then
    v_valorpedido_ajuste := + (:new.quantidade * :new.precounitario);
  end if;
  
  update pedido
  set valorpedido = valorpedido + v_valorpedido_ajuste;
  
end;
