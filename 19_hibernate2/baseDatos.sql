-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `mydb`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`patient` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`professional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`professional` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`working_days`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`working_days` (
  `id` INT NOT NULL,
  `desc_day` VARCHAR(45) NULL,
  `start_time` VARCHAR(45) NULL,
  `end_time` VARCHAR(45) NULL,
  `professional_id` INT NOT NULL,
  PRIMARY KEY (`id`, `professional_id`),
  INDEX `fk_working_days_professional1_idx` (`professional_id` ASC) VISIBLE,
  CONSTRAINT `fk_working_days_professional1`
    FOREIGN KEY (`professional_id`)
    REFERENCES `mydb`.`professional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedule` (
  `id` INT NOT NULL,
  `working_days_id` INT NOT NULL,
  `working_days_professional_id` INT NOT NULL,
  PRIMARY KEY (`id`, `working_days_id`, `working_days_professional_id`),
  INDEX `fk_schedule_working_days1_idx` (`working_days_id` ASC, `working_days_professional_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_working_days1`
    FOREIGN KEY (`working_days_id` , `working_days_professional_id`)
    REFERENCES `mydb`.`working_days` (`id` , `professional_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`turn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`turn` (
  `id` INT NOT NULL,
  `desc` VARCHAR(45) NULL,
  `start_time` DATETIME NULL,
  `end_time` VARCHAR(45) NULL,
  `active` TINYINT NOT NULL,
  `schedule_id` INT NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`id`, `schedule_id`, `patient_id`),
  INDEX `fk_turn_schedule1_idx` (`schedule_id` ASC) VISIBLE,
  INDEX `fk_turn_patient1_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_turn_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `mydb`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turn_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `mydb`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`turno_x_agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`turno_x_agenda` (
  `turno_id` INT NOT NULL,
  `agenda_id` INT NOT NULL,
  INDEX `fk_turno_x_agenda_turno1_idx` (`turno_id` ASC) VISIBLE,
  INDEX `fk_turno_x_agenda_agenda1_idx` (`agenda_id` ASC) VISIBLE,
  CONSTRAINT `fk_turno_x_agenda_turno1`
    FOREIGN KEY (`turno_id`)
    REFERENCES `mydb`.`turn` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_x_agenda_agenda1`
    FOREIGN KEY (`agenda_id`)
    REFERENCES `mydb`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `mydb`.`turn_has_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`turn_has_schedule` (
  `turn_id` INT NOT NULL,
  `schedule_id` INT NOT NULL,
  PRIMARY KEY (`turn_id`, `schedule_id`),
  INDEX `fk_turn_has_schedule_schedule1_idx` (`schedule_id` ASC) VISIBLE,
  INDEX `fk_turn_has_schedule_turn1_idx` (`turn_id` ASC) VISIBLE,
  CONSTRAINT `fk_turn_has_schedule_turn1`
    FOREIGN KEY (`turn_id`)
    REFERENCES `mydb`.`turn` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turn_has_schedule_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `mydb`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `mydb`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`view1`;
USE `mydb`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
