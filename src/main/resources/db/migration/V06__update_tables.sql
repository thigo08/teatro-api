ALTER TABLE evento add column genero VARCHAR(100);

UPDATE evento SET genero = 'STANDUP' WHERE id = 1;
UPDATE evento SET genero = 'STANDUP' WHERE id = 2;
UPDATE evento SET genero = 'STANDUP' WHERE id = 3;

INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone, latitude, longitude) values ('Centro de Convenções Ulysses Guimarães', 'St. de Divulgação Cultural 05', 'Eixo Monumental', 'Brasília', 'DF', '(61) 3214-2712', '-15.788229', '-47.9005925');
INSERT INTO local (nome, endereco, complemento, cidade, estado, telefone, latitude, longitude) values ('Teatro Funarte Plinio Marcos', 'Setor de Divulgação Cultural, Lt 2', 'Eixo Monumental', 'Brasília', 'DF', '(61) 3322-2032', '-15.7892487', '-47.8967354');

INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Ceará Dando as Caras', 'Wellington Muniz, o Ceará', 5, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fceara-dando-as-caras-porto-velho-2017.jpg?alt=media&token=44a87bb3-03a0-41c7-bdd7-ce820b969260', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Clarice Lispector em Movimentos', 'Clarice Lispector (1920-1977)', 6, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Faqui_tem_diversao_clarice_lispector_em_movimentos.jpg?alt=media&token=71d408a5-b7c0-4922-9afc-38a9d1e5bcb0', 'MONOLOGO');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Branca de Neve ao som dos Beatles', 'Trilha sonora dos BEATLES', 3, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fdownload%20(1).jpg?alt=media&token=47c3058e-30d7-4af0-9c4e-88e1fd93632b', 'MUSICAL');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Paulinho Gogó', 'No show fato venério!', 1, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fdownload%20(2).jpg?alt=media&token=abd748f5-9c36-4d5b-b2bd-5fa74937b245', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Minha Mãe é uma Peça', 'Do cinema para o Teatro', 5, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fdownload%20(3).jpg?alt=media&token=340d4dc5-179e-4af7-bc62-8a8f0b08f71f', 'STANDUP');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Ciclo Sinfônico', 'MENDELSSOHN', 1, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fdestaque-487934-orquestra-sinfonica-brasilia.jpg?alt=media&token=3420bb4a-adf0-4db4-bf27-42d79289cf8a', 'SHOW');
INSERT INTO evento (nome, descricao, id_local, imagem, genero) values ('Luiz Gama', 'UMA VOZ PELA LIBERDADE', 1, 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2FPhotoGrid_1504150166398.jpg?alt=media&token=4eab06c3-1523-45ca-9eca-c76901dd24dc', 'DRAMA');

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
