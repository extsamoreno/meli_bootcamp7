CREATE DATABASE  IF NOT EXISTS `super_software` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `super_software`;
-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: localhost    Database: super_software
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
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `dep_id` int unsigned NOT NULL AUTO_INCREMENT,
  `dep_nombre` varchar(45) DEFAULT NULL,
  `dep_direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Penatibus Et Magnis Incorporated','P.O. Box 157, 2971 Augue Ave'),(2,'Ultrices LLP','6383 Semper St.'),(3,'Nec Enim Nunc Company','484-1651 Donec St.'),(4,'Rhoncus LLP','806-8655 Urna Road'),(5,'Cursus Incorporated','883-3080 Semper Rd.');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_nro_legajo` int NOT NULL,
  `emp_dni` int NOT NULL,
  `emp_nombre` varchar(45) DEFAULT NULL,
  `emp_apellido` varchar(45) DEFAULT NULL,
  `emp_fecha_nacimiento` datetime DEFAULT NULL,
  `emp_fecha_incorporacion` datetime DEFAULT NULL,
  `emp_sueldo` varchar(45) NOT NULL,
  `dep_id` int unsigned NOT NULL,
  PRIMARY KEY (`emp_id`,`dep_id`),
  UNIQUE KEY `empleados_nro_legajo_UNIQUE` (`emp_nro_legajo`),
  UNIQUE KEY `empleados_dni_UNIQUE` (`emp_dni`),
  KEY `fk_empleados_departamentos_idx` (`dep_id`),
  CONSTRAINT `empleados_departamentos` FOREIGN KEY (`dep_id`) REFERENCES `departamentos` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,43566,100,'Quinn','Copeland','2004-05-21 00:00:00','2010-07-21 00:00:00','$7,420',3),(2,92861,101,'Jasper','Mcdaniel','2016-04-21 00:00:00','2027-07-21 00:00:00','$8,454',2),(3,77042,102,'Zachery','Mendoza','2008-10-21 00:00:00','2001-02-22 00:00:00','$6,534',3),(4,83379,103,'Zane','Wilkerson','2024-01-21 00:00:00','2021-03-22 00:00:00','$8,916',2),(5,25800,104,'Felix','Woods','2008-09-20 00:00:00','2017-01-21 00:00:00','$8,978',5),(6,1487,105,'Aidan','Weiss','2021-10-21 00:00:00','2002-06-21 00:00:00','$7,082',4),(7,43784,106,'Mason','Kramer','2025-06-21 00:00:00','2013-07-20 00:00:00','$5,838',5),(8,51666,107,'Walter','Hale','2009-11-20 00:00:00','2015-03-22 00:00:00','$8,718',5),(9,9266,108,'Thor','Ryan','2020-10-21 00:00:00','2029-01-22 00:00:00','$8,808',5),(10,6496,109,'Bevis','Ross','2022-03-22 00:00:00','2001-12-20 00:00:00','$8,470',1),(11,19056,110,'Burton','Paul','2023-10-20 00:00:00','2025-07-21 00:00:00','$6,873',3),(12,66202,111,'Fitzgerald','Lott','2023-07-20 00:00:00','2030-01-22 00:00:00','$9,084',2),(13,13442,112,'Jonah','Ashley','2023-03-22 00:00:00','2016-11-21 00:00:00','$7,650',5),(14,18031,113,'Jonah','Shepherd','2029-01-22 00:00:00','2016-08-21 00:00:00','$5,094',3),(15,26028,114,'Scott','Kent','2029-10-20 00:00:00','2004-05-22 00:00:00','$5,686',5);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 20:58:28
