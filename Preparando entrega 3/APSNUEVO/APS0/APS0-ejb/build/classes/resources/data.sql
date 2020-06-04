/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Antonio
 * Created: 27-may-2020
 */
INSERT INTO APP.USUARIO VALUES ('Anastasia', 'Sanches','1234', 50627756,'anas@gmail.com', 'Psicologia',  '2000-05-15', 'Español e ingles', 'anstasia', 'ALUMNO')
INSERT INTO APP.USUARIO VALUES ('Detective', 'Holmes', 'pass12341', 77453728, 'usuario1@hotmail.com', 'psicologia', '1800-11-30','ingles', 'Sherlock', 'NORMAL')
INSERT INTO APP.USUARIO VALUES ('Actriz', 'Miller', 'contra12341', 77453756, 'usuario2@hotmail.com', 'psicologia','1800-11-30', 'ingles', 'Amarna', 'NORMAL')
INSERT INTO APP.USUARIO VALUES ('admin', 'admin','admin',1,'admin@gmail.com', 'NULL',  '2000-05-15', 'NULL', 'admin', 'ADMINISTRADOR')
INSERT INTO APP.USUARIO VALUES ('resp','SUAREZ','resp',88779944,'suarez@uma.es','Doctor Ingenería Informática','1970-01-22','Espanol e Ingles','Alfredo','RESPONSABLE')

INSERT INTO APP.ALUMNO  VALUES ('Anastasia', 'Sanches','1234',50627756,'anas@gmail.com', 'Psicologia',  '2000-05-15', 'Español e ingles', 'anstasia', 123456, 'ALUMNO', 'Universidad de la calle')
INSERT INTO APP.ALUMNO  VALUES ('Anastasio', 'martines','1234',40627756,'anaso@gmail.com', 'Mates',  '2000-05-23', 'Español e ingles', 'anstasi0', 1234567, 'ALUMNO', 'Universidad de la calle')
INSERT INTO APP.ALUMNO VALUES ('Filosofo', 'Gutierrez', 'pass6969', 77479828, 'alumno1@hotmail.com', 'Filosofia', '1990-11-21', 'ingles', 'Martin', 84938, 'ALUMNO', 'Ing. Informatica')
INSERT INTO APP.ALUMNO VALUES ('Reportera', 'Velasco', 'password', 7712358, 'alumno2@hotmail.com', 'Comunnicaciones', '2001-09-05', 'ingles', 'Monica', 54995, 'ALUMNO', 'Audiovisuales')

INSERT INTO APP.RESPONSABLE_ACTIVIDAD VALUES ('CIENTIFICO1','SUAREZ','1234','LCC',88779944,'suarez@uma.es','Doctor Ingenería Informática','1970-01-22','Espanol e Ingles','Alfredo','RESPONSABLE')
INSERT INTO APP.RESPONSABLE_ACTIVIDAD VALUES ('resp','SUAREZ','resp','LCC',88779944,'suarez@uma.es','Doctor Ingenería Informática','1970-01-22','Espanol e Ingles','Alfredo','RESPONSABLE')
INSERT INTO APP.RESPONSABLE_ACTIVIDAD VALUES ('CIENTIFICO1','SUAREZ','1234','LCC',88779944,'suarez@uma.es','Doctor Ingenería Informática','1970-01-22', 'Espanol e Ingles','Alfredo','RESPONSABLE')
INSERT INTO APP.RESPONSABLE_ACTIVIDAD VALUES ('INVESTIGADOR1','Estrella','1234','LCC',11229944,'suarezzz@uma.es','Doctor biologia marina','1970-01-22','Espanol e Ingles','Bob','RESPONSABLE')

INSERT INTO APP.ONG VALUES ('ong3', 'Verdes verdes', '111', 'ONG que trata de salvar el medio ambiente', 'alguna parte', 111111, 'arbolesverdes@gmail.com', 'estudioso', '2000-05-15', 'Bilingüe', 'Arboles verdes', 'asdf', 'ONG', 608321654)
INSERT INTO APP.ONG VALUES ('ong1', 'rerererererer', '111', 'Pasar el tiempo con gente que se aburre', 'otra parte', 111121, 'aburridos.com', 'estudioso', '2000-06-15', 'Bilingüe', 'Soledad', 'Uno', 'ONG', 661543216)
INSERT INTO APP.ONG VALUES ('ong2', 'aaaaaaaaaaaaa', '111', 'ONG que reparte cosas bonitas que brillan', 'un sitio guay', 111221, 'todocosas@gmail.com', 'sobre mucho', '2001-05-15', 'Plurilingüe', 'Repartidores', 'asdf', 'ONG', 623630415)

INSERT INTO APP.ACTIVIDAD VALUES(1,'Recogida de caca de perro','PENDIENTE','2020-05-12','2021-05-13','EN UN LUGAR DE LA MANCHA', 'RECOGIDA DE MIERDAS','VOLUNTARIADO','ong1','CIENTIFICO1' )
INSERT INTO APP.ACTIVIDAD VALUES (16, 'Alimentar a los sin techo', 'ACEPTADA','2020-06-09','2021-06-09', 'Barriada de la luz', 'Reparto alimentos', 'ApS', 'ong1', 'resp')
INSERT INTO APP.ACTIVIDAD VALUES(2,'Comedor solidario','PENDIENTE','2020-06-13','2020-07-13','HUELVA', 'COMEDOR','VOLUNTARIADO','ong2','resp')
INSERT INTO APP.ACTIVIDAD VALUES(3,'Plantar pinos','TERMINADA','2019-03-10','2019-03-11','Albacete', 'COSECHA','VOLUNTARIADO','ong1','resp')

INSERT INTO APP.INFORME VALUES (1, 'REALIZADO CORRECTAMENTE','LIMPIEZA, AYUDA A NIÑOS','30 HORAS',1, 'Anastasia')
INSERT INTO APP.INFORME VALUES (321, 'REALIZADA INCORRECTAMENTE', 'reparto de alimentos a distintos puntos', 'tres días', 16, 'Actriz')
INSERT INTO APP.INFORME  VALUES (2, 'REALIZADO','PLANTAR ÁRBOLES','10 HORAS',3, 'Anastasia')
INSERT INTO APP.INFORME  VALUES (3, 'REALIZADO','REPARTIR COSAS','3 HORAS',2, 'Anastasia')

INSERT INTO APP.SOLICITUD_ACTIVIDAD VALUES (801, 'por confirmar', '2020-01-22', 1, 'Anastasia')
INSERT INTO APP.SOLICITUD_ACTIVIDAD VALUES (802, 'confirmada', '2020-05-20', 321, 'Actriz')
INSERT INTO APP.SOLICITUD_ACTIVIDAD VALUES (800, 'por confirmar', '2020-06-04', 2, 'Anastasia')

UPDATE APP.SEQUENCE SEQ_COUNT=1000000