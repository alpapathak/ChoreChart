CREATE TABLE `chores` (
  `ChoreId` int(11) NOT NULL AUTO_INCREMENT,
  `ChoreDesc` varchar(1000) DEFAULT NULL,
  `ChorePoints` int(11) DEFAULT NULL,
  `ChoreSuggestedAge` int(11) DEFAULT NULL,
  PRIMARY KEY (`ChoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `kid_chore` (
  `kidLoginId` varchar(250) NOT NULL,
  `ChoreId` int(11) DEFAULT NULL,
  `ChoreStatus` varchar(45) DEFAULT NULL,
  `Notes` varchar(1000) DEFAULT NULL,
  `Points` int(11) DEFAULT NULL,
  KEY `ChoreID_idx` (`ChoreId`),
  CONSTRAINT `ChoreID` FOREIGN KEY (`ChoreId`) REFERENCES `chores` (`choreid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `kids` (
  `FirstName` varchar(250) NOT NULL,
  `LastName` varchar(250) DEFAULT NULL,
  `LoginId` varchar(250) NOT NULL,
  `ParentEmail` varchar(250) NOT NULL,
  `LastLogin` varchar(250) NOT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Password` varchar(250) DEFAULT NULL,
  `KidsEmail` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`LoginId`),
  KEY `ParentEmailKidFK_idx` (`ParentEmail`),
  CONSTRAINT `ParentEmailKidFK` FOREIGN KEY (`ParentEmail`) REFERENCES `parents` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `parents` (
  `FirstName` varchar(250) NOT NULL,
  `LastName` varchar(250) DEFAULT NULL,
  `UserName` varchar(250) NOT NULL,
  `Password` varchar(250) DEFAULT NULL,
  `LastLogin` datetime DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `Email_username` FOREIGN KEY (`UserName`) REFERENCES `register` (`email_username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `register` (
  `FirstName` varchar(250) DEFAULT NULL,
  `LastName` varchar(250) DEFAULT NULL,
  `Email_username` varchar(250) NOT NULL,
  `Password` varchar(250) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Relations` varchar(45) DEFAULT NULL,
  `Newsletter` tinyint(4) DEFAULT NULL,
  `DateCreated` datetime DEFAULT NULL,
  PRIMARY KEY (`Email_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `rewards` (
  `RewardId` int(11) NOT NULL,
  `RewardsDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RewardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
