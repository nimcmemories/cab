CREATE DATABASE  IF NOT EXISTS `cab` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cab`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cab
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

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
-- Table structure for table `cbentity`
--

DROP TABLE IF EXISTS `cbentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbentity` (
  `entityid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `profiledetailid` bigint(20) NOT NULL,
  PRIMARY KEY (`entityid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_cbentity_1_idx` (`profiledetailid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbentity`
--

LOCK TABLES `cbentity` WRITE;
/*!40000 ALTER TABLE `cbentity` DISABLE KEYS */;
INSERT INTO `cbentity` VALUES (1,'system_manager','system manager entity is only for cbsuper profile ',0),(2,'reservation','book/reserve service.',1);
/*!40000 ALTER TABLE `cbentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbevents`
--

DROP TABLE IF EXISTS `cbevents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbevents` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `eventtype` int(11) NOT NULL,
  `helperid` int(11) NOT NULL,
  PRIMARY KEY (`eventid`),
  KEY `fk_cbevents_1_idx` (`helperid`),
  CONSTRAINT `fk_cbevents_1` FOREIGN KEY (`helperid`) REFERENCES `cbhelpers` (`helperid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbevents`
--

LOCK TABLES `cbevents` WRITE;
/*!40000 ALTER TABLE `cbevents` DISABLE KEYS */;
INSERT INTO `cbevents` VALUES (1,1,1);
/*!40000 ALTER TABLE `cbevents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbhelpers`
--

DROP TABLE IF EXISTS `cbhelpers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbhelpers` (
  `helperid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `subentityid` int(11) NOT NULL,
  PRIMARY KEY (`helperid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_cbhelpers_1_idx` (`subentityid`),
  CONSTRAINT `fk_cbhelpers_1` FOREIGN KEY (`subentityid`) REFERENCES `cbsubentity` (`subentityid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbhelpers`
--

LOCK TABLES `cbhelpers` WRITE;
/*!40000 ALTER TABLE `cbhelpers` DISABLE KEYS */;
INSERT INTO `cbhelpers` VALUES (1,'com.cab.helper.TestHelper',3);
/*!40000 ALTER TABLE `cbhelpers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbprofile`
--

DROP TABLE IF EXISTS `cbprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbprofile` (
  `profileid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'profile name should be unique. Any user must have one profile assigned, user may not have more then one profile.',
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`profileid`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbprofile`
--

LOCK TABLES `cbprofile` WRITE;
/*!40000 ALTER TABLE `cbprofile` DISABLE KEYS */;
INSERT INTO `cbprofile` VALUES (1,'cbsuper','cbsuper is a super user of entire system including everything.'),(2,'cbenduser','user is an enduser who consumes system\'s services');
/*!40000 ALTER TABLE `cbprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbprofiledetail`
--

DROP TABLE IF EXISTS `cbprofiledetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbprofiledetail` (
  `profiledetailid` bigint(20) NOT NULL AUTO_INCREMENT,
  `profileid` int(11) NOT NULL,
  `subentityid` int(11) NOT NULL,
  `accesstype` int(11) NOT NULL DEFAULT '0' COMMENT 'access type : 0 for no access 1 for read only 2 for read write access',
  PRIMARY KEY (`profiledetailid`),
  KEY `fk_cbprofiledetail_1_idx` (`profileid`),
  KEY `fk_cbprofiledetail_2_idx` (`subentityid`),
  CONSTRAINT `fk_cbprofiledetail_1` FOREIGN KEY (`profileid`) REFERENCES `cbprofile` (`profileid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cbprofiledetail_2` FOREIGN KEY (`subentityid`) REFERENCES `cbsubentity` (`subentityid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbprofiledetail`
--

LOCK TABLES `cbprofiledetail` WRITE;
/*!40000 ALTER TABLE `cbprofiledetail` DISABLE KEYS */;
INSERT INTO `cbprofiledetail` VALUES (1,1,1,2),(3,1,2,2),(4,2,3,2);
/*!40000 ALTER TABLE `cbprofiledetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbsubentity`
--

DROP TABLE IF EXISTS `cbsubentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbsubentity` (
  `subentityid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(50) NOT NULL,
  `entityid` int(11) NOT NULL,
  PRIMARY KEY (`subentityid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_cbsubentity_1_idx` (`entityid`),
  CONSTRAINT `fk_cbsubentity_1` FOREIGN KEY (`entityid`) REFERENCES `cbentity` (`entityid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbsubentity`
--

LOCK TABLES `cbsubentity` WRITE;
/*!40000 ALTER TABLE `cbsubentity` DISABLE KEYS */;
INSERT INTO `cbsubentity` VALUES (1,'alert_system','alert system will provide different types of alert',1),(2,'users','list users and its tree with their access type and',1),(3,'reserve_cab','book/reserve cab ',2);
/*!40000 ALTER TABLE `cbsubentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbuser`
--

DROP TABLE IF EXISTS `cbuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `typeid` int(11) DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  `parentid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_cbuser_1_idx` (`typeid`),
  KEY `fk_cbuser_2_idx` (`profileid`),
  CONSTRAINT `fk_cbuser_1` FOREIGN KEY (`profileid`) REFERENCES `cbprofile` (`profileid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cbuser_2` FOREIGN KEY (`typeid`) REFERENCES `cbusertype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbuser`
--

LOCK TABLES `cbuser` WRITE;
/*!40000 ALTER TABLE `cbuser` DISABLE KEYS */;
INSERT INTO `cbuser` VALUES (1,'super','super',1,1,NULL),(4,'guestuser','guestuser',4,2,0);
/*!40000 ALTER TABLE `cbuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbusertype`
--

DROP TABLE IF EXISTS `cbusertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbusertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbusertype`
--

LOCK TABLES `cbusertype` WRITE;
/*!40000 ALTER TABLE `cbusertype` DISABLE KEYS */;
INSERT INTO `cbusertype` VALUES (1,'superuser','super user havin all access of the system'),(4,'guestuser','');
/*!40000 ALTER TABLE `cbusertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-09  7:57:30
