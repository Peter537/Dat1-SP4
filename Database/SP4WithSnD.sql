-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: formula1manager
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `def_car`
--

DROP TABLE IF EXISTS `def_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `def_car` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `horsepower` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `aerodynamics` double DEFAULT NULL,
  `tirepressure` double DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `car_id_UNIQUE` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `def_car`
--

LOCK TABLES `def_car` WRITE;
/*!40000 ALTER TABLE `def_car` DISABLE KEYS */;
INSERT INTO `def_car` VALUES (1,'A car',1018,1032,0.10633214790065756,0.17347075564640435),(2,'Good car',1045,1024,0.1,0.18),(3,'Some car',1042,1011,0.1196174250383159,0.11581835092644321),(4,'Another car',1036,1019,0.15190850297700992,0.14823730827591972),(5,'Car car',1039,1000,0.11093269687313645,0.10171465727481362),(6,'Car v2',1004,1028,0.18018742425717188,0.13253627470514204),(7,'Bad car',1009,1042,0.10817740818168656,0.17347075564640435),(8,'Great car',1033,1036,0.138998469791753,0.14440892416725098),(9,'Speeeeed',1001,1022,0.19987727051151913,0.12452658649789664),(10,'A racer',1040,1023,0.13852020100299364,0.14809924570323715);
/*!40000 ALTER TABLE `def_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `def_driver`
--

