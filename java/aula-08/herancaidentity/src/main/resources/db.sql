CREATE TABLE z_pessoa (
	id number(10) GENERATED ALWAYS AS IDENTITY,
    nome varchar(50) not null
);

CREATE TABLE z_pessoa_fisica (
	id number(10) PRIMARY KEY,
    cpf varchar2(11) not null
);

CREATE TABLE z_pessoa_juridica (
	id number(10) PRIMARY KEY,
    cnpj varchar2(14) not null,
    nome_fantasia varchar2(100) not null
);