DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
	`username` varchar(50) NOT NULL,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
    `phone` varchar(45) DEFAULT NULL,
    `birth_date` date DEFAULT NULL,
	PRIMARY KEY (`username`),
    FOREIGN KEY (`username`) REFERENCES `users`(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;