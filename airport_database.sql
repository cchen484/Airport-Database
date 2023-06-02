CREATE TABLE `Bookings`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL
);
CREATE TABLE `Terminals`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);
CREATE TABLE `Flights`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `departure_time` DATETIME NOT NULL,
    `arrival_time` DATETIME NOT NULL
);
CREATE TABLE `Pilots`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` BIGINT NOT NULL
);
CREATE TABLE `Airplane`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `model` BIGINT NOT NULL,
    `year` BIGINT NOT NULL
);
CREATE TABLE `Flight attendants`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);
CREATE TABLE `Destinations`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);
CREATE TABLE `Airport`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `city` VARCHAR(255) NOT NULL,
    `airport_name` BIGINT NOT NULL
);
CREATE TABLE `Layover`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `location` BIGINT NOT NULL,
    `time` BIGINT NOT NULL
);
CREATE TABLE `Customers`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` BIGINT NOT NULL,
    `age` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `Destinations` ADD CONSTRAINT `destinations_id_foreign` FOREIGN KEY(`id`) REFERENCES `Flights`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Terminals`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Pilots`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Customers`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Airplane`(`id`);
ALTER TABLE
    `Layover` ADD CONSTRAINT `layover_id_foreign` FOREIGN KEY(`id`) REFERENCES `Flights`(`id`);
ALTER TABLE
    `Destinations` ADD CONSTRAINT `destinations_id_foreign` FOREIGN KEY(`id`) REFERENCES `Layover`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Airport`(`id`);
ALTER TABLE
    `Flights` ADD CONSTRAINT `flights_id_foreign` FOREIGN KEY(`id`) REFERENCES `Flight attendants`(`id`);
ALTER TABLE
    `Destinations` ADD CONSTRAINT `destinations_id_foreign` FOREIGN KEY(`id`) REFERENCES `Bookings`(`id`);
ALTER TABLE
    `Bookings` ADD CONSTRAINT `bookings_id_foreign` FOREIGN KEY(`id`) REFERENCES `Customers`(`id`);