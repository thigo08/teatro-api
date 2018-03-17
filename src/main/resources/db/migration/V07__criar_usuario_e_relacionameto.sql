CREATE TABLE usuario (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	email VARCHAR(50),
	uid VARCHAR(200),
	token VARCHAR(300),
	foto VARCHAR(300)
);

CREATE TABLE usuario_evento ( 
	usuario_id INT REFERENCES usuario (id),
  	evento_id INT REFERENCES evento (id) ,
  	CONSTRAINT usuario_evento_pk PRIMARY KEY (usuario_id, evento_id)
 );
