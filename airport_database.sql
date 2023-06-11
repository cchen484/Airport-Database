-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema airport-database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airport-database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airport-database` DEFAULT CHARACTER SET utf8 ;
USE `airport-database` ;

-- -----------------------------------------------------
-- Table `airport-database`.`Bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Bookings` (
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`email`));


-- -----------------------------------------------------
-- Table `airport-database`.`Terminals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Terminals` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Pilots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Pilots` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` BIGINT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Customers` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` BIGINT NOT NULL,
  `age` VARCHAR(255) NOT NULL,
  `Bookings_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`, `Bookings_email`),
  INDEX `fk_Customers_Bookings1_idx` (`Bookings_email` ASC) VISIBLE,
  CONSTRAINT `fk_Customers_Bookings1`
    FOREIGN KEY (`Bookings_email`)
    REFERENCES `airport-database`.`Bookings` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `airport-database`.`Airplane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Airplane` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `model` BIGINT NOT NULL,
  `year` BIGINT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Airport` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(255) NOT NULL,
  `airport_name` BIGINT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Flight attendants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Flight attendants` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Flights` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `departure_time` DATETIME NOT NULL,
  `arrival_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Terminals` (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Pilots` (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Customers` (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Airplane` (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Airport` (`id`),
  CONSTRAINT `flights_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Flight attendants` (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Layover`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Layover` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `location` BIGINT NOT NULL,
  `time` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `layover_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Flights` (`id`));


-- -----------------------------------------------------
-- Table `airport-database`.`Destinations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Destinations` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `destinations_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Flights` (`id`),
  CONSTRAINT `destinations_id_foreign`
    FOREIGN KEY (`id`)
    REFERENCES `airport-database`.`Layover` (`id`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
