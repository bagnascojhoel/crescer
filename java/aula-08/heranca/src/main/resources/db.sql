DROP TABLE pessoa_fisica;
DROP TABLE pessoa_juridica;
DROP SEQUENCE seq_pessoa;

CREATE TABLE pessoa (
    id number(10) primary key not null,
    nome varchar(50) not null
);
CREATE SEQUENCE seq_pessoa START WITH 1 INCREMENT BY 1;

CREATE TABLE pessoa_fisica (
	id number(10) primary key not null,
    cpf varchar2(11) not null
);
ALTER TABLE pessoa_fisica ADD CONSTRAINT fk_pessoa_fisica_pessoa FOREIGN KEY (id) REFERENCES pessoa(id);

CREATE TABLE pessoa_juridica (
	id number(10) primary key not null,
    cnpj varchar2(14) not null,
    nome_fantasia varchar2(100) not null
);
ALTER TABLE pessoa_juridica ADD CONSTRAINT fk_pessoa_juridica_pessoa FOREIGN KEY (id) REFERENCES pessoa(id);

select * from pessoa;
select * from pessoa_fisica;
select * from pessoa_juridica;