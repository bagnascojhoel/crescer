drop TABLE a_pessoa_fisica;
drop TABLE a_pessoa_juridica;

CREATE TABLE a_pessoa_fisica (
	id number(10) PRIMARY KEY,
    cpf varchar2(11) not null,
    nome varchar(50) not null
);

CREATE TABLE a_pessoa_juridica (
	id number(10) PRIMARY KEY,
    cnpj varchar2(14) not null,
    nome_fantasia varchar2(100) not null,
    nome varchar(50) not null
);

CREATE SEQUENCE a_seq_pessoa START WITH 1 INCREMENT BY 1;
