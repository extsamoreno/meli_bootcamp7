-- MySQL Script generated by MySQL Workbench
-- Tue Jun 22 12:39:01 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema emple_dep
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `emple_dep` ;

-- -----------------------------------------------------
-- Schema emple_dep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emple_dep` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `emple_dep` ;

-- -----------------------------------------------------
-- Table `emple_dep`.`libros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emple_dep`.`libros` ;

CREATE TABLE IF NOT EXISTS `emple_dep`.`libros` (
  `libros_id` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `autor` VARCHAR(45) NULL,
  `ISBN` VARCHAR(45) NULL,
  PRIMARY KEY (`libros_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `emple_dep`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emple_dep`.`empleado` ;

CREATE TABLE IF NOT EXISTS `emple_dep`.`empleado` (
  `num_legajo` INT NOT NULL,
  `dni` INT NULL,
  `apellido` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `fecha_nacimiento` DATETIME NULL,
  `fecha_incorporacion` DATETIME NULL,
  `cargo` VARCHAR(45) NULL,
  `sueldo_neto` VARCHAR(45) NULL,
  `departamento_id_departamento` INT NOT NULL,
  PRIMARY KEY (`num_legajo`, `departamento_id_departamento`),
  INDEX `fk_empleado_departamento1_idx` (`departamento_id_departamento` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_departamento1`
    FOREIGN KEY (`departamento_id_departamento`)
    REFERENCES `emple_dep`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
