SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema emple_dep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emple_dep` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `emple_dep` ;

-- -----------------------------------------------------
-- Table `emple_dep`.`Departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emple_dep`.`Departments` (
  `departmentID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`departmentID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `emple_dep`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emple_dep`.`Employees` (
  `fileNumber` INT NOT NULL,
  `DNI` INT NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `birthDate` DATETIME NOT NULL,
  `admissionDate` DATETIME NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `income` DECIMAL(10,2) NOT NULL,
  `Departments_departmentID` INT NOT NULL,
  PRIMARY KEY (`fileNumber`, `Departments_departmentID`),
  INDEX `fk_Employees_Departments_idx` (`Departments_departmentID` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_Departments`
    FOREIGN KEY (`Departments_departmentID`)
    REFERENCES `emple_dep`.`Departments` (`departmentID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


INSERT INTO emple_dep.Departments (name,address)
VALUES  ("Department 1", "Address 1"),
        ("Department 2", "Address 2"),
        ("Department 3", "Address 3"),
        ("Department 4", "Address 4"),
        ("Department 5", "Address 5");

INSERT INTO emple_dep.Employees (fileNumber,DNI,lastName,firstName,birthDate,admissionDate,position,income,Departments_departmentID) 
VALUES  (100,50532002,"Vincent","Kimberley","1994-11-08 14:46:34","2018-09-11 08:14:59","non","665.35",5),
        (101,50640520,"Page","Mannix","1994-06-19 02:02:08","2011-10-23 12:26:40","ligula","737.98",2),
        (102,65676149,"Shepard","Chelsea","1988-11-27 20:29:00","2012-09-14 19:52:16","facilisis,","815.89",4),
        (103,44533764,"Orr","Nigel","1998-07-02 09:14:20","2016-04-08 04:48:56","dis","464.62",5),
        (104,68496824,"Shannon","Marny","1991-01-10 17:17:06","2004-06-04 17:03:35","est","329.65",4),
        (105,34628866,"Giles","Alfonso","2000-12-06 03:38:19","2001-07-01 18:44:09","mi.","269.97",4),
        (106,29726606,"Bird","Hilel","1998-02-18 21:19:54","2018-10-10 15:26:15","Aliquam","837.58",1),
        (107,71055263,"Decker","Castor","1993-04-16 01:55:40","2019-02-02 13:41:42","laoreet","195.14",2),
        (108,19379974,"Moss","Priscilla","1997-12-03 13:29:46","2018-03-16 14:56:28","gravida","223.97",3),
        (109,27232583,"Ward","Jeremy","1989-10-13 06:29:27","2011-10-20 00:21:07","orci,","102.97",5),
        (110,24943124,"Kidd","Alec","1988-05-05 18:13:48","2014-04-24 03:10:59","natoque","914.24",1),
        (111,14762976,"Robertson","Maia","1993-02-14 10:30:10","2019-04-26 18:56:35","sollicitudin","293.59",5),
        (112,10453649,"Klein","Veda","1993-12-27 11:15:23","2003-05-12 20:49:03","parturient","267.72",5),
        (113,54913225,"Mathews","Ciara","1994-07-20 19:59:18","2011-07-30 11:18:26","sed,","922.49",1),
        (114,32229071,"Adkins","Kane","1989-11-17 13:54:57","2002-10-19 09:51:11","molestie","758.62",3);