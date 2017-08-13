CREATE TABLE local (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	endereco VARCHAR(50),
	complemento VARCHAR(50),
	cidade VARCHAR(50),
	estado VARCHAR(50),
	telefone VARCHAR(50)
)

INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone) values ('Teatro dos Bancários', 'Setor EQS 314/315 Bloco A', 'Asa Sul', 'Brasília', 'DF', '(61)3262-9090');
INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone) values ('Teatro UNIP', 'SGAS 913', 'Asa Sul', 'Brasília', 'DF', '(61)3041-5581');
INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone) values ('Teatro da Caesb', '1846, Col. Agrícola', 'Aguás Claras', 'Brasília', 'DF', '(61)3213-7204');
