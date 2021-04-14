-- 1
create table AlunoAula1 (
    nome varchar(50) not null,
    data_nascimento date not null,
    cidade varchar(50) not null,
    cpf char(11) not null,
    matricula number not null,
    curso_matriculado varchar(50) not null
);
-- 2
create table CursoAula1 (
    nome varchar(50) not null,
    data date not null,
    situacao varchar(50) not null,
    pre_requisitos char(1) not null,
    local varchar(100) not null
);
-- 3
alter table CursoAula1 add valor number(38,19);
-- 4
alter table AlunoAula1 add constraint PK_Matricula primary key (matricula);
alter table CursoAula1 add id number generated always as identity;
alter table CursoAula1 add constraint PK_Curso primary key (id);
alter table AlunoAula1 modify curso_matriculado number;
alter table AlunoAula1 add constraint FK_Curso_Matriculado foreign key (curso_matriculado) references CursoAula1 (id);
    
create table PreRequisitos (
    id number generated always as identity,
    curso_id number not null,
    curso_requisito_id number not null,
    constraint FK_Curso_id foreign key (curso_id) references CursoAula1 (id),
    constraint FK_Curso_requisito_id foreign key (curso_requisito_id) references CursoAula1 (id)
);

-- 5

--Todo aluno precisa estar matriculado em algum curso. Um curso pode ter n outros 
--cursos como pre-requisitos, o que força a criação de uma tabela auxiliar que 
--conterá a relação n x n que um curso pode ter consigo.

drop table Prerequisitos;
drop table cursoaula1;
drop table alunoaula1;