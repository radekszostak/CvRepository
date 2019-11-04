DROP TABLE IF EXISTS `skills`;
CREATE TABLE `skills` (
	`skill_id` int(11) NOT NULL AUTO_INCREMENT,
	`cv_id` int(11) NOT NULL,
    `primary_description` varchar(50) DEFAULT NULL,
    `secondary_description` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`skill_id`),
    FOREIGN KEY (`cv_id`) REFERENCES `cvs`(`cv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;