-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: emple_dep
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
-- Table structure for table `Empleados`
--

DROP TABLE IF EXISTS `Empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Empleados` (
  `numero_legajo` int NOT NULL,
  `empleado_dni` varchar(10) NOT NULL,
  `empleado_nombre` varchar(30) NOT NULL,
  `empleado_apellido` varchar(30) NOT NULL,
  `empleado_cargo` varchar(20) NOT NULL,
  `empleado_fechaNacimiento` datetime NOT NULL,
  `empleado_fechaIncorporacion` datetime NOT NULL,
  `empleado_sueldoNeto` decimal(10,0) NOT NULL,
  `empleado_departamento_id` int NOT NULL,
  PRIMARY KEY (`numero_legajo`),
  KEY `departamento_id_idx` (`empleado_departamento_id`),
  CONSTRAINT `departamento_id` FOREIGN KEY (`empleado_departamento_id`) REFERENCES `Departamentos` (`departamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleados`
--

LOCK TABLES `Empleados` WRITE;
/*!40000 ALTER TABLE `Empleados` DISABLE KEYS */;
INSERT INTO `Empleados` VALUES (1,'13324234','Juan','Perez','Supervisor','1992-10-02 00:00:00','2012-02-01 00:00:00',10000,1),(2,'12313435','Ana','Gonzalez','Gerente','1960-08-01 00:00:00','2010-06-11 00:00:00',456456,1),(3,'68766743','Alberto','Victoria','Gerente','1992-10-02 00:00:00','2012-02-01 00:00:00',5674533,2),(4,'32424364','Jorge','Abeju','Supervisor','1988-04-11 00:00:00','2010-06-11 00:00:00',20000,4),(5,'43565756','Maria','Lopez','Cadete','1992-10-02 00:00:00','2010-06-11 00:00:00',345345,3),(6,'12323464','Susana','Sanchez','Gerente','1960-08-01 00:00:00','2010-08-02 00:00:00',3453467,5),(7,'23434645','Anibal','Gardiel','Cadete','1992-10-02 00:00:00','2010-06-11 00:00:00',2341423,3),(8,'23434645','Lucas','Romero','Supervisor','1988-04-11 00:00:00','2012-02-01 00:00:00',20002,2),(9,'87857334','Marisol','Ralik','Cadete','1992-10-02 00:00:00','2010-06-11 00:00:00',1342352,1),(10,'43665743','Tamara','Naiel','Gerente','1960-08-01 00:00:00','2011-09-10 00:00:00',324234,2),(11,'87957353','Raul','Eteriz','Cadete','1992-10-02 00:00:00','2010-06-11 00:00:00',4353446,5),(12,'43545743','German','Dialo','Cadete','1988-04-11 00:00:00','2012-02-01 00:00:00',4554645,4),(13,'21314555','Mariano','Mosiel','Supervisor','1960-08-01 00:00:00','2010-06-11 00:00:00',456456,3),(14,'63524511','Laura','Pers','Gerente','1992-10-02 00:00:00','2012-02-01 00:00:00',4564645,3),(15,'346u6573','Antonia','Rails','Administrativo','1988-04-11 00:00:00','2010-06-11 00:00:00',456465,4);
/*!40000 ALTER TABLE `Empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-26 16:46:23
