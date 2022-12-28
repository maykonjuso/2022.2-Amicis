CREATE TABLE usuario (
	id INT auto_increment,
	this_usuario varchar(100) UNIQUE,
	nome varchar(50) ,
	sobrenome varchar(50),
	email varchar(100) UNIQUE,
	telefone varchar(20),
	dataNascimento DATE,
	senha varchar(100),
	dataCadastro DATETIME DEFAULT NOW(),
	CONSTRAINT id_PK PRIMARY KEY (id)
);

CREATE TABLE perfil (
  id_usuario int,
  status_online boolean,
  bio varchar(200),
  relacionamento varchar(50),
  localidade varchar(50),
  PRIMARY KEY (id_usuario),
  CONSTRAINT perfil_FK FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE amigos (
	id_perfil INT,
	id_amigo INT,
	CONSTRAINT amigos_PK PRIMARY KEY (id_perfil,id_amigo),
	CONSTRAINT amigos_FK FOREIGN KEY (id_perfil) REFERENCES perfil(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT amigos_FK_1 FOREIGN KEY (id_amigo) REFERENCES perfil(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE bloqueados (
	id_perfil INT,
	id_bloqueado INT,
	CONSTRAINT bloqueados_PK PRIMARY KEY (id_perfil,id_bloqueado),
	CONSTRAINT bloqueados_FK FOREIGN KEY (id_perfil) REFERENCES perfil(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT bloqueados_FK_1 FOREIGN KEY (id_bloqueado) REFERENCES perfil(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);