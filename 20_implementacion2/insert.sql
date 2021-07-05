INSERT INTO `ml_app_consultorio`.`pacientes`(`id_paciente`,`apellido`,`dni`,`nombre`,`obra_social`)
VALUES
(1,  "Perez" , 123412, "Jorge", "os1"),
(2,  "Perez" , 512312, "Walter", "os2"),
(3,  "Perez" , 451232, "Antonella", "os3"),
(4,  "Perez" , 512562, "Adriana", "os4");
INSERT INTO `ml_app_consultorio`.`odontologos`(`id_odontologo`,`especialidad`,`nombre`)
VALUES
(1, "Periodoncia" , "Michael"),
(2, "Periodoncia" , "Roberts"),
(3, "Endodoncia" , "Julia"),
(4, "Endodoncia" , "Mike");
INSERT INTO `ml_app_consultorio`.`turnos`(`id_turno`,`fecha`,`estado`,`fecha_reprogramada`,`id_odontologo`,`id_paciente`)
VALUES
(1, '2021-06-29', "Pendiente",null, 1, 1),
(2, '2021-06-29', "Pendiente", null,2, 2),
(3, '2021-06-29', "Pendiente", null,3, 3),
(4, '2021-06-29', "Pendiente", null,3, 4),
(5, '2021-06-29', "Finalizado", null,3, 2),
(6, '2021-06-30', "Finalizado", null,3, 4),
(7, '2021-06-30', "Reprogramado", '2022-03-31',3, 4);	
