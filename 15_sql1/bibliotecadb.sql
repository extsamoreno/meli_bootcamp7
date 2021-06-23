CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `copias`
--

DROP TABLE IF EXISTS `copias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `copias` (
  `NRO_LIBRO` int DEFAULT NULL,
  `NRO_COPIA` smallint DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copias`
--

LOCK TABLES `copias` WRITE;
/*!40000 ALTER TABLE `copias` DISABLE KEYS */;
INSERT INTO `copias` VALUES (5078912,1,NULL),(6094527,1,NULL),(7034567,1,NULL),(8235698,1,NULL),(8753124,1,NULL),(9076234,1,NULL),(9456789,1,NULL),(9876079,1,NULL),(10545377,1,NULL),(10558904,1,NULL),(10574387,1,NULL),(10654324,1,NULL),(10789443,1,NULL),(5078912,2,NULL),(6094527,2,NULL),(7034567,2,NULL),(8235698,2,NULL),(8753124,2,NULL),(9076234,2,NULL),(9456789,2,NULL),(9876079,2,NULL),(10545377,2,NULL),(10558904,2,NULL),(10574387,2,NULL),(10654324,2,NULL),(10789443,2,NULL),(5078912,3,NULL),(6094527,3,NULL),(7034567,3,NULL),(8235698,3,NULL),(8753124,3,NULL),(9076234,3,NULL),(9456789,3,NULL),(9876079,3,NULL),(10545377,3,NULL),(10558904,3,NULL),(10574387,3,NULL),(10654324,3,NULL),(10789443,3,NULL),(5078912,4,NULL),(6094527,4,NULL),(7034567,4,NULL),(8235698,4,NULL),(8753124,4,NULL),(9076234,4,NULL);
/*!40000 ALTER TABLE `copias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector`
--

DROP TABLE IF EXISTS `lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lector` (
  `NRO_LECTOR` int DEFAULT NULL,
  `NOMBRE` char(22) DEFAULT NULL,
  `DIRECCION` char(30) DEFAULT NULL,
  `TRABAJO` char(10) DEFAULT NULL,
  `SALARIO` float DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (123456,'GOMEZ Arnoldo','Avda. La Reja 2234 - Capital','EMPLEADO',1234.5,NULL),(123467,'FERNANDEZ Guillermo','San Pedro 987 - Moron','EJECUTIVO',3245.5,NULL),(123478,'GARCIA Manuel','Avda de los Sioux 2211 - Korn','VENDEDOR',1345.5,NULL),(123489,'VALLEJOS Pancracio','San Martin 231 - Capital Fed.','EMPLEADO',734.6,NULL),(123490,'APPICCIAFUOCO Gerardo','De los Rosales 234 - Merlo','EMPLEADO',534.2,NULL),(123491,'BANKO Lou','Tres Sargentos 333 - V.Plot','VENDEDOR',1215.3,NULL),(123494,'CASTAÑA Jorge','Avda. de los Peruanos 1234','EJECUTIVO',2453.9,NULL),(124200,'MARENGHI Pick','De las Rosas 234 - Palomar','EMPLEADO',975.4,NULL),(124230,'PEREZ GIL Miguel','Los Tomatoes 125 - V.Adelina','COMERCIANT',1345.45,NULL),(124231,'MIRANDA Hermenegildo','San Cono 901 - V.Milagros','VENDEDOR',856.3,NULL),(124392,'MOLINO Gualterio','Potatoes 29357 - Palermo','COMERCIANT',2356.45,NULL),(125376,'PIE Lemon','Rivadavia 2890 - V.Tesei','EJECUTIVO',3020.4,NULL),(125678,'MARTINEZ Charles','De las Amapolas 124 B.Chino','COMERCIANT',2357.4,NULL),(125789,'YAMIMOTO Scutter','Biela 4325 Dpto.3 4P - Cap.','COMERCIANT',1876.5,NULL);
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `NRO_LIBRO` int NOT NULL,
  `TITULO` char(40) DEFAULT NULL,
  `AUTOR` char(30) DEFAULT NULL,
  `TIPO` char(2) DEFAULT NULL,
  `PRECIO_ORI` float DEFAULT NULL,
  `PRECIO_ACT` float DEFAULT NULL,
  `EDICION` smallint DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (5078912,'LAS MIL Y UNA NOCHES','GALLAND A.','no',20.3,34.2,1948,NULL),(6094527,'FUENTEOVEJUNA','LOPE DE VEGA','no',18.35,32.1,1978,NULL),(7034567,'DICCIONARIO ITALIANO-ESPANOL','CERRUTI J.','di',32.7,32.7,1992,NULL),(8235698,'ETICA Y DEONTOLOGIA DOCENTE','RUIZ DANIEL J.','es',54.2,76.3,1990,NULL),(8753124,'TABLE GAMES','MARRAN','ju',12.5,13.25,1991,NULL),(9076234,'BOTANICA MEDICINAL','TRABUT L.','es',123.48,143.2,1978,NULL),(9456789,'EL CORONEL NO TIENE QUIEN LE ESCRIBA','GARCIA MARQUEZ GABRIEL','no',23.2,31.21,1978,NULL),(9876079,'HISTORIA DE JULIO CESAR','OCHOA EUGENIO','es',154.3,167.2,1946,NULL),(10545377,'LA HOJARASCA','GABRIEL GARCIA MARQUEZ','no',12.1,15.2,1988,NULL),(10558904,'FICCIONES','BORGES JORGE LUIS','cu',23.7,25.4,1979,NULL),(10574387,'SALON DE LECTURA','DENEVI MARCO','cu',14.5,16.1,1980,NULL),(10654324,'HISTORIA ARGENTINA','BUSANICHE J.L.','es',56.3,59.3,1985,NULL),(10789443,'DICCIONARIO INGLES-ESPANOL','APPLETON-CUYAS','di',98.3,123.5,1986,NULL);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `NRO_LECTOR` int DEFAULT NULL,
  `NRO_LIBRO` int DEFAULT NULL,
  `NRO_COPIA` smallint DEFAULT NULL,
  `F_PREST` datetime DEFAULT NULL,
  `F_DEVOL` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (123456,10545377,1,'2018-03-01 00:00:00','2018-03-10 00:00:00'),(123491,10545377,2,'2018-03-02 00:00:00',NULL),(123478,10545377,3,'2018-03-03 00:00:00',NULL),(125376,10545377,1,'2018-03-15 00:00:00','2018-03-20 00:00:00'),(123456,10545377,2,'2018-03-02 00:00:00','2018-06-10 00:00:00'),(123456,10558904,1,'2018-03-01 00:00:00',NULL),(124231,10558904,2,'2018-03-02 00:00:00','2018-03-03 00:00:00'),(124231,10558904,2,'2018-03-05 00:00:00',NULL),(123478,9456789,1,'2018-03-02 00:00:00','2018-03-08 00:00:00'),(123490,5078912,4,'2018-03-03 00:00:00',NULL);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipolibro`
--

DROP TABLE IF EXISTS `tipolibro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipolibro` (
  `TIPO` char(2) NOT NULL,
  `DESCTIPO` char(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipolibro`
--

LOCK TABLES `tipolibro` WRITE;
/*!40000 ALTER TABLE `tipolibro` DISABLE KEYS */;
INSERT INTO `tipolibro` VALUES ('cu','Cuentos'),('di','Diccionario'),('es','Estudio'),('ju','Juegos'),('no','Novela');
/*!40000 ALTER TABLE `tipolibro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'biblioteca'
--

--
-- Dumping routines for database 'biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-21 20:06:53
