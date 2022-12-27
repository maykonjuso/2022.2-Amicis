create table usuario(
	id int auto_increment primary key,

	nome varchar(40),
	sobrenome varchar(40),
	this_usuario varchar(40),
	data_cadastro DATE,
	data_nascimento DATE,
	telefone varchar(20),
	email varchar(50),
	senha varchar(50)
);

create table perfil(
	id int auto_increment primary key,
	id_usuario int,

	status_online boolean,
	relacionamento varchar(50),
	localidade varchar(50),
	bio varchar(200),

	FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

create table amigo(
	id_perfil int primary key,
	amigo varchar(50),

	FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);

create table bloqueado(
	id_perfil int primary key,
	bloqueado varchar(50),

	FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);



