-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema airport-database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airport-database` DEFAULT CHARACTER SET utf8 ;
USE `airport-database`;

-- -----------------------------------------------------
-- Table `airport-database`.`Bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport-database`.`Bookings` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,	
  `booking_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `airport` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`booking_id`));
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Arthur Benson', 'artben@hotmail.com', 'LAX');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Arthur Benson', 'artben@hotmail.com', 'LAG');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Zora Lee', 'zoraly@gmail.com', 'JFK');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Jason Paterson', 'jaypat99@comcast.net', 'JFK');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Jennie Kenneth', 'jenniekennie@gmail.com','JFK');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Arthur Benson', 'artben@hotmail.com', 'DEN');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Octavia Jennings', 'octjenn545@gmail.com', 'ATL');
  INSERT INTO Bookings (booking_name, email, airport) VALUES ('Octavia Jennings', 'octjenn545@gmail.com', 'ATL');

-- GROUP BY, W/ HAVING
SELECT COUNT(Bookings.booking_id)
FROM Bookings
GROUP BY Bookings.airport
HAVING COUNT(Bookings.booking_id)>3;

-- GROUP BY, W/O HAVING
SELECT COUNT(Bookings.booking_name)
FROM Bookings
GROUP BY Bookings.airport;

  
UPDATE Bookings
SET booking_name = 'Art Benson'
WHERE email = 'artben@hotmail.com' AND airport = 'DEN';

UPDATE Bookings
SET email = 'jasonpat99@xfinity.net'
WHERE booking_name = 'Jason Paterson';



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
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `Bookings_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Customers_Bookings1_idx` (`Bookings_email` ASC) VISIBLE,
  CONSTRAINT `fk_Customers_Bookings1`
    FOREIGN KEY (`Bookings_email`)
    REFERENCES `airport-database`.`Bookings` (`email`));
    
INSERT INTO Customers (customer_name, age) VALUES ('Arthur Benson', 26);
INSERT INTO Customers (customer_name, age) VALUES ('Zora Lee', 65);
INSERT INTO Customers (customer_name, age) VALUES ('Bes Oliver', 44);
INSERT INTO Customers (customer_name, age) VALUES ('Jason Paterson', 45);
INSERT INTO Customers (customer_name, age) VALUES ('Jennie Kenneth', 19);
INSERT INTO Customers (customer_name, age) VALUES ('Patrick Roth', 31);
INSERT INTO Customers (customer_name, age) VALUES ('Octavia Jennings', 33);
INSERT INTO Customers (customer_name, age) VALUES ('Siobhan McCormick', 76);

-- LEFT JOIN
SELECT Booking.booking_name, Customers.customer_name, Booking.email, Booking.airport 
FROM CUSTOMER
LEFT JOIN Bookings
ON Booking.booking_name = Customers.customer_name;




ALTER TABLE Customers
RENAME COLUMN Booking_email to booking_email;

ALTER TABLE Customers
ADD phone_number VARCHAR(12);


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
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(2) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `airport_FAA` VARCHAR(3) NOT NULL,
  
  PRIMARY KEY (`id`));
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (CA, 'Los Angeles', 'LAX');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (CO, 'Denver', 'DEN');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (GA, 'Atlanta', 'ATL');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (HI, 'Honolulu', 'HNO');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (IL, 'Chicago', 'MDW');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (MI, 'Detroit', 'DTW');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (NY, 'New York', 'JFK');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (AK, 'Anchorage', 'MRI');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (AL, 'Birmingham', 'BHM');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (MO, 'St. Louis', 'STL');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (NJ, 'Newark', 'EWR');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (NC, 'Charlotte', 'CLT');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (OK, 'Oklahoma City', 'OKC');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (MI, 'Detroit', 'DTW');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (PA, 'Philadelphia', 'PHL');
  INSERT INTO Aiport (state, city, airport_FAA) VALUES (PA, 'Allentown', 'ABE');
  
  
-- UPDATE STATEMENTS 

UPDATE Airport
SET airport_FAA = 'ORD'
WHERE city = 'Chicago';

UPDATE Airport
SET airport_FAA = 'HNL'
WHERE city = 'Honolulu';

UPDATE Airport
SET airport_FAA = 'LGA'
WHERE city = 'New York';

-- DELETE STATEMENTS
DELETE FROM Airport WHERE state = 'PA';
DELETE FROM Airport WHERE city = 'Charlotte';
DELETE FROM Airport WHERE city = 'St. Louis';
DELETE FROM Airport WHERE state = 'NY';
DELETE FROM Airport WHERE state = 'ID';



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
INSERT INTO Customers (departure_time, arrival_time) VALUES ('2023-11-11 13:23:00', '2023-11-19 1:40:00');
INSERT INTO Customers (departure_time, arrival_time) VALUES ('2023-11-09 15:45:00', '2023-11-27 2:55:00');
INSERT INTO Customers (departure_time, arrival_time) VALUES ('2023-10-29 14:56:00', '2023-11-01 18:24:00');

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
