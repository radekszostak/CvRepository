DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
	`skill_id` int(11) NOT NULL AUTO_INCREMENT,
	`cv_id` int(11) NOT NULL,
    `primary_description` varchar(50) DEFAULT NULL,
    `secondary_description` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`skill_id`),
    FOREIGN KEY (`cv_id`) REFERENCES `cv`(`cv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;