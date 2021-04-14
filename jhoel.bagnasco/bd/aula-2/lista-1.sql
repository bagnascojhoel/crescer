-- 1
create table CidadeAux as select * from CidadeEx;
select count(all 1) from CidadeAux;

-- 2
truncate table CidadeAux;
insert into CidadeAux (
    select * from CidadeEx where UF = 'RS'
);

-- 3 

insert into EstoqueEx (name, creation_date, capacity, active)
    values ('Jonas', sysdate, 30, 'S');
    
-- 4
insert into ProdutoEx
    (name, description, creation_date, idestoque, quantity, price)
    values ('Item 1', 'Descrição', sysdate, 1, 50, 30.5);
insert into ProdutoEx
    (name, description, creation_date, idestoque, quantity, price)
    values ('Item 2', 'Descrição', sysdate, 1, 50, 30.5);
    
-- 5
update AssociadoEx set 
    cpf = '12345678911',
    endereco = 'Endereço atualizado',
    bairro = 'Bairro atualizado',
    complemento = 'Compl. atualizado',
    idcidade = (select idcidade from cidadeex where nome = 'Taquara')
    where idassociado = 1;
    
-- 6
delete CidadeEx where nome = 'Campinas' and uf = 'SP';
delete CidadeEx where nome = 'Taquara' and uf = 'RS'; -- should break