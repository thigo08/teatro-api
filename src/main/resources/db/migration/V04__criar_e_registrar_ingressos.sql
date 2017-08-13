CREATE TABLE ingresso (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	preco VARCHAR(50),
	quantidade BIGINT(20),
	id_agenda BIGINT(20),
	FOREIGN KEY (id_agenda) REFERENCES agenda(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Unissex', 'R$20,00', 1, 1);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Vip', 'R$40,00', 2,2);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Superior', 'R$80,00', 3, 3);