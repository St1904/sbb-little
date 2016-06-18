-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SBB_little
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SBB_little
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SBB_little` DEFAULT CHARACTER SET utf8 ;
USE `SBB_little` ;

-- -----------------------------------------------------
-- Table `SBB_little`.`Station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Station` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `suffix` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `station_UNIQUE` (`name` ASC, `suffix` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Route` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price_per_min` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Waypoint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Waypoint` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `route_id` BIGINT NOT NULL,
  `station_id` BIGINT NOT NULL,
  `arrival` INT NOT NULL,
  `stay_count` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_station_id_idx` (`station_id` ASC),
  INDEX `fk_route_id_waypoint_idx` (`route_id` ASC),
  CONSTRAINT `fk_station_id`
    FOREIGN KEY (`station_id`)
    REFERENCES `SBB_little`.`Station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_id_waypoint`
    FOREIGN KEY (`route_id`)
    REFERENCES `SBB_little`.`Route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Passenger` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `person_UNIQUE` (`name` ASC, `surname` ASC, `birthdate` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Train` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `seats` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`TrainRoute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`TrainRoute` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `train_id` BIGINT NOT NULL,
  `route_id` BIGINT NOT NULL,
  `date` DATE NOT NULL,
  `time_start` TIME NOT NULL,
  `price_coef` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_route_id_trainRoute_idx` (`route_id` ASC),
  INDEX `fk_train_id_trainRoute_idx` (`train_id` ASC),
  CONSTRAINT `fk_train_id_trainRoute`
    FOREIGN KEY (`train_id`)
    REFERENCES `SBB_little`.`Train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_id_trainRoute`
    FOREIGN KEY (`route_id`)
    REFERENCES `SBB_little`.`Route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Ticket` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `trainRoute_id` BIGINT NOT NULL,
  `carriage_number` INT NOT NULL,
  `seat` INT NOT NULL,
  `passenger_id` BIGINT NOT NULL,
  `start_station` BIGINT NOT NULL,
  `finish_station` BIGINT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_passenger_id_idx` (`passenger_id` ASC),
  INDEX `fk_start_station_idx` (`start_station` ASC),
  INDEX `fk_finish_station_idx` (`finish_station` ASC),
  INDEX `fk_trainRoute_id_idx` (`trainRoute_id` ASC),
  UNIQUE INDEX `ticket_UNIQUE` (`trainRoute_id` ASC, `carriage_number` ASC, `seat` ASC),
  CONSTRAINT `fk_passenger_id`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `SBB_little`.`Passenger` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_start_station`
    FOREIGN KEY (`start_station`)
    REFERENCES `SBB_little`.`Waypoint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_finish_station`
    FOREIGN KEY (`finish_station`)
    REFERENCES `SBB_little`.`Waypoint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trainRoute_id`
    FOREIGN KEY (`trainRoute_id`)
    REFERENCES `SBB_little`.`TrainRoute` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`Carriage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`Carriage` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `capacity` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `carriage_UNIQUE` (`capacity` ASC, `type` ASC, `price` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_little`.`TrainCarriage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_little`.`TrainCarriage` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `train_id` BIGINT NOT NULL,
  `carriage_id` BIGINT NOT NULL,
  `carriage_number` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_train_id_idx` (`train_id` ASC),
  INDEX `fk_carriage_id_idx` (`carriage_id` ASC),
  CONSTRAINT `fk_train_id`
    FOREIGN KEY (`train_id`)
    REFERENCES `SBB_little`.`Train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carriage_id`
    FOREIGN KEY (`carriage_id`)
    REFERENCES `SBB_little`.`Carriage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
