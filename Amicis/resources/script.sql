create table usuario(
	id int not null auto_increment primary key,
	nome varchar(40) not null,
	sobrenome varchar(40) not null,
	this_usuario varchar(40) not null,
	data_cadastro DATE not null,
	data_nascimento DATE not null,
	telefone varchar(20) not null,
	email varchar(50) not null,
	senha varchar(50) not null
);

create table perfil(
	id int not null auto_increment primary key,
	id_usuario int,
	bio varchar(200),
	id_usuario_seguidor varchar(40),
	id_usuario_seguindo varchar(40),
	
	FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

create table seguidor(
	id_perfil int,
	FOREIGN KEY (id_perfil) REFERENCES usuario(id)
);

create table seguindo(

);

create table status(

);