/* Creación usuario ml_app_user1 */
CREATE USER 'ml_app_user1'@'localhost' IDENTIFIED BY 'ml_app_user1';
GRANT SELECT, INSERT, UPDATE, DELETE ON ml_app_consultorio.* TO 'ml_app_user1'@'localhost';
/* Creación usuario ml_app_user2 */
CREATE USER 'ml_app_user2'@'localhost' IDENTIFIED BY 'ml_app_user2';
GRANT ALL PRIVILEGES ON ml_app_consultorio.* TO 'ml_app_user2'@'localhost';
​/* Creación usuario ml_app_user3 */
CREATE USER 'ml_app_user3'@'localhost' IDENTIFIED BY 'ml_app_user3';
GRANT SELECT ON ml_app_consultorio.* TO 'ml_app_user3'@'localhost';