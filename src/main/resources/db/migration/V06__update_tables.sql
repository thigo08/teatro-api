ALTER TABLE evento add column genero VARCHAR(100);

UPDATE evento SET genero = 'STANDUP' WHERE id = 1;
UPDATE evento SET genero = 'STANDUP' WHERE id = 2;
UPDATE evento SET genero = 'STANDUP' WHERE id = 3;

INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone, latitude, longitude) values ('Centro de Convenções Ulysses Guimarães', 'St. de Divulgação Cultural 05', 'Eixo Monumental', 'Brasília', 'DF', '(61) 3214-2712', '-15.788229', '-47.9005925');
INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone, latitude, longitude) values ('Teatro Funarte Plinio Marcos', 'Setor de Divulgação Cultural, Lt 2', 'Eixo Monumental', 'Brasília', 'DF', '(61) 3322-2032', '-15.7892487', '-47.8967354');

INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Ceará Dando as Caras', 'Wellington Muniz, o Ceará', 5, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/17737a.jpg', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Clarice Lispector em Movimentos', 'Clarice Lispector (1920-1977)', 6, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/18690a.jpg', 'MONOLOGO');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Branca de Neve ao som dos Beatles', 'Trilha sonora dos BEATLES', 3, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/19161a.jpg', 'MUSICAL');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Paulinho Gogó', 'No show fato venério!', 1, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/18486a.jpg', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Minha Mãe é uma Peça', 'Do cinema para o Teatro', 5, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/17621a.png', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Ciclo Sinfônico', 'MENDELSSOHN', 1, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/18546a.jpg', 'SHOW');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Luiz Gama', 'UMA VOZ PELA LIBERDADE', 1, 'https://cdn.bilheteriadigital.com/bilheteriadigital/eventos/19052a.jpg', 'DRAMA');

INSERT INTO agenda (data, horario, id_evento) values ('2017-09-08', '21:00', 4);
INSERT INTO agenda (data, horario, id_evento) values ('2017-07-22', '20:00', 5);
INSERT INTO agenda (data, horario, id_evento) values ('2017-07-23', '15:00', 6);
INSERT INTO agenda (data, horario, id_evento) values ('2017-07-24', '19:00', 7);
INSERT INTO agenda (data, horario, id_evento) values ('2017-08-02', '20:00', 8);
INSERT INTO agenda (data, horario, id_evento) values ('2017-08-19', '19:30', 9);
INSERT INTO agenda (data, horario, id_evento) values ('2017-08-09', '21:00', 10);

INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Poltrona Especial', 'R$60,00', 10, 4);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Ingresso (Meia)', 'R$20,00', 20,5);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Poltrona', 'R$30,00', 30, 6);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Sessão', 'R$50,00', 10, 7);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Poltrona Superior', 'R$100,00', 20,8);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Ingresso Inteira', 'R$20,00', 40, 9);
INSERT INTO ingresso (nome, preco, quantidade, id_agenda) values ('Ingresso Unissex', 'R$40,00', 50, 10);
