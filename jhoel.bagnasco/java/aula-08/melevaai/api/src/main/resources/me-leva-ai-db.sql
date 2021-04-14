drop table ride;

drop table point;

drop table vehicle;

drop table driver;

drop table cnh;

drop table passenger;

drop table person;


create table person (
    person_id number generated always as identity,
    name varchar(60) not null,
    email varchar(30) not null,
    birth_date date not null,
    cpf varchar2(14) not null,
    virtual_wallet number(20,3) not null,
    avg_score number(1),
    constraint pk_person primary key (person_id)
);

create table passenger (
    passenger_id number generated always as identity,
    person_id number not null,
    constraint pk_passenger primary key (passenger_id),
    constraint fk_passenger_person foreign key (person_id) references person(person_id)
);

create table cnh (
    cnh_id number generated always as identity,
    "number" varchar(11) not null,
    "category" varchar(3) not null,
    due_date date not null,
    constraint pk_cnh primary key (cnh_id),
    constraint cc_cnh_category check ("category" in ('A', 'B', 'C', 'D', 'E', 'ACC'))
);

create table driver (
    driver_id number generated always as identity,
    person_id number not null,
    cnh_id number not null,
    constraint pk_driver primary key (driver_id),
    constraint fk_driver_person foreign key (person_id) references person(person_id),
    constraint fk_driver_cnh foreign key (cnh_id) references cnh(cnh_id)
);

create table vehicle (
    vehicle_id number generated always as identity,
    driver_id number not null,
    plate varchar(7) not null,
    brand varchar(30) not null,
    model varchar(30) not null,
    "year" number(4) not null,
    color varchar(15) not null,
    photo varchar(255) not null,
    "category" varchar(3) not null,
    qty_seats number(5) not null,
    constraint pk_vehicle primary key (vehicle_id),
    constraint fk_vehicle_driver foreign key (driver_id) references driver (driver_id),
    constraint cc_vehicle_category check ("category" in ('A', 'B', 'C', 'D', 'E', 'ACC'))
);

create table point (
    point_id number generated always as identity,
    x integer not null,
    y integer not null,
    constraint pk_point primary key (point_id)
);

create table ride (
    ride_id number generated always as identity,
    passenger_id number not null,
    vehicle_id number not null,
    start_point_id number not null,
    finish_point_id number not null,
    arrival_time number(5, 3),
    start_date_time date,
    finish_date_time date,
    real_price number(20, 3),
    expected_time number(5, 3),
    expected number(5, 3),
    status varchar(10) not null,
    driver_score number(1) not null,
    passenger_score number(1) not null,
    
    constraint pk_ride primary key (ride_id),
    constraint fk_ride_passenger foreign key (passenger_id) references passenger (passenger_id),
    constraint fk_ride_vehicle foreign key (vehicle_id) references vehicle (vehicle_id),
    constraint fk_ride_start_point foreign key (start_point_id) references point (point_id),
    constraint fk_ride_finish_point foreign key (finish_point_id) references point (point_id),
    constraint cc_ride_status check (status in ('CHAMADA', 'INICIADA', 'FINALIZADA'))
);

select * from passenger;
