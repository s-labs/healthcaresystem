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
-- Table structure for table `allergy_history`
--

DROP TABLE IF EXISTS `allergy_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allergy_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `AllergicTO` varchar(50) DEFAULT NULL,
  `ReactionDate` date DEFAULT NULL,
  `ReactionType` varchar(50) DEFAULT NULL,
  `Prescription` varchar(50) DEFAULT NULL,
  `Notes` varchar(100) DEFAULT NULL,
  `DoctorName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergy_history`
--

LOCK TABLES `allergy_history` WRITE;
/*!40000 ALTER TABLE `allergy_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `allergy_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child_immunisation`
--

DROP TABLE IF EXISTS `child_immunisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `child_immunisation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `child_last_name` varchar(15) DEFAULT NULL,
  `child_middle_name` varchar(15) DEFAULT NULL,
  `child_first_name` varchar(15) DEFAULT NULL,
  `Gender` varchar(5) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `father_name` varchar(30) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Age` int(2) DEFAULT NULL,
  `BCG_AT_BIRTH` date DEFAULT NULL,
  `OPV0_AT_BIRTH` date DEFAULT NULL,
  `HEPATATISB1_AT_BIRTH` date DEFAULT NULL,
  `DPT1_AT_6WEEKS` date DEFAULT NULL,
  `OPV1_AT_6WEEKS` date DEFAULT NULL,
  `HEPATATISB2_AT_6WEEKS` date DEFAULT NULL,
  `DPT2_AT_10WEEKS` date DEFAULT NULL,
  `OPV2_AT_10WEEKS` date DEFAULT NULL,
  `HEPATATISB3_AT_10WEEKS` date DEFAULT NULL,
  `DPT3_AT_14WEEKS` date DEFAULT NULL,
  `OPV3_AT_14WEEKS` date DEFAULT NULL,
  `HEPATATISB4_AT_10WEEKS` date DEFAULT NULL,
  `MEASLES_9_12_MONTHS` date DEFAULT NULL,
  `VITAMINA_DOSE1_9_12_MONTHS` date DEFAULT NULL,
  `MR_VACCINE_16_24_MONTHS` date DEFAULT NULL,
  `DPT_BOOSTER_16_24_MONTHS` date DEFAULT NULL,
  `OPV_BOOSTER_16_24_MONTHS` date DEFAULT NULL,
  `VITAMINA_DOSE2_16_24_MONTHS` date DEFAULT NULL,
  `VITAMINA_DOSE3_16_24_MONTHS` date DEFAULT NULL,
  `VITAMINA_DOSE4TO9_2YRS` date DEFAULT NULL,
  `DT5_2YRS` date DEFAULT NULL,
  `TT10` date DEFAULT NULL,
  `TT16` date DEFAULT NULL,
  `Remarks` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_immunisation`
--

