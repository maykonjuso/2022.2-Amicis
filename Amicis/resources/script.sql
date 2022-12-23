create database Amicis;

create table contatos(
id int not null auto_increment primary key,
name varchar(40),
usuario varchar(40),
melhores_amigos boolean,
data_nascimento DATE TIME,
data_ingresso DATE TIME)