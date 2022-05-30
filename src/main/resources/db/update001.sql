create table person (
    id serial primary key not null,
    login varchar(2000),
    password varchar(2000),
    employee_id int references employee(id)
);

create table employee (
    id serial primary key not null ,
    name varchar(256),
    surname varchar(256),
    INN varchar(20),
    hiring_date timestamp
);

insert into person (login, password, employee_id) values ('Tom', '123', 1);
insert into person (login, password, employee_id) values ('Kik', '123', 1);
insert into person (login, password, employee_id) values ('Ross', '123', 2);

insert into employee (name, surname, INN, hiring_date) VALUES ('vlad', 'vladvlad', '123456', now());
insert into employee (name, surname, INN, hiring_date) VALUES ('ivan', 'ivanov', '12345678', now());
