CREATE TABLE `admins` (
  `adminid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT 'no username defined',
  `password` varchar(45) NOT NULL DEFAULT 'no password defined',
  `firstname` varchar(45) NOT NULL DEFAULT 'no_first_name_defined',
  `lastname` varchar(45) DEFAULT 'no_last_name_defined',
  `email` varchar(45) DEFAULT 'no_email_defined',
  `isApproved` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `products` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT 'undefined',
  `image` varchar(45) NOT NULL DEFAULT 'no_image_specified',
  `type` varchar(45) NOT NULL DEFAULT 'no_type_specified',
  `postedBy` varchar(45) NOT NULL DEFAULT 'anonymous',
  `size` varchar(45) NOT NULL DEFAULT 'undefined',
  `price` varchar(45) NOT NULL DEFAULT '3',
  `imageBlob` blob,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT 'no_username_defined',
  `password` varchar(45) NOT NULL DEFAULT 'no_password_defined',
  `firstname` varchar(45) NOT NULL DEFAULT 'no_first_name_defined',
  `lastname` varchar(45) NOT NULL DEFAULT 'no_last_name_defined',
  `email` varchar(45) NOT NULL DEFAULT 'no_email_defined',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
