ALTER TABLE local add column latitude VARCHAR(25);
ALTER TABLE local add column longitude VARCHAR(25);
ALTER TABLE evento add column imagem VARCHAR(100);

UPDATE local SET latitude = '-15.8261884', longitude = '-47.9257462' WHERE id = 1;
UPDATE local SET latitude = '-15.818182', longitude = '-47.9243037' WHERE id = 2;
UPDATE local SET latitude = '-15.8444066', longitude = '-48.0360628' WHERE id = 3;
UPDATE local SET latitude = '-15.8367017', longitude = '-47.9166374' WHERE id = 4;
UPDATE evento SET imagem = 'http://www.barbixas.com.br/2017/embrevesimg.jpg' WHERE id = 1;
UPDATE evento SET imagem = 'http://www.desfrutecultural.com.br/wp-content/uploads/2015/02/G7-divulga%C3%A7ao.jpg' WHERE id = 2;
UPDATE evento SET imagem = 'http://www.joaoalberto.com/wp-content/uploads/2015/05/22/melhores-do-mundo.jpg' WHERE id = 3;
