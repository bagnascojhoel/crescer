-- 1
create table ProdutoExercicioUm (
    ID number generated always as identity,
    name varchar(30) not null,
    description varchar(200) not null,
    creation_date date not null,
    location varchar(30) not null,
    quantity int not null,
    price number(38,12) not null
);

-- 2
create table EstoqueExercicioDois (
    id number generated always as identity,
    name varchar(30) not null,
    creation_date date not null,
    capacity number(38,0) not null,
    active char(1) not null,
    constraint CC_EstoqueExercicioDois check (active in ('S','N'))
);

-- 3
alter table ProdutoExercicioUm modify location int;

-- 4
alter table ProdutoExercicioUm rename column location to IdEstoque;

-- 5
alter table ProdutoExercicioUm add constraint PK_ProdutoExercicioUm primary key (id);
alter table EstoqueExercicioDois add constraint PK_EstoqueExercicioDois primary key (id);

--6
alter table ProdutoExercicioUm add
    constraint FK_ProdutoExercicioUm_EstoqueExercicioDois foreign key (IdEstoque)
    references EstoqueExercicioDois (id);
    
-- 7 

-- 8 
rename ProdutoExercicioUm to ProdutoEx;
rename EstoqueExercicioDois to EstoqueEx;

------
--drop table ProdutoEx;
--drop table EstoqueEx;