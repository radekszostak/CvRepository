DROP TABLE IF EXISTS `educations`;
CREATE TABLE `educations` (
	`education_id` int(11) NOT NULL AUTO_INCREMENT,
	`cv_id` int(11) NOT NULL,
	`from_date` date DEFAULT NULL,
    `to_date` date DEFAULT NULL,
    `field` varchar(100) DEFAULT NULL,
    `school` varchar(100) DEFAULT NULL,
    `description` varchar(450) DEFAULT NULL,
	PRIMARY KEY (`education_id`),
    FOREIGN KEY (`cv_id`) REFERENCES `cvs`(`cv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;