CREATE TABLE favorito (
	id SERIAL PRIMARY KEY,
	fk_evento_id INT references evento(id),
	fk_usuario_id INT references usuario(id)
);