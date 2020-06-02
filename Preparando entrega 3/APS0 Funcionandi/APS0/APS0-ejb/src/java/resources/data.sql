/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Antonio
 * Created: 27-may-2020
 */

INSERT INTO APP.ALUMNO  VALUES ('Anastasia', 'Sanches','1234',50627756,'anas@gmail.com', 'Psicologia',  '2000-05-15', 'Español e ingles', 'anstasia', 123456, 'ALUMNO', 'Universidad de la calle')

INSERT INTO APP.INFORME  VALUES (1, 'REALIZADO CORRECTAMENTE','LIMPIEZA, AYUDA A NIÑOS','30 HORAS',1, 'Anastasia')

INSERT INTO APP.USUARIO VALUES (23, 375856147, 'Sherlock', 'Holmes', 'Investigación', 'Inglés', '02021999', 'evidentemente@uma.es', 'user', NORMAL, 'detective')

INSERT INTO APP.ALUMNO VALUES (1, 111111111, 'Aitor', 'Tilla', 'bachillerato', 'Español', '01012001', 'tortilladeatun@uma.es', 'user', , ALUMNO, 'tillator', 'Grado en Turismo', 444444444)

INSERT INTO APP.ALUMNO VALUES (7, 114151711, 'Espín', 'Nete', 'eso', 'Español', '01042000', 'puercoespin@gmail.com', 'user', , ALUMNO, 'espin', 'Grado en Filosofía', 448453444)

INSERT INTO APP.RESPONSABLE_ACTIVIDAD VALUES (6, 865865865, 'Marco', 'Polo', 'Curso de primeros auxilios', 'Inglés', '08082008', 'poloflash@gmail.com', 'user', RESPONSABLE, 'pool25', 'Deportes')

INSERT INTO APP.ACTIVIDAD (ID, DESCRIPCION, ESTADO, FECHA_FIN, FECHA_INICIO, LUGAR, NOMBRE, TIPO, ONG_ID, RESPONSABLE_ID) VALUES (0, 'Recogida de basura', 'Recoger basura en parajes naturales', '03062021', '04062021', 'pendiente', 'formación', 'Granada')

INSERT INTO APP.INFORME VALUES (3, 'Positiva', 'tres días', 'reparto de alimentos a distintos puntos')

INSERT INTO APP.ONG  VALUES(02, 'Manos Dispersas', 'Ayuda humanitaria en partes distintas del país', 'manosdsp@gmail.com', 111563964, 'Murcia', 'España', 'ong')

INSERT INTO APP.SOLICITUD_ACTIVIDAD VALUES (8, 'por confirmar', '04052020')


UPDATE APP.SEQUENCE SEQ_COUNT=1000000