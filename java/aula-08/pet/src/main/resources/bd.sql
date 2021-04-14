CREATE TABLE condominio 
  ( 
     id         NUMBER(10) PRIMARY KEY NOT NULL, 
     nome       VARCHAR(50) NOT NULL, 
     aceita_pet NUMBER(1) NOT NULL 
  ); 

CREATE SEQUENCE seq_condominio 
  START WITH 1 
  INCREMENT BY 1; 

INSERT INTO condominio 
VALUES      (seq_condominio.NEXTVAL, 
             'Teste 1', 
             0); 

DROP TABLE pessoa; 

DROP SEQUENCE seq_pessoa; 

CREATE TABLE pessoa 
  ( 
     id            NUMBER(10) PRIMARY KEY NOT NULL, 
     nome          VARCHAR(50) NOT NULL, 
     cor           VARCHAR(50) NOT NULL, 
     id_condominio NUMBER(10) NOT NULL 
  ); 

ALTER TABLE pessoa 
  ADD CONSTRAINT fk_condominio FOREIGN KEY (id_condominio) REFERENCES condominio 
  (id); 

CREATE SEQUENCE seq_pessoa 
  START WITH 1 
  INCREMENT BY 1; 

INSERT INTO pessoa 
VALUES      (seq_pessoa.NEXTVAL, 
             'Pessoa VERMELHO', 
             'VERMELHO', 
             1); 