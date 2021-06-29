-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema consultory
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema consultory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `consultory` DEFAULT CHARACTER SET utf8 ;
USE `consultory` ;

-- -----------------------------------------------------
-- Table `consultory`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`table1` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`patient` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`professional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`professional` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`working_days`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`working_days` (
  `id` INT NOT NULL,
  `desc_day` VARCHAR(45) NULL,
  `start_time` VARCHAR(45) NULL,
  `end_time` VARCHAR(45) NULL,
  `professional_id` INT NOT NULL,
  PRIMARY KEY (`id`, `professional_id`),
  INDEX `fk_working_days_professional1_idx` (`professional_id` ASC) VISIBLE,
  CONSTRAINT `fk_working_days_professional1`
    FOREIGN KEY (`professional_id`)
    REFERENCES `consultory`.`professional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`schedule` (
  `id` INT NOT NULL,
  `working_days_id` INT NOT NULL,
  `working_days_professional_id` INT NOT NULL,
  PRIMARY KEY (`id`, `working_days_id`, `working_days_professional_id`),
  INDEX `fk_schedule_working_days1_idx` (`working_days_id` ASC, `working_days_professional_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_working_days1`
    FOREIGN KEY (`working_days_id` , `working_days_professional_id`)
    REFERENCES `consultory`.`working_days` (`id` , `professional_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`turn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`turn` (
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
    REFERENCES `consultory`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turn_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `consultory`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`turno_x_agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`turno_x_agenda` (
  `turno_id` INT NOT NULL,
  `agenda_id` INT NOT NULL,
  INDEX `fk_turno_x_agenda_turno1_idx` (`turno_id` ASC) VISIBLE,
  INDEX `fk_turno_x_agenda_agenda1_idx` (`agenda_id` ASC) VISIBLE,
  CONSTRAINT `fk_turno_x_agenda_turno1`
    FOREIGN KEY (`turno_id`)
    REFERENCES `consultory`.`turn` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_x_agenda_agenda1`
    FOREIGN KEY (`agenda_id`)
    REFERENCES `consultory`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`table2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`table2` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`turn_x_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`turn_x_schedule` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consultory`.`turn_has_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`turn_has_schedule` (
  `turn_id` INT NOT NULL,
  `schedule_id` INT NOT NULL,
  PRIMARY KEY (`turn_id`, `schedule_id`),
  INDEX `fk_turn_has_schedule_schedule1_idx` (`schedule_id` ASC) VISIBLE,
  INDEX `fk_turn_has_schedule_turn1_idx` (`turn_id` ASC) VISIBLE,
  CONSTRAINT `fk_turn_has_schedule_turn1`
    FOREIGN KEY (`turn_id`)
    REFERENCES `consultory`.`turn` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turn_has_schedule_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `consultory`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `consultory` ;

-- -----------------------------------------------------
-- Placeholder table for view `consultory`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultory`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `consultory`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `consultory`.`view1`;
USE `consultory`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
