SELECT * FROM ml_app_consultorio.appointment;

SELECT * FROM ml_app_consultorio.dentists;

SELECT * FROM ml_app_consultorio.schedules;

SELECT * FROM ml_app_consultorio.patients;

-- Crear Agendas
INSERT INTO ml_app_consultorio.schedules(id)
VALUES (3), (4), (5), (6);


-- Crear Dentistas
INSERT INTO ml_app_consultorio.dentists(name, schedule_id)
VALUES ('David', 3), ('Duban', 4), ('Diana', 5), ('Danilo', 6);

INSERT INTO ml_app_consultorio.dentists(name, schedule_id)
VALUES ('Daniela', 2);


-- Crear Pacientes
INSERT INTO ml_app_consultorio.patients(name)
VALUES ('Paula'), ('Pablo'), ('Pedro'), ('Pilar'), ('Piedad'), ('Paulo');


-- Crear Turnos
INSERT INTO ml_app_consultorio.appointment(date, status, patient_id, schedule_id)
VALUES ('2021-01-01 00:00:00', 'Finalizado', 1, 2), 
('2021-06-01 00:00:00', 'Finalizado', 2, 2),
('2021-06-01 00:00:00', 'Finalizado', 6, 6),
('2021-06-01 00:00:00', 'Finalizado', 5, 5),
('2021-06-01 00:00:00', 'Reprogramado', 2, 5),
('2021-06-01 00:00:00', 'Cancelado', 1, 6),
('2021-06-01 00:00:00', 'Cancelado', 3, 6),
('2021-06-01 00:00:00', 'Finalizado', 4, 2),
('2021-06-01 00:00:00', 'Finalizado', 5, 4),
('2021-06-02 00:00:00', 'Finalizado', 4, 2),
('2021-06-02 00:00:00', 'Finalizado', 5, 2),
('2021-06-02 00:00:00', 'Reprogramado', 1, 5),
('2021-06-02 00:00:00', 'Reprogramado', 3, 3),
('2021-06-02 00:00:00', 'Cancelado', 3, 3),
('2021-06-02 00:00:00', 'Cancelado', 6, 6),
('2021-06-03 00:00:00', 'Cancelado', 5, 4),
('2021-06-03 00:00:00', 'Finalizado', 1, 6),
('2021-06-03 00:00:00', 'Finalizado', 5, 5),
('2021-06-03 00:00:00', 'Finalizado', 2, 5),
('2021-06-03 00:00:00', 'Reprogramado', 4, 2),
('2021-06-04 00:00:00', 'Pendiente', 5, 5),
('2021-06-04 00:00:00', 'Pendiente', 2, 2),
('2021-06-04 00:00:00', 'Pendiente', 4, 4),
('2021-06-04 00:00:00', 'Pendiente', 3, 3),
('2021-06-05 00:00:00', 'Pendiente', 2, 5),
('2021-06-05 00:00:00', 'Pendiente', 3, 5),
('2021-06-05 00:00:00', 'Pendiente', 1, 5);

