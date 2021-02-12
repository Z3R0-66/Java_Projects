CREATE DATABASE `apu_dbs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


CREATE TABLE `account` (
  `ownerId` int NOT NULL AUTO_INCREMENT,
  `accountId` int DEFAULT NULL,
  `balance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ownerId`),
  UNIQUE KEY `accountId_UNIQUE` (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `bookhall` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `hallId` int DEFAULT NULL,
  `customerId` int DEFAULT NULL,
  `bookingDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `feedback` (
  `feedbackId` int NOT NULL AUTO_INCREMENT,
  `customerId` int DEFAULT NULL,
  `hallId` int DEFAULT NULL,
  `ownerId` int DEFAULT NULL,
  `feedback` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `hall` (
  `hallId` int NOT NULL AUTO_INCREMENT,
  `hallName` varchar(20) DEFAULT NULL,
  `hallDetails` varchar(500) DEFAULT NULL,
  `hallPlace` varchar(50) DEFAULT NULL,
  `hallCharges` int DEFAULT NULL,
  `ownerId` int DEFAULT NULL,
  `bookedTimes` int DEFAULT NULL,
  PRIMARY KEY (`hallId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `userType` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




