-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: univ
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` varchar(10) NOT NULL,
  `pw` varchar(10) NOT NULL,
  `user` varchar(10) NOT NULL,
  `power` varchar(5) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1','1','a101','a','1111-11-11'),('2','2','p101','p','1989-10-15'),('3','3','s101','s','1999-08-05'),('4','4','p102','p','2010-04-21'),('5','5','s102','s','2000-11-11'),('6','5','p103','p','2000-11-11');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attended`
--

DROP TABLE IF EXISTS `attended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attended` (
  `indexno` int NOT NULL AUTO_INCREMENT,
  `std_code` varchar(5) NOT NULL,
  `prof_code` varchar(15) NOT NULL,
  `subj_code` varchar(15) NOT NULL,
  `year` varchar(5) NOT NULL,
  PRIMARY KEY (`indexno`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attended`
--

LOCK TABLES `attended` WRITE;
/*!40000 ALTER TABLE `attended` DISABLE KEYS */;
INSERT INTO `attended` VALUES (25,'s102','p103','003','2023'),(29,'s105','p104','006','2024'),(30,'s105','p106','012','2024'),(31,'s101','p104','007','2022'),(32,'s101','p106','005','2023'),(35,'s102','p101','001','2024'),(36,'s102','p104','006','2024'),(37,'s102','p106','005','2023');
/*!40000 ALTER TABLE `attended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `deptNum` varchar(10) NOT NULL,
  `deptName` varchar(10) NOT NULL,
  `majorName` varchar(10) NOT NULL,
  PRIMARY KEY (`deptNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('d001','컴퓨터공학','데이터베이스'),('d002','방사선','방사'),('d003','물리치료','물치'),('d004','사무자동화','OA'),('d005','간호','간호'),('d006','컴공','자바');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `pCode` varchar(5) NOT NULL,
  `name` varchar(10) NOT NULL,
  `addr` varchar(15) NOT NULL,
  `rNum` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `year` varchar(5) NOT NULL,
  `degree` varchar(15) NOT NULL,
  `deptNum` varchar(15) NOT NULL,
  `office` varchar(10) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`pCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('p101','김하나','대구','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d001','101호','여자'),('p102','김두리','서울','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d002','101호','남자'),('p103','김세찌','서울','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d004','101호','여자'),('p104','김네시','서울','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d006','101호','여자'),('p105','김다섯','서울','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d005','101호','남자'),('p106','김여섯','서울','111111-1111111','010-2737-2222','(053)333-3333','2020','박사','d003','101호','여자');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `indexno` int NOT NULL AUTO_INCREMENT,
  `prof_code` varchar(10) NOT NULL,
  `std_code` varchar(10) NOT NULL,
  `subj_code` varchar(10) NOT NULL,
  `year` varchar(10) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `term` varchar(10) DEFAULT NULL,
  `middle` int DEFAULT NULL,
  `final` int DEFAULT NULL,
  `report` int DEFAULT NULL,
  `attended` int DEFAULT NULL,
  `added` int DEFAULT NULL,
  `sum` int DEFAULT NULL,
  `grade_value` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`indexno`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (11,'p104','s105','006','2024','3학년','2학기',0,0,0,0,0,0,NULL),(12,'p106','s105','012','2024','3학년','2학기',0,0,0,0,0,0,NULL),(13,'p104','s101','007','2022','3학년','2학기',0,0,0,0,0,0,NULL),(14,'p106','s101','005','2023','1학년','1학기',0,0,0,0,0,0,NULL),(17,'p101','s102','001','2024','3학년','2학기',30,0,20,20,0,70,'C'),(18,'p104','s102','006','2024','3학년','2학기',30,0,20,20,0,70,'C'),(19,'p101','s103','001','2023','1학년','1학기',30,0,20,20,0,70,'C');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `sNum` varchar(5) NOT NULL,
  `name` varchar(10) NOT NULL,
  `addr` varchar(10) NOT NULL,
  `rNum` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `startYear` varchar(5) NOT NULL,
  `school` varchar(10) NOT NULL,
  `endYear` varchar(5) NOT NULL,
  `dept_code` varchar(15) DEFAULT NULL,
  `prof_code` varchar(10) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`sNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('s101','최길만','대구','111111-1111111','010-0000-2222','(053)394-4939','2022','고','2222','d001','p101','남자'),('s102','박철동','대구','111111-1111111','010-0000-2222','(053)394-4939','2022','고','2222','d005','p102','남자'),('s103','홍길동','대구','111111-1111111','010-0000-2222','(053)394-4939','2022','고','2222','d002','p104','여자'),('s104','김수지','대구','111111-1111111','010-0000-2222','(053)394-4939','2022','고','2222','d004','p106','여자'),('s105','주상철','대구','111111-1111111','010-0000-2222','(053)394-4939','2022','고','2222','d006','p103','남자');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `code` varchar(5) NOT NULL,
  `subject` varchar(15) NOT NULL,
  `dept_code` varchar(15) NOT NULL,
  `year` varchar(5) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `term` varchar(10) NOT NULL,
  `hour` varchar(5) NOT NULL,
  `prof_code` varchar(10) NOT NULL,
  `credit` varchar(5) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('001','물리','d003','2024','3학년','2학기','2','p101','2'),('002','사무','d004','2022','1학년','1학기','3','p102','6'),('003','간호','d005','2023','2학년','4겨울학기','1','p103','3'),('004','방사','d002','2021','4학년','3여름학기','4','p105','5'),('005','자바','d001','2023','1학년','1학기','5','p106','1'),('006','파이썬','d006','2024','3학년','2학기','6','p104','4'),('007','JSP','d001','2022','3학년','2학기','6','p104','4'),('008','물리1','d003','2024','3학년','2학기','2','p101','2'),('009','사무1','d004','2022','1학년','1학기','3','p102','6'),('010','간호1','d005','2023','2학년','4겨울학기','1','p103','3'),('011','방사1','d002','2024','3학년','2학기','6','p105','4'),('012','안드로이드','d006','2024','3학년','2학기','6','p106','4');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 16:10:39
