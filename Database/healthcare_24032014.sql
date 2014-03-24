-- MySQL dump 10.13  Distrib 5.6.16, for Win64 (x86_64)
--
-- Host: localhost    Database: healthcare
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `statecode` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'bbccd',1),(2,'ddd',1),(3,'ddd',4),(4,'ssa1111',1),(5,'ssa1111mynew',1),(6,'bbpleasedist',1);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `healthcenter`
--

DROP TABLE IF EXISTS `healthcenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `healthcenter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `next` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthcenter`
--

LOCK TABLES `healthcenter` WRITE;
/*!40000 ALTER TABLE `healthcenter` DISABLE KEYS */;
INSERT INTO `healthcenter` VALUES (22,'super_healthcenter',4,NULL),(23,'super_healthcenter',4,NULL),(24,'super_healthcenter',4,NULL),(25,'healthcente3',4,NULL),(26,'myhealthcenter',4,NULL);
/*!40000 ALTER TABLE `healthcenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `UHID` int(12) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(15) DEFAULT NULL,
  `MiddleName` varchar(15) DEFAULT NULL,
  `FirstName` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Age` int(2) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Occupation` varchar(30) DEFAULT NULL,
  `FatherHusbandName` varchar(30) DEFAULT NULL,
  `MotherName` varchar(30) DEFAULT NULL,
  `AddressLine1` varchar(100) DEFAULT NULL,
  `AddressLine2` varchar(100) DEFAULT NULL,
  `PinCode` varchar(10) DEFAULT NULL,
  `CityTownVillage` varchar(30) DEFAULT NULL,
  `Mandal` varchar(30) DEFAULT NULL,
  `District` varchar(30) DEFAULT NULL,
  `Sate` varchar(30) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Phone` int(15) DEFAULT NULL,
  `EmerContactPerName` varchar(45) DEFAULT NULL,
  `EmerContactPerRelationship` varchar(20) DEFAULT NULL,
  `EmerContactPerAddressLine1` varchar(100) DEFAULT NULL,
  `EmerContactPerAddressLine2` varchar(100) DEFAULT NULL,
  `EmerContactPerPinCode` varchar(10) DEFAULT NULL,
  `EmerContactPerCit` varchar(30) DEFAULT NULL,
  `EmerContactPerMandal` varchar(30) DEFAULT NULL,
  `EmerContactPerDistrict` varchar(30) DEFAULT NULL,
  `EmerContactPerState` varchar(30) DEFAULT NULL,
  `EmerContactPerPhone` int(15) DEFAULT NULL,
  `EmerContactPerPhoneNumber` int(15) DEFAULT NULL,
  `EmerContactPerEMail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UHID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'ss','ss','ss',NULL,NULL,NULL,'','','','','','','','','','','',NULL,'','','','','','','','','',NULL,NULL,''),(2,'','','',NULL,NULL,NULL,'','','','','','','','','','','',NULL,'','','','','','','','','',NULL,NULL,'');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'bbb'),(2,'new1'),(3,'vvv'),(4,'ss'),(5,'bbb'),(6,'bbb'),(7,'newstate'),(8,'newstate'),(9,'ssssweew');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usercode` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`usercode`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`usercode`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,'ROLE_USER'),(2,1,'ROLE_ADMIN'),(3,2,'ROLE_HEALTHCENTER'),(4,2,'ROLE_USER'),(5,2,'ROLE_HC_ADMIN'),(6,3,'ROLE_DOCTOR'),(7,3,'ROLE_USER'),(8,3,'ROLE_HEALTHCENTER'),(12,7,'ROLE_USER'),(13,7,'ROLE_HEALTHCENTER'),(14,7,'ROLE_DOCTOR'),(15,8,'ROLE_DOCTOR'),(16,8,'ROLE_USER'),(17,8,'ROLE_HEALTHCENTER'),(18,9,'ROLE_USER'),(19,9,'ROLE_DOCTOR'),(20,9,'ROLE_HEALTHCENTER'),(21,10,'ROLE_USER'),(22,10,'ROLE_CLERK'),(23,10,'ROLE_HEALTHCENTER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  `healthcentercode` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin',1,NULL),(2,'ysna','yna',1,26),(3,'mydoc','mydoc',1,NULL),(7,'ss111','sss',1,NULL),(8,'admin','admin',1,NULL),(9,'admin1111','admin',1,NULL),(10,'ccc1','ccc',1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-24  7:06:48
