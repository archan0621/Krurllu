show databases;

create database KRULLU_DB;

ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

FLUSH PRIVILEGES;

use KRULLU_DB;

create table chk(
        PID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        test int
);

insert into chk value(1,1);

show tables;

desc members;

select * from members;

show tables;
