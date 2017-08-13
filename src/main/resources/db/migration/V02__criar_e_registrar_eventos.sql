CREATE TABLE evento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	descricao VARCHAR(200),
	id_local BIGINT(20),
	FOREIGN KEY (id_local) REFERENCES local(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO evento (nome, descricao, id_local) values ('Improvável', 'A Cia. Barbixas de Humor é formada por Anderson Bizzocchi, Daniel Nascimento e Elidio Sanna', 1);
INSERT INTO evento (nome, descricao, id_local) values ('G7', 'Cia. de Comédia G7', 2 );
INSERT INTO evento (nome, descricao, id_local) values ('Melhores do Mundo', 'A cia. de comédia Os Melhores do Mundo é um grupo teatral cômico', 3);