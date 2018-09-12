ALTER TABLE evento add column elenco VARCHAR(500);
ALTER TABLE evento add column ficha VARCHAR(500);
ALTER TABLE evento add column duracao VARCHAR(500);

UPDATE evento SET elenco = 'Anderson Bizzochi, Daniel Nascimento e Elidio Sanna' WHERE id = 1;
UPDATE evento SET ficha = 'Texto: Cia. de Humor Barbixas' WHERE id = 1;
UPDATE evento SET duracao = '80 min' WHERE id = 1;

UPDATE evento SET elenco = 'Benetti Mendes, Felipe Gracindo, Frederico Braga e Rodolfo Cordón' WHERE id = 2;
UPDATE evento SET ficha = 'Texto: O Grupo G7' WHERE id = 2;
UPDATE evento SET duracao = '80 min' WHERE id = 2;

UPDATE evento SET elenco = 'Adriana Dos Santos Nunes, Adriano Camanho de Assis, Jovane Mendes Nunes, Ricardo Curi Garcia, Victor Ulysses Machado Leal e Welder Rodrigues Bonfim' WHERE id = 3;
UPDATE evento SET ficha = 'Texto: A cia. de comédia Os Melhores do Mundo' WHERE id = 3;
UPDATE evento SET duracao = '60 min' WHERE id = 3;

UPDATE evento SET elenco = 'Wellington Muniz' WHERE id = 4;
UPDATE evento SET ficha = 'Texto: Pânico' WHERE id = 4;
UPDATE evento SET duracao = '90 min' WHERE id = 4;

UPDATE evento SET elenco = 'À frente dos 16 bailarinos de sua companhia, Jana mostra um bailado particular de Lispector.' WHERE id = 5;
UPDATE evento SET ficha = 'Texto: Adaptação de Jana Marques, diretora carioca radicada em Brasília' WHERE id = 5;
UPDATE evento SET duracao = '90 min' WHERE id = 5;

UPDATE evento SET elenco = 'Elenco: Ana Cris Gomes, Mariana Faloppa, Lenon, Ferrucio Cornachia, Charlie Larroca e Myriam Pimentel.' WHERE id = 6;
UPDATE evento SET ficha = 'História: Irmãos Grimm. Texto, Direção, Iluminação e Bonecos: Leandro Mariz. Direção Geral: Sabrina Korgut. Figurinos: Reinaldo Patrício' WHERE id = 6;
UPDATE evento SET duracao = '70 min' WHERE id = 6;

UPDATE evento SET elenco = 'O humorista Maurício Manfrini, que interpreta o personagem Paulinho Gogó' WHERE id = 7;
UPDATE evento SET ficha = 'Texto: Como diz o personagem: “Quem não tem dinheiro conta história!”' WHERE id = 7;
UPDATE evento SET duracao = '90 min' WHERE id = 7;

UPDATE evento SET elenco = 'Paulo Gustavo' WHERE id = 8;
UPDATE evento SET ficha = 'Protagonizado por Paulo Gustavo e escrito pelo mesmo em parceria com Fil Braz' WHERE id = 8;
UPDATE evento SET duracao = '80 min' WHERE id = 8;

UPDATE evento SET elenco = 'A Orquestra Capital Philharmonia' WHERE id = 9;
UPDATE evento SET ficha = 'Sinfonia n. 5 em ré menor/maior, conhecida como Sinfonia da Reforma; a Abertura Ruy Blas e a Sinfonia para cordas n. 8,' WHERE id = 9;
UPDATE evento SET duracao = '90 min' WHERE id = 9;

UPDATE evento SET elenco = 'Déo Garcez e Nivia Helen' WHERE id = 10;
UPDATE evento SET ficha = 'Dirigido por Ricardo Torres' WHERE id = 10;
UPDATE evento SET duracao = '90 min' WHERE id = 10;