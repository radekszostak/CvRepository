SET FOREIGN_KEY_CHECKS = 0;

SET GLOBAL validate_password_policy=LOW;

#Clear db
DROP USER IF EXISTS 'cvuser'@'localhost';
DROP USER IF EXISTS 'cvuser'@'%';
DROP DATABASE  IF EXISTS `cvrepository`;

#Create DB user
CREATE USER 'cvuser'@'localhost' IDENTIFIED BY 'cvpassword';
GRANT ALL PRIVILEGES ON * . * TO 'cvuser'@'localhost';
CREATE USER 'cvuser'@'%' IDENTIFIED BY 'cvpassword';
GRANT ALL PRIVILEGES ON * . * TO 'cvuser'@'%';
# For MySQL version>=8.0.4
ALTER USER 'cvuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'cvpassword';
ALTER USER 'cvuser'@'%' IDENTIFIED WITH mysql_native_password BY 'cvpassword';

##Create DB
DROP DATABASE  IF EXISTS `cvrepository`;
CREATE DATABASE  IF NOT EXISTS `cvrepository`;
USE `cvrepository`;

##Create schema

#Create role table
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
INSERT INTO `role` (name)
VALUES 
('ROLE_USER'),('ROLE_ADMIN');

#Create cv table
DROP TABLE IF EXISTS `cv`;
CREATE TABLE `cv` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `publish` bool NOT NULL DEFAULT 0,
    `profession` varchar(50) DEFAULT NULL,
	`overview` varchar(450) DEFAULT NULL,
    `first_name` varchar(50) DEFAULT NULL,
	`last_name` varchar(50) DEFAULT NULL,
    `email` varchar(50) DEFAULT NULL,
    `phone` varchar(50) DEFAULT NULL,
    `birth_date` date DEFAULT NULL,
    `experience` varchar(450) DEFAULT NULL,
    `skill` varchar(450) DEFAULT NULL,
    `education` varchar(450) DEFAULT NULL,
    `interest` varchar(450) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

#Create user table
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cv_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_CV_01` FOREIGN KEY (`cv_id`) REFERENCES `cv`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

#Create user-role table
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;