CREATE DATABASE  IF NOT EXISTS `emple_dep` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `emple_dep`;
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
-- Table structure for table `Departaments`
--

DROP TABLE IF EXISTS `Departaments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Departaments` (
  `departament_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`departament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departaments`
--

LOCK TABLES `Departaments` WRITE;
/*!40000 ALTER TABLE `Departaments` DISABLE KEYS */;
INSERT INTO `Departaments` VALUES (1,'Department 1','Address 1'),(2,'Department 2','Address 2'),(3,'Department 3','Address 3'),(4,'Department 4','Address 4'),(5,'Department 5','Address 5');
/*!40000 ALTER TABLE `Departaments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `file_id` int NOT NULL,
  `dni` int NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `incorporation_date` date NOT NULL,
  `position` varchar(45) NOT NULL,
  `salary` double NOT NULL,
  `Departaments_departament_id` int NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `fk_Employees_Departaments_idx` (`Departaments_departament_id`),
  CONSTRAINT `fk_Employees_Departaments` FOREIGN KEY (`Departaments_departament_id`) REFERENCES `Departaments` (`departament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
INSERT INTO `Employees` VALUES (100,50532002,'Vincent','Kimberley','1994-11-08','2018-09-11','non',665.35,5),(101,50640520,'Page','Mannix','1994-06-19','2011-10-23','ligula',737.98,2),(102,65676149,'Shepard','Chelsea','1988-11-27','2012-09-14','facilisis,',815.89,4),(103,44533764,'Orr','Nigel','1998-07-02','2016-04-08','dis',464.62,5),(104,68496824,'Shannon','Marny','1991-01-10','2004-06-04','est',329.65,4),(105,34628866,'Giles','Alfonso','2000-12-06','2001-07-01','mi.',269.97,4),(106,29726606,'Bird','Hilel','1998-02-18','2018-10-10','Aliquam',837.58,1),(107,71055263,'Decker','Castor','1993-04-16','2019-02-02','laoreet',195.14,2),(108,19379974,'Moss','Priscilla','1997-12-03','2018-03-16','gravida',223.97,3),(109,27232583,'Ward','Jeremy','1989-10-13','2011-10-20','orci,',102.97,5),(110,24943124,'Kidd','Alec','1988-05-05','2014-04-24','natoque',914.24,1),(111,14762976,'Robertson','Maia','1993-02-14','2019-04-26','sollicitudin',293.59,5),(112,10453649,'Klein','Veda','1993-12-27','2003-05-12','parturient',267.72,5),(113,54913225,'Mathews','Ciara','1994-07-20','2011-07-30','sed,',922.49,1),(114,32229071,'Adkins','Kane','1989-11-17','2002-10-19','molestie',758.62,3);
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 15:56:52
