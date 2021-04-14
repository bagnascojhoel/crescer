create table ListaTres_User(
    user_id number generated always as identity,
    username varchar(30) not null unique,
    password varchar(30) not null,
    role varchar(15) not null,
    constraint PK_User primary key (id),
    constraint Check_Role check (role in ('usuario', 'operador', 'gerente', 'administrador'))
);

create table ListaTres_Department (
   department_id number generated always as identity,
   name varchar(50) not null,
   constraint PK_Department primary key (department_id)
);

create table ListaTres_Services (
    service_id number generated always as identity,
    description varchar(100) not null,
    department_id number not null,
    constraint PK_Service primary key (service_id),
    constraint FK_Department foreign key (department_id) references ListaTres_Department (department_id)
);

create table ListaTres_Ticket (
    ticket_id number generated always as identity,
    execution_date date not null,
    description varchar(300) not null,
    service_id number not null,
    user_id number not null,
    constraint PK_Ticket primary key (ticket_id),
    constraint FK_Service foreign key (service_id) references ListaTres_Services (service_id),
    constraint FK_User foreign key (user_id) references ListaTres_User (user_id)
);

create table ListaTres_StatusUpdate (
    status_update_id number generated always as identity,
    description varchar(30) not null,
    update_time timestamp not null,
    ticket_id number not null,
    constraint PK_Status primary key (status_update_id),
    constraint FK_Ticket foreign key (ticket_id) references ListaTres_Ticket (ticket_id),
    constraint Check_Description check (description in ('aberto', 'atribuído', 'andamento', 'espera por usuário', 'espera por suporte', 'canelado', 'resolvido'))
);