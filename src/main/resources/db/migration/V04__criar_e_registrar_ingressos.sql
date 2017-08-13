CREATE TABLE ingresso (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	preco VARCHAR(50),
	quantidade INT,
	id_agenda INT references agenda(id)
)

INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Unissex', 'R$20,00', 1, 1);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Vip', 'R$40,00', 2,2);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão Superior', 'R$80,00', 3, 3);