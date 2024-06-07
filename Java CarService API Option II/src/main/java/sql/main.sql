create database car_service;

use car_service;

create table car(
                    car_id bigint primary key auto_increment,
                    make varchar(255),
                    model varchar(255),
                    year int,
                    licence_plate varchar(255),
                    owner_id bigint,
                    appointments bigint,
                    foreign key (owner_id) references customer(customer_id),
                    foreign key (appointments) references appointment(appointment_id)
);

create table customer(
                         customer_id bigint primary key auto_increment,
                         name varchar(255),
                         email varchar(255),
                         phone varchar(255),
                         car_id bigint,
                         appointment_id bigint,
                         foreign key (car_id) references car(car_id),
                         foreign key (appointment_id) references appointment(appointment_id)
);

create table appointment(
                            appointment_id bigint primary key auto_increment,
                            car_id bigint,
                            customer_id bigint,
                            service_id varchar(255),
                            appointment_time varchar(255)
);