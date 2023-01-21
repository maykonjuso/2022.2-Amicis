CREATE TABLE usuario (
	id INT auto_increment,
	this_usuario varchar(100) UNIQUE,
	foto varchar(200),
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
	CONSTRAINT amigos_FK FOREIGN KEY (perfil) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT amigos_FK_1 FOREIGN KEY (amigo) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE bloqueados (
	perfil varchar(100),
	bloqueado varchar(100),
	CONSTRAINT bloqueados_PK PRIMARY KEY (perfil, bloqueado),
	CONSTRAINT bloqueados_FK FOREIGN KEY (perfil) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT bloqueados_FK_1 FOREIGN KEY (bloqueado) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE notificacao (
	id int NOT NULL AUTO_INCREMENT,
	usuario varchar(50),
	conteudo varchar(100),
	data DATETIME DEFAULT NOW(),
	CONSTRAINT id_PK PRIMARY KEY (id),
	CONSTRAINT usuario_FK FOREIGN KEY (usuario) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE conversa (
 	id int NOT NULL AUTO_INCREMENT,
 	remetente varchar(50),
	destinatario varchar(50),
	texto varchar(240),
	data DATETIME DEFAULT NOW(),
	CONSTRAINT id_PK PRIMARY KEY (id),
	KEY conversas_FK (remetente,destinatario),
	CONSTRAINT conversas_FK FOREIGN KEY (remetente, destinatario) REFERENCES amigos (perfil, amigo) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE publicacao (
	id INT auto_increment NOT NULL,
	foto varchar(200),
	usuario varchar(50),
	texto varchar(240),
	coracao INT,
	data DATETIME DEFAULT NOW(),
	CONSTRAINT publicacao_PK PRIMARY KEY (id),
	CONSTRAINT publicacao_FK FOREIGN KEY (usuario) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE coracoes (
	id_publicacao int,
	amigo varchar(100),
	CONSTRAINT coracao_PK PRIMARY KEY (id_publicacao, amigo),
	CONSTRAINT coracao_FK FOREIGN KEY (id_publicacao) REFERENCES publicacao(id) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT coracao_FK_1 FOREIGN KEY (amigo) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE resposta (
	id_publicacao INT,
	id INT auto_increment NOT NULL,
    foto varchar(200),
	usuario varchar(50),
	texto varchar(240),
	coracao INT,
	data DATETIME DEFAULT NOW(),
	CONSTRAINT publicacao_PK PRIMARY KEY (id),
	CONSTRAINT publicacao111_FK FOREIGN KEY (id_publicacao) REFERENCES publicacao(id) ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT publicacao11_FK FOREIGN KEY (usuario) REFERENCES perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE ticket (
	usuario varchar(50) NOT NULL,
	protocolo INT NOT NULL AUTO_INCREMENT,
    conteudo varchar(240),
	status varchar(100),
	severidade varchar(100),
	data DATETIME DEFAULT NOW(),
	CONSTRAINT ticket_PK PRIMARY KEY (protocolo),
	CONSTRAINT ticket_FK FOREIGN KEY (usuario) REFERENCES Amicis.perfil(usuario) ON UPDATE NO ACTION ON DELETE CASCADE
)