LOCK TABLES `child_immunisation` WRITE;
/*!40000 ALTER TABLE `child_immunisation` DISABLE KEYS */;
/*!40000 ALTER TABLE `child_immunisation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disease_information_lookup`
--

DROP TABLE IF EXISTS `disease_information_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disease_information_lookup` (
  `DiseaseCode` int(11) NOT NULL AUTO_INCREMENT,
  `DiseaseName` varchar(40) DEFAULT NULL,
  `DiseaseDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DiseaseCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease_information_lookup`
--

LOCK TABLES `disease_information_lookup` WRITE;
/*!40000 ALTER TABLE `disease_information_lookup` DISABLE KEYS */;
/*!40000 ALTER TABLE `disease_information_lookup` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_presciption_lookup`
--

DROP TABLE IF EXISTS `drug_presciption_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drug_presciption_lookup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DiseaseCode` int(20) DEFAULT NULL,
  `DrugPrescription` varchar(100) DEFAULT NULL,
  `Notes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_presciption_lookup`
--

LOCK TABLES `drug_presciption_lookup` WRITE;
/*!40000 ALTER TABLE `drug_presciption_lookup` DISABLE KEYS */;
/*!40000 ALTER TABLE `drug_presciption_lookup` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthcenter`
--

LOCK TABLES `healthcenter` WRITE;
/*!40000 ALTER TABLE `healthcenter` DISABLE KEYS */;
INSERT INTO `healthcenter` VALUES (1,'super',1,1),(41,'Tirupathi district healthcenter',3,42),(42,'andhrapradesh state headquater',2,1),(43,'karimanagar district healthcenter',3,42),(44,'adilabad district healthcenter',3,42),(45,'godavarikhani healthcenter',4,43);
/*!40000 ALTER TABLE `healthcenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitalisation_history`
--

DROP TABLE IF EXISTS `hospitalisation_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospitalisation_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `care_provider_name` varchar(20) DEFAULT NULL,
  `care_provider_add_line1` varchar(20) DEFAULT NULL,
  `care_provider_add_line2` varchar(20) DEFAULT NULL,
  `care_provider_city` varchar(20) DEFAULT NULL,
  `care_provider_mandal` varchar(20) DEFAULT NULL,
  `care_provider_district` varchar(20) DEFAULT NULL,
  `care_provider_state` varchar(20) DEFAULT NULL,
  `care_provider_pin_num` varchar(20) DEFAULT NULL,
  `care_provider_phone_num` int(20) DEFAULT NULL,
  `care_provider_email` varchar(20) DEFAULT NULL,
  `insurance_status` varchar(20) DEFAULT NULL,
  `insurance_id` varchar(20) DEFAULT NULL,
  `episode_type` varchar(20) DEFAULT NULL,
  `episode_num` varchar(20) DEFAULT NULL,
  `encounter_type` varchar(20) DEFAULT NULL,
  `encounter_num` varchar(20) DEFAULT NULL,
  `encounter_date_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitalisation_history`
--

LOCK TABLES `hospitalisation_history` WRITE;
/*!40000 ALTER TABLE `hospitalisation_history` DISABLE KEYS */;
INSERT INTO `hospitalisation_history` VALUES (1,6,'dd','ss','sd','adag','','','','',NULL,'','','','','','','',NULL),(2,6,'dd','ss','sd','','','','','',NULL,'','','','','','','',NULL);
/*!40000 ALTER TABLE `hospitalisation_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infant_details`
--

DROP TABLE IF EXISTS `infant_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `infant_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `OutcomeNumber` varchar(5) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `MiddleName` varchar(30) DEFAULT NULL,
  `FirstName` varchar(30) DEFAULT NULL,
  `Gender` varchar(5) DEFAULT NULL,
  `DateTimeofBirth` datetime DEFAULT NULL,
  `Weight` decimal(2,2) DEFAULT NULL,
  `Initiatedbreastfeedingwithinonehour` char(1) DEFAULT NULL,
  `Remarks` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infant_details`
--

LOCK TABLES `infant_details` WRITE;
/*!40000 ALTER TABLE `infant_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `infant_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_history`
--

DROP TABLE IF EXISTS `medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `op` varchar(15) DEFAULT NULL,
  `accPatient` varchar(15) DEFAULT NULL,
  `emerPatient` varchar(15) DEFAULT NULL,
  `reasonForVisit` varchar(15) DEFAULT NULL,
  `presentHistory` varchar(15) DEFAULT NULL,
  `pastHistory` varchar(15) DEFAULT NULL,
  `personalHistory` varchar(15) DEFAULT NULL,
  `familyHistory` varchar(15) DEFAULT NULL,
  `problemForm` date DEFAULT NULL,
  `doctorName` varchar(15) DEFAULT NULL,
  `notes` varchar(15) DEFAULT NULL,
  `fromDate` date DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  `progress` varchar(15) DEFAULT NULL,
  `advice` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_history`
--

LOCK TABLES `medical_history` WRITE;
/*!40000 ALTER TABLE `medical_history` DISABLE KEYS */;
INSERT INTO `medical_history` VALUES (1,7,'ss','ss','s',NULL,'','','','','',NULL,'','',NULL,NULL,'','');
/*!40000 ALTER TABLE `medical_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication_details`
--

DROP TABLE IF EXISTS `medication_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medication_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `medication_name` varchar(15) DEFAULT NULL,
  `drug_code` varchar(15) DEFAULT NULL,
  `strength` varchar(15) DEFAULT NULL,
  `dose` varchar(15) DEFAULT NULL,
  `route` varchar(15) DEFAULT NULL,
  `frequency` varchar(15) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `next_check_up` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication_details`
--

LOCK TABLES `medication_details` WRITE;
/*!40000 ALTER TABLE `medication_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `medication_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication_treatment`
--

DROP TABLE IF EXISTS `medication_treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medication_treatment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UHID` int(12) DEFAULT NULL,
  `ClinicalExamVitalsSystolicBP` varchar(3) DEFAULT NULL,
  `ClinicalExamVitalsDiastolicBP` varchar(3) DEFAULT NULL,
  `ClinicalExamPulseRate` varchar(3) DEFAULT NULL,
  `ClinicalExamTemperature` decimal(2,2) DEFAULT NULL,
  `ClinicalExamHeight_cms` decimal(3,2) DEFAULT NULL,
  `ClinicalExamWeight_kgs` decimal(3,2) DEFAULT NULL,
  `BloodGroup` varchar(3) DEFAULT NULL,
  `ClinicalExamObservation` blob,
  `InvestigationResults` blob,
  `ClinicalSummary` blob,
  `DiagnosisType` varchar(11) DEFAULT NULL,
  `DiagnosisCodeName` varchar(50) DEFAULT NULL,
  `DiagnosisCode` varchar(10) DEFAULT NULL,
  `DiagnosisDescription` blob,
  `TreatmentPlanInvestigations` blob,
  `TreatmentPlanMedication` blob,
  `TreatmentPlanProcedure` blob,
  `TreatmentPlanReferral` blob,
  `OtherTreatmentPlanType` varchar(10) DEFAULT NULL,
  `OtherTreatmentPlanDetails` blob,
  `CurrentClinicalStatus` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication_treatment`
--

LOCK TABLES `medication_treatment` WRITE;
/*!40000 ALTER TABLE `medication_treatment` DISABLE KEYS */;
/*!40000 ALTER TABLE `medication_treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `UHID` int(12) NOT NULL AUTO_INCREMENT,
  `healthcentercode` int(12) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (5,43,'knrlname','knrmname','knfirstname','1985-01-13',29,NULL,'se','knfat','knrmote','','','','','','','','',NULL,'','','','','','','','','',NULL,NULL,''),(6,42,'gdklname','gdkmname','gdkfname',NULL,NULL,NULL,'','','','','','','','','','','',NULL,'','','','','','','','','',NULL,NULL,''),(7,43,'newgdklname','newgdkmname','gdkfname',NULL,NULL,NULL,'','','','','','','','','','','',NULL,'','','','','','','','','',NULL,NULL,'');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pnc_details`
--

DROP TABLE IF EXISTS `pnc_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pnc_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `PNCHomevisit` varchar(40) DEFAULT NULL,
  `PNCComplications` varchar(40) DEFAULT NULL,
  `POST_PARTUM_CONTRACEPTION_METHOD` varchar(40) DEFAULT NULL,
  `PNCCheckup` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pnc_details`
--

LOCK TABLES `pnc_details` WRITE;
/*!40000 ALTER TABLE `pnc_details` DISABLE KEYS */;
INSERT INTO `pnc_details` VALUES (1,2,'sa','ss','a','2014-12-12');
/*!40000 ALTER TABLE `pnc_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregnancy_history`
--

DROP TABLE IF EXISTS `pregnancy_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregnancy_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `lmp` date DEFAULT NULL,
  `first_anc` date DEFAULT NULL,
  `second_anc` date DEFAULT NULL,
  `third_anc` date DEFAULT NULL,
  `fourth_anc` date DEFAULT NULL,
  `tt1` date DEFAULT NULL,
  `tt2` date DEFAULT NULL,
  `ttbooster` date DEFAULT NULL,
  `complication` varchar(15) DEFAULT NULL,
  `rti_sti` varchar(15) DEFAULT NULL,
  `ifa_tablets_given` date DEFAULT NULL,
  `anaemia_hb_level` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregnancy_history`
--

LOCK TABLES `pregnancy_history` WRITE;
/*!40000 ALTER TABLE `pregnancy_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `pregnancy_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregnancy_outcome`
--

DROP TABLE IF EXISTS `pregnancy_outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregnancy_outcome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `PlaceofDelivery` varchar(40) DEFAULT NULL,
  `DeliveryType` varchar(40) DEFAULT NULL,
  `complications` varchar(40) DEFAULT NULL,
  `DateofDelivery` date DEFAULT NULL,
  `DateofDischarge` date DEFAULT NULL,
  `abortion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregnancy_outcome`
--

LOCK TABLES `pregnancy_outcome` WRITE;
/*!40000 ALTER TABLE `pregnancy_outcome` DISABLE KEYS */;
/*!40000 ALTER TABLE `pregnancy_outcome` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (10,'Andhra pradesh'),(11,'Karnataka'),(12,'Kerala');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surgical_history`
--

DROP TABLE IF EXISTS `surgical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surgical_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uhid` int(11) NOT NULL,
  `Surgery` varchar(40) DEFAULT NULL,
  `SurgeryDate` date DEFAULT NULL,
  `doctorName` varchar(45) DEFAULT NULL,
  `PlaceofSurgery` varchar(100) DEFAULT NULL,
  `SurgeryProcedure` varchar(250) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `Notes` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surgical_history`
--

LOCK TABLES `surgical_history` WRITE;
/*!40000 ALTER TABLE `surgical_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `surgical_history` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,'ROLE_USER'),(2,1,'ROLE_ADMIN'),(27,12,'ROLE_USER'),(28,12,'ROLE_HC_ADMIN'),(29,12,'ROLE_HEALTHCENTER'),(30,13,'ROLE_USER'),(31,13,'ROLE_HEALTHCENTER'),(32,13,'ROLE_HC_ADMIN'),(33,14,'ROLE_HC_ADMIN'),(34,14,'ROLE_HEALTHCENTER'),(35,14,'ROLE_USER'),(36,15,'ROLE_HEALTHCENTER'),(37,15,'ROLE_HC_ADMIN'),(38,15,'ROLE_USER'),(39,16,'ROLE_HC_ADMIN'),(40,16,'ROLE_USER'),(41,16,'ROLE_HEALTHCENTER'),(42,17,'ROLE_USER'),(43,17,'ROLE_DOCTOR'),(44,17,'ROLE_HEALTHCENTER'),(45,18,'ROLE_DOCTOR'),(46,18,'ROLE_HEALTHCENTER'),(47,18,'ROLE_USER'),(48,19,'ROLE_USER'),(49,19,'ROLE_CLERK'),(50,19,'ROLE_HEALTHCENTER'),(51,20,'ROLE_CLERK'),(52,20,'ROLE_HEALTHCENTER'),(53,20,'ROLE_USER'),(54,21,'ROLE_HEALTHCENTER'),(55,21,'ROLE_USER'),(56,21,'ROLE_HC_ADMIN'),(57,22,'ROLE_DHS'),(58,22,'ROLE_USER');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','password',1,1),(12,'ysna','password',1,NULL),(13,'gdkadmin','password',1,45),(14,'knradmin','password',1,43),(15,'tirupathi_admin','password',1,41),(16,'ap_admin','password',1,42),(17,'gdkdoc','password',1,45),(18,'knrdoctor','password',1,43),(19,'knrclerk','password',1,43),(20,'gdkclerk','password',1,45),(21,'apadmin','password',1,42),(22,'dhs','dhs',1,NULL);
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

-- Dump completed on 2014-03-31 22:36:22
