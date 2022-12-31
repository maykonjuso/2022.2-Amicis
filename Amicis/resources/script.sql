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
	usuario varchar(50),
    status_online boolean,
	bio varchar(200),
	relacionamento varchar(50),
	localidade varchar(50),
	termos_uso varchar(240),
	politicas varchar(240),
	PRIMARY KEY (usuario),
	CONSTRAINT perfil_FK FOREIGN KEY (usuario) REFERENCES usuario(this_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE amigos (
	perfil varchar(100),
	amigo varchar(100),
	CONSTRAINT amigos_PK PRIMARY KEY (perfil, amigo),
	CONSTRAINT amigos_FK FOREIGN KEY (perfil) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT amigos_FK_1 FOREIGN KEY (amigo) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE bloqueados (
	perfil varchar(100),
	bloqueado varchar(100),
	CONSTRAINT bloqueados_PK PRIMARY KEY (perfil, bloqueado),
	CONSTRAINT bloqueados_FK FOREIGN KEY (perfil) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT bloqueados_FK_1 FOREIGN KEY (bloqueado) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE notificacao (
	id int NOT NULL AUTO_INCREMENT,
	usuario varchar(50),
	conteudo varchar(100),
	data DATETIME DEFAULT NOW(),
	CONSTRAINT id_PK PRIMARY KEY (id),
	CONSTRAINT usuario_FK FOREIGN KEY (usuario) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE conversa (
 	id int NOT NULL AUTO_INCREMENT,
 	remetente varchar(50),
	destinatario varchar(50),
	texto varchar(240),
	data DATETIME DEFAULT NOW(),
	CONSTRAINT id_PK PRIMARY KEY (id),
	KEY conversa_FK (remetente),
	KEY conversa_FK_1 (destinatario),
	CONSTRAINT conversa_FK FOREIGN KEY (remetente) REFERENCES perfil (usuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT conversa_FK_1 FOREIGN KEY (destinatario) REFERENCES perfil (usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE publicacao (
	id INT auto_increment NOT NULL,
	usuario varchar(50),
	texto varchar(240),
	coracao INT,
	data DATETIME DEFAULT NOW(),
	CONSTRAINT publicacao_PK PRIMARY KEY (id),
	CONSTRAINT publicacao_FK FOREIGN KEY (usuario) REFERENCES perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ticket (
	usuario varchar(50) NOT NULL,
	data DATETIME DEFAULT NOW(),
	protocolo INT,
	status varchar(100),
	severidade varchar(100),
	CONSTRAINT ticket_PK PRIMARY KEY (protocolo),
	CONSTRAINT ticket_FK FOREIGN KEY (usuario) REFERENCES Amicis.perfil(usuario) ON DELETE CASCADE ON UPDATE CASCADE
)