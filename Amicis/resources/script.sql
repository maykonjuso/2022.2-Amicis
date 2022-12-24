create database Amicis;

create table contatos(
id int not null auto_increment primary key,
nome not null varchar(40),
usuario not null varchar(40),
melhores_amigos boolean,
data_nascimento not null DATE TIME,
data_ingresso not null DATE TIME )