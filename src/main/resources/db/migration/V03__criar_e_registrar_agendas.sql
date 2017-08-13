CREATE TABLE agenda (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	data DATE,
	horario VARCHAR(50),
	id_evento BIGINT(20),
	FOREIGN KEY (id_evento) REFERENCES evento(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agenda (data, horario, id_evento) values ('2017-05-10', '17:00', 1);
INSERT INTO agenda (data, horario, id_evento) values ('2017-06-12', '20:00', 2);
INSERT INTO agenda (data, horario, id_evento) values ('2017-07-15', '14:00', 3);