DROP TABLE IF EXISTS `def_driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `def_driver` (
  `driver_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `cornering` int DEFAULT NULL,
  `consistency` int DEFAULT NULL,
  `acceleration` int DEFAULT NULL,
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `driver_id_UNIQUE` (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `def_driver`
--

LOCK TABLES `def_driver` WRITE;
/*!40000 ALTER TABLE `def_driver` DISABLE KEYS */;
INSERT INTO `def_driver` VALUES (1,'John',0,61,72,79,76),(2,'Mike',0,69,77,60,77),(3,'Peter',0,65,76,67,78),(4,'Magnus',0,80,80,80,80),(5,'Sidsel',0,67,67,69,68),(6,'Yusuf',0,66,64,64,73),(7,'Dave',0,73,64,69,67),(8,'Bob',0,69,65,68,72),(9,'Steve',0,76,70,79,71),(10,'Craig',0,72,64,63,69),(11,'Kevin',0,74,74,60,63),(12,'Ross',0,66,62,79,67),(13,'Jake',0,69,68,78,73),(14,'Dan',0,75,75,69,79),(15,'Sven',0,75,60,72,60),(16,'Raceman',0,76,79,74,62),(17,'Scuderia',0,76,60,77,75),(18,'Steven',0,66,62,76,73),(19,'Dave2',0,79,78,77,65),(20,'Bob2',0,78,64,78,63);
/*!40000 ALTER TABLE `def_driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `def_driver_team`
--

DROP TABLE IF EXISTS `def_driver_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `def_driver_team` (
  `driver_team_id` int NOT NULL AUTO_INCREMENT,
  `dt_driver1_id` int DEFAULT NULL,
  `dt_driver2_id` int DEFAULT NULL,
  `dt_team_id` int DEFAULT NULL,
  PRIMARY KEY (`driver_team_id`),
  UNIQUE KEY `driver_team_id_UNIQUE` (`driver_team_id`),
  KEY `dt_driver_id_idx` (`dt_driver1_id`),
  KEY `dt_team_id_idx` (`dt_team_id`),
  KEY `dt_driver2_id_idx` (`dt_driver2_id`),
  CONSTRAINT `dt_driver1_id` FOREIGN KEY (`dt_driver1_id`) REFERENCES `def_driver` (`driver_id`),
  CONSTRAINT `dt_driver2_id` FOREIGN KEY (`dt_driver2_id`) REFERENCES `def_driver` (`driver_id`),
  CONSTRAINT `dt_team_id` FOREIGN KEY (`dt_team_id`) REFERENCES `def_team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `def_driver_team`
--

LOCK TABLES `def_driver_team` WRITE;
/*!40000 ALTER TABLE `def_driver_team` DISABLE KEYS */;
INSERT INTO `def_driver_team` VALUES (1,1,2,1),(2,3,4,2),(3,5,6,3),(4,7,8,4),(5,9,10,5),(6,11,12,6),(7,13,14,7),(8,15,16,8),(9,17,18,9),(10,19,20,10);
/*!40000 ALTER TABLE `def_driver_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `def_team`
--

DROP TABLE IF EXISTS `def_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `def_team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `myteam` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `team_id_UNIQUE` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `def_team`
--

LOCK TABLES `def_team` WRITE;
/*!40000 ALTER TABLE `def_team` DISABLE KEYS */;
INSERT INTO `def_team` VALUES (1,'McLars',139,0),(2,'Ferra',246,1),(3,'Harsh',14,0),(4,'Toytota',4,0),(5,'Kiba',32,0),(6,'LambOGin',0,0),(7,'Blue bull',107,0),(8,'Cherv',23,0),(9,'Mojo',0,0),(10,'Marserat',47,0);
/*!40000 ALTER TABLE `def_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `def_team_car`
--

DROP TABLE IF EXISTS `def_team_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `def_team_car` (
  `team_car_id` int NOT NULL AUTO_INCREMENT,
  `tc_team_id` int DEFAULT NULL,
  `tc_car_id` int DEFAULT NULL,
  PRIMARY KEY (`team_car_id`),
  KEY `tc_team_id_idx` (`tc_team_id`),
  KEY `tc_car_id_idx` (`tc_car_id`),
  CONSTRAINT `tc_car_id` FOREIGN KEY (`tc_car_id`) REFERENCES `def_car` (`car_id`),
  CONSTRAINT `tc_team_id` FOREIGN KEY (`tc_team_id`) REFERENCES `def_team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `def_team_car`
--

LOCK TABLES `def_team_car` WRITE;
/*!40000 ALTER TABLE `def_team_car` DISABLE KEYS */;
INSERT INTO `def_team_car` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `def_team_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lap`
--

DROP TABLE IF EXISTS `lap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lap` (
  `lap_id` int NOT NULL AUTO_INCREMENT,
  `lap_driver_id` int DEFAULT NULL,
  `lap_result_id` int DEFAULT NULL,
  `time` float DEFAULT NULL,
  `lapnumber` int NOT NULL,
  PRIMARY KEY (`lap_id`),
  UNIQUE KEY `laps_id_UNIQUE` (`lap_id`),
  KEY `lap_driver_id_idx` (`lap_driver_id`),
  CONSTRAINT `lap_driver_id` FOREIGN KEY (`lap_driver_id`) REFERENCES `def_driver` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lap`
--

LOCK TABLES `lap` WRITE;
/*!40000 ALTER TABLE `lap` DISABLE KEYS */;
/*!40000 ALTER TABLE `lap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `id` int NOT NULL,
  `result_driver_id` int DEFAULT NULL,
  `placement` int DEFAULT NULL,
  `qualifierplacement` int DEFAULT NULL,
  `time` float DEFAULT '0',
  `crashed` tinyint NOT NULL DEFAULT '0',
  `year` int DEFAULT NULL,
  `myteam` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`result_id`),
  UNIQUE KEY `result_id_UNIQUE` (`result_id`),
  KEY `result_driver_id_idx` (`result_driver_id`),
  CONSTRAINT `result_driver_id` FOREIGN KEY (`result_driver_id`) REFERENCES `def_driver` (`driver_id`) ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_game`
--

DROP TABLE IF EXISTS `save_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save_game` (
  `save_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`save_id`),
  UNIQUE KEY `save_id_UNIQUE` (`save_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_game`
--

LOCK TABLES `save_game` WRITE;
/*!40000 ALTER TABLE `save_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_game` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15 12:14:27
