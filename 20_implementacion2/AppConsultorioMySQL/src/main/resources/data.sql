USE ml_app_consultorio;

INSERT INTO patients (pat_name, pat_lastname, pat_dni)
VALUES ('Geronimo', 'Bazán', '123456'),
       ('Romina', 'Ramirez', '123456');

INSERT INTO professionals (pro_name, pro_lastname, pro_dni)
VALUES ('Matias', 'Esquivel', '123456'),
       ('Sofia', 'Losowski', '123456'),
       ('Belén', 'Bertinotti', '123456');

INSERT INTO turns (tur_date_start, tur_date_end, tur_status, pro_id, pat_id)
VALUES ('2021-09-09 11.30', '2021-09-09', 'EARRING', 1, 1),
       ('2021-09-09 10.30', '2021-09-09', 'EARRING', 1, 1),
       ('2021-09-09 12:30', '2021-09-09', 'EARRING', 2, 2),
       ('2021-09-09 13:30', '2021-09-09', 'EARRING', 2, 1),
       ('2021-09-09 13:30', '2021-09-09', 'EARRING', 3, 1),
       ('2021-05-09 13:30', '2021-09-09', 'FINALIZED', 3, 1),
       ('2021-04-09 13:30', '2021-09-09', 'FINALIZED', 3, 2),
       ('2021-04-09 13:30', '2021-10-09', 'REPROGRAMMED', 3, 2),
       ('2021-04-09 13:30', '2021-11-09', 'REPROGRAMMED', 3, 2);