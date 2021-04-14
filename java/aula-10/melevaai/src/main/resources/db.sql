DROP TABLE mla_motorista;
DROP TABLE mla_pessoa;
DROP TABLE mla_cnh;

DROP SEQUENCE mla_seq_pessoa;
DROP SEQUENCE mla_seq_cnh;

CREATE TABLE mla_pessoa (
	id number(10) PRIMARY KEY,
    cpf varchar2(11) not null,
    nome varchar(50) not null
);

CREATE TABLE mla_cnh (
	id number(10) PRIMARY KEY,
	numero varchar(50) not null
);

CREATE TABLE mla_motorista (
	id number(10) PRIMARY KEY,
	id_cnh number(10),
	endereco varchar(50) not null,
	CONSTRAINT mla_motorista_fk_id_pessoa FOREIGN KEY (id) REFERENCES mla_pessoa(id),
	CONSTRAINT mla_motorista_fk_id_cnh FOREIGN KEY (id_cnh) REFERENCES mla_cnh(id)
);

CREATE SEQUENCE mla_seq_pessoa START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE mla_seq_cnh START WITH 1 INCREMENT BY 1;

insert into mla_pessoa values (mla_seq_pessoa.nextval, '11111111111', 'Pessoa A');

insert into mla_cnh values (mla_seq_cnh.nextval, '11111');

insert into mla_motorista values (
(select id from mla_pessoa where cpf = '11111111111'),
(select id from mla_cnh where numero = '11111'),
'endereço motorista A');

select * from mla_pessoa;
select * from mla_cnh;
select * from mla_motorista;
