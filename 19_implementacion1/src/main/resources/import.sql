insert into ml_app_consultorio.dentist (id, dni, name, surname) values (0,'1', 'pedro', 'picapiedra'), (0,'2', 'pablo', 'picapiedra');

insert into ml_app_consultorio.schedule (id, start_date_time, end_date_time, dentist_id) values
(0,'2021-12-01 10:00:00', '2021-12-01 11:00:00', 1),
(0,'2021-12-01 14:00:00', '2021-12-01 16:00:00', 1),
(0,'2021-12-02 10:00:00', '2021-12-01 18:00:00', 1),
(0,'2021-12-01 10:00:00', '2021-12-01 12:00:00', 2),
(0,'2021-12-03 10:00:00', '2021-12-01 11:00:00', 2);

insert into ml_app_consultorio.patient (id, dni, name, surname) values (0,'1', 'paciente1', 'pascurname1'), (0,'2', 'paciente2', 'pacsurname2');


INSERT INTO `ml_app_consultorio`.`appointment` (`id`,`start_date_time`,`end_date_time`,`patient_id`,`schedule_id`) VALUES
(0,'2021-12-01 10:00:00', '2021-12-01 10:30:00', 1,1),
(0,'2021-12-01 15:00:00', '2021-12-01 16:00:00', 1,2),
(0,'2021-12-03 10:40:00', '2021-12-01 11:00:00', 2,4);
