-- 1
CREATE USER 'ml_app_user1'@'%' IDENTIFIED BY 'ml_app_user1';

GRANT DELETE, INSERT, SELECT, UPDATE 
ON ml_app_consultorio . * TO 'ml_app_user1'@'%';



-- 2
CREATE USER 'ml_app_user2'@'%' IDENTIFIED BY 'ml_app_user2';

GRANT ALL PRIVILEGES
ON ml_app_consultorio . * TO 'ml_app_user2'@'%';



-- 3
CREATE USER 'ml_app_user3'@'%' IDENTIFIED BY 'ml_app_user3';

GRANT SELECT
ON ml_app_consultorio . * TO 'ml_app_user3'@'%';