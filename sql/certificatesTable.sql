DROP TABLE IF EXISTS `certificates`;
CREATE TABLE `certificates` (
	`certificate_id` int(11) NOT NULL AUTO_INCREMENT,
	`cv_id` int(11) NOT NULL,
	`date` date DEFAULT NULL,
    `description` varchar(450) DEFAULT NULL,
	PRIMARY KEY (`certificate_id`),
    FOREIGN KEY (`cv_id`) REFERENCES `cvs`(`cv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;