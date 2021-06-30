/*si queremos ver los usuarios y el host, ejecutamos*/
select user, host from mysql.user;

/*si queremos crear un usuario con contraseña, ejecutamos*/
CREATE USER 'notadmin'@'localhost' IDENTIFIED BY '12345';

/*Si queremos dar todos los privilegios al nuevo usuario, ejecutamos*/
GRANT ALL PRIVILEGES ON *.* TO 'ml_app_user1'@'localhost';


/*Si queremos dar todos los privilegios de una bd a un usuario en particular, ejecutamos*/
GRANT ALL PRIVILEGES ON ml_app_consultorio .* TO 'notadmin'@'localhost';

/*Si queremos dar algunos privilegios de una bd a un usuario en particular, ejecutamos*/
GRANT SELECT, INSERT, UPDATE, DELETE, DROP ON ml_app_consultorio.* TO 'notadmin'@'localhost';