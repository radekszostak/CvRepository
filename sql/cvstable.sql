DROP TABLE IF EXISTS `cvs`;
CREATE TABLE `cvs` (
	`cv_id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) NOT NULL,
	`overview` varchar(450) DEFAULT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`username`) REFERENCES `users`(`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;