-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `empleado_num_legajo` int NOT NULL,
  `empleado_dni` int DEFAULT NULL,
  `empleado_apellido` varchar(45) DEFAULT NULL,
  `empleado_nombre` varchar(45) DEFAULT NULL,
  `empleado_fecha_nac` datetime DEFAULT NULL,
  `empleado_fecha_incorporacion` datetime DEFAULT NULL,
  `empleado_cargo` varchar(45) DEFAULT NULL,
  `empleado_sueldo_neto` decimal(10,0) DEFAULT NULL,
  `departamento_departamento_id` int NOT NULL,
  PRIMARY KEY (`empleado_num_legajo`),
  KEY `fk_empleado_departamento_idx` (`departamento_departamento_id`),
  CONSTRAINT `fk_empleado_departamento` FOREIGN KEY (`departamento_departamento_id`) REFERENCES `departamento` (`departamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,38745123,'Fernandez','Carlos','1995-10-25 00:00:00','2021-02-20 00:00:00','Analista',100000,3),(2,30541321,'Perez','Martin','1985-01-10 00:00:00','2021-05-05 00:00:00','Vendedor',50000,1),(3,25000123,'Godoy','Jesica','1970-08-15 00:00:00','2020-10-01 00:00:00','Recepcionista',55000,4),(4,28546123,'Orsini','Luciano','1990-02-20 00:00:00','2020-01-02 00:00:00','Despachante',150000,2);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 13:18:15
