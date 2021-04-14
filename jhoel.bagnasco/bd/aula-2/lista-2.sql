-- 1
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);


insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 1, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 2, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 3, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 4, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 5, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 6, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 7, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 8, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 9, 1);
insert into AlunoAula1
    (nome, data_nascimento, cidade, cpf, matricula, curso_matriculado)
    values ('Jonas', sysdate, 'Canoas', '12345678912', 10, 1);

-- 2
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);
insert into CursoAula1
    (nome, data, situacao, pre_requisitos, local, valor)
    values ('CIC', sysdate, 'Aprovado', 'S', 'Vale', 30.5);

-- 3

update CursoAula1 set situacao = 'Ativo';
        
-- 4

-- update Cliente set situacao = 'P' where situacao = 'I';-- deveria ser A?
update Cliente set situacao = 'A' where situacao = 'I'; 

-- 5

delete associadoex where sexo = 'M';

-- 6

update CursoAula1 set valor = (valor * 1.05);

    
    