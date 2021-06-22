-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: localhost    Database: emple_dep
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_n_legado` int NOT NULL,
  `employee_dni` int NOT NULL,
  `employee_surname` varchar(45) NOT NULL,
  `employee_name` varchar(45) NOT NULL,
  `employee_birth_date` datetime NOT NULL,
  `employee_incorporation_date` datetime NOT NULL,
  `employee_position` varchar(45) NOT NULL,
  `employee_salary` varchar(45) NOT NULL,
  `department_department_id` int NOT NULL,
  PRIMARY KEY (`employee_dni`),
  KEY `fk_employee_department_idx` (`department_department_id`),
  CONSTRAINT `fk_employee_department` FOREIGN KEY (`department_department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'Apellido1','Nombre1','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',1),(2,2,'Apellido2','Nombre2','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',1),(3,3,'Apellido3','Nombre3','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',1),(4,4,'Apellido4','Nombre4','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',2),(5,5,'Apellido5','Nombre5','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',2),(6,6,'Apellido6','Nombre6','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',2),(7,7,'Apellido7','Nombre7','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',3),(8,8,'Apellido8','Nombre8','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',3),(9,9,'Apellido9','Nombre9','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',4),(10,10,'Apellido10','Nombre10','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',4),(11,11,'Apellido11','Nombre11','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',4),(12,12,'Apellido12','Nombre12','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',5),(13,13,'Apellido13','Nombre13','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',5),(14,14,'Apellido14','Nombre14','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',1),(15,15,'Apellido15','Nombre15','1990-01-01 00:00:00','2021-05-18 00:00:00','Desarrollador','798.80',2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 10:36:54
