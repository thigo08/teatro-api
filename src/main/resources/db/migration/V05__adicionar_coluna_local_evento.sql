ALTER TABLE local add column latitude VARCHAR(25);
ALTER TABLE local add column longitude VARCHAR(25);
ALTER TABLE evento add column imagem VARCHAR(400);

UPDATE local SET latitude = '-15.8261884', longitude = '-47.9257462' WHERE id = 1;
UPDATE local SET latitude = '-15.818182', longitude = '-47.9243037' WHERE id = 2;
UPDATE local SET latitude = '-15.8444066', longitude = '-48.0360628' WHERE id = 3;
UPDATE local SET latitude = '-15.8367017', longitude = '-47.9166374' WHERE id = 4;
UPDATE evento SET imagem = 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fimgbarbixas-1.jpg?alt=media&token=fae5beab-aa99-42e9-a9a4-d6c23d6f6b6d' WHERE id = 1;
UPDATE evento SET imagem = 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2F20170818184619323159u.jpg?alt=media&token=eeffc0a8-2486-4e57-9cbd-63178d40dc6e' WHERE id = 2;
UPDATE evento SET imagem = 'https://firebasestorage.googleapis.com/v0/b/today-7b8b5.appspot.com/o/images%2Fdownload.jpg?alt=media&token=6aaa5150-3f60-4f16-a447-34d3e6544ece' WHERE id = 3;
