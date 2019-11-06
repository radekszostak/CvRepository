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