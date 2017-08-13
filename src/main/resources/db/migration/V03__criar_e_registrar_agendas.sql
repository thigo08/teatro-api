CREATE TABLE agenda (
	id SERIAL PRIMARY KEY,
	data DATE,
	horario VARCHAR(50),
	id_evento INT references evento(id)
);

INSERT INTO agenda (data, horario, id_evento) values ('2017-05-10', '17:00', 1);
INSERT INTO agenda (data, horario, id_evento) values ('2017-06-12', '20:00', 2);
INSERT INTO agenda (data, horario, id_evento) values ('2017-07-15', '14:00', 3);