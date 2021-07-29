create database if not exists Library;

use Library;

create table if not exists books(
id int auto_increment not null,
author varchar(100) not null,
title varchar(100) not null,
year int not null,
pages int not null,
amount int,
created_at timestamp default current_timestamp,
last_updated timestamp default current_timestamp,
primary key(id)
);

select * from books;