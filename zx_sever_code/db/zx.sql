-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: risk_assesment_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `questionnaires_questions`
--

DROP TABLE IF EXISTS `questionnaires_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionnaires_questions` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `response_id` int DEFAULT NULL,
  `question_id` int DEFAULT NULL,
  `option_id` int DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`detail_id`),
  KEY `response_id_idx` (`response_id`),
  KEY `question_id_idx` (`question_id`),
  KEY `option_id_idx` (`option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='答题详细记录表，与题目表相关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaires_questions`
--

LOCK TABLES `questionnaires_questions` WRITE;
/*!40000 ALTER TABLE `questionnaires_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionnaires_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `questionnaires_questions_AFTER_INSERT` AFTER INSERT ON `questionnaires_questions` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `options` (
  `option_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `score` int DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT NULL,
  PRIMARY KEY (`option_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COMMENT='选项表，关联题目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (7,3,'2年以上',20,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(8,3,'1年-2年',10,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(9,3,'不到1年',5,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(10,4,'5次以上',20,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(11,4,'3次-5次',10,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(12,4,'1次-2次',5,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(13,5,'长期资产保值增值',20,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(14,5,'合理安排资金，分担风险',10,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(15,5,'流行趋势',5,'2023-11-18 12:59:01','2023-11-18 12:59:01',0),(16,6,'资本增值',20,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(17,6,'稳定收益',10,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(18,6,'分散投资，降低风险',5,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(19,7,'500万以上',20,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(20,7,'100万-500万',10,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(21,7,'100万以下',5,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(22,8,'大于500万',20,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(23,8,'100万-500万',10,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(24,8,'小于100万',5,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(25,9,'长期（3年以上）',20,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(26,9,'中期（1-3年）',10,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(27,9,'短期',5,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(28,10,'非常关注',20,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(29,10,'一般关注',10,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(30,10,'不太关注',5,'2023-11-18 13:21:58','2023-11-18 13:21:58',0),(31,11,'了解很多',20,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(32,11,'了解一些',10,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(33,11,'了解较少',5,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(34,12,'风险收益比',20,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(35,12,'投资期限',10,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(36,12,'费用水平',5,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(37,13,'保值增值',20,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(38,13,'资产增值',10,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(39,13,'追求高收益',5,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(40,14,'有丰富经验',20,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(41,14,'一般经验',10,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(42,14,'经验较少',5,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(43,15,'长期（3年以上）',20,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(44,15,'中期（1年-3年）',10,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(45,15,'短期',5,'2023-11-18 13:38:04','2023-11-18 13:38:04',0),(46,16,'大于500万',20,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(47,16,'500万-100万',10,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(48,16,'小于100万',5,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(49,17,'长期（3年以上）',20,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(50,17,'中期（1年-3年）',10,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(51,17,'短期（1年以内）',5,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(52,18,'高风险高回报',20,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(53,18,'中等风险中等回报',10,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(54,18,'低风险低回报',5,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(55,19,'非常注重',20,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(56,19,'一般注重',10,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(57,19,'不太注重',5,'2023-11-18 13:49:16','2023-11-18 13:49:16',0),(91,31,'10000元以上',20,'2023-11-18 19:28:57','2023-11-18 19:28:57',NULL),(92,31,'5000-10000元',10,'2023-11-18 19:28:57','2023-11-18 19:28:57',NULL),(93,31,'50000元以下',5,'2023-11-18 19:28:57','2023-11-18 19:28:57',NULL),(95,32,'10000元以上',20,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL),(96,32,'5000-10000元',10,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL),(97,32,'50000元以下',5,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL),(98,22,'现金和定期存款',20,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL),(99,22,'政府债券和理财产品',10,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL),(100,22,'股票或基金',5,'2023-11-18 19:33:43','2023-11-18 19:33:43',NULL);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `options_AFTER_INSERT` AFTER INSERT ON `options` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `questionnaires`
--

DROP TABLE IF EXISTS `questionnaires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionnaires` (
  `questionnaire_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `customer_type` int(4) DEFAULT NULL,
  `business_type` int(4) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`questionnaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='问卷表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaires`
--

LOCK TABLES `questionnaires` WRITE;
/*!40000 ALTER TABLE `questionnaires` DISABLE KEYS */;
INSERT INTO `questionnaires` VALUES (1,'理财产品问卷调查表','个人','理财','2023-11-17 22:11:25','2023-11-17 22:11:25',0),(2,'理财产品问卷调查表','公司','理财','2023-11-17 22:13:00','2023-11-17 22:13:00',0),(3,'基金产品问卷调查表','个人','基金','2023-11-17 22:13:41','2023-11-17 22:13:41',0),(4,'基金产品问卷调查表','公司','基金','2023-11-17 22:14:11','2023-11-17 22:14:11',0),(5,'资管产品问卷调查表','个人','资管','2023-11-18 11:47:54','2023-11-18 11:47:54',0),(6,'资管产品问卷调查表','公司','资管','2023-11-18 11:48:46','2023-11-18 11:48:46',0),(7,'信托产品问卷调查表','个人','信托','2023-11-18 11:49:17','2023-11-18 11:49:17',0),(8,'信托产品问卷调查表','公司','信托','2023-11-18 11:49:45','2023-11-18 11:49:45',0);
/*!40000 ALTER TABLE `questionnaires` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questionnaires_AFTER_INSERT` AFTER INSERT ON `questionnaires` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questionnaires_AFTER_UPDATE` AFTER UPDATE ON `questionnaires` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questionnaires_AFTER_DELETE` AFTER DELETE ON `questionnaires` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`question_id`),
  KEY `questionnarie_id_idx` (`questionnaire_id`),
  KEY `questionnaire_id_idx` (`questionnaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='问题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'这是更新后的题目内容','2023-11-18 11:59:20','2023-11-18 14:34:08',0),(2,1,'您最青睐的理财投资是什么','2023-11-18 11:59:20','2023-11-18 11:59:20',0),(3,1,'您接触理财产品的时间','2023-11-18 11:59:20','2023-11-18 11:59:20',0),(4,1,'您购买理财产品的次数','2023-11-18 11:59:20','2023-11-18 11:59:20',0),(5,1,'您购买理财产品的主要目的','2023-11-18 11:59:20','2023-11-18 11:59:20',0),(6,2,'您的公司投资理财的主要目标是什么','2023-11-18 12:27:04','2023-11-18 12:27:04',0),(7,2,'您的公司大致年收入为多少','2023-11-18 12:27:04','2023-11-18 12:27:04',0),(8,2,'您的公司投资理财产品的预算规模是多少','2023-11-18 12:27:04','2023-11-18 12:27:04',0),(9,2,'您的公司投资理财产品的期限偏好是几年','2023-11-18 12:27:04','2023-11-18 12:27:04',0),(10,2,'您的公司是否关注风险收益比','2023-11-18 12:27:04','2023-11-18 12:27:04',0),(11,3,'您对基金产品的了解程度如何','2023-11-18 12:30:19','2023-11-18 12:30:19',0),(12,3,'您投资基金产品时更看重的是什么','2023-11-18 12:30:19','2023-11-18 12:30:19',0),(13,3,'您的投资目标是什么','2023-11-18 12:30:19','2023-11-18 12:30:19',0),(14,3,'您的投资经验如何','2023-11-18 12:30:19','2023-11-18 12:30:19',0),(15,3,'您对基金的投资偏好','2023-11-18 12:30:19','2023-11-18 12:30:19',0),(16,4,'您的公司投资基金产品的预算规模是多少','2023-11-18 12:36:13','2023-11-18 12:36:13',0),(17,4,'您的公司对于基金的投资目标偏好是','2023-11-18 12:36:13','2023-11-18 12:36:13',0),(18,4,'您的公司对于基金的投资风险承受能力如何','2023-11-18 12:36:13','2023-11-18 12:36:13',0),(19,4,'您的公司是否注重基金经理的经验和业绩','2023-11-18 12:36:13','2023-11-18 12:36:13',0),(32,5,'您每个月的可投资资金规模是多少','2023-11-18 19:33:43','2023-11-18 19:33:43',0);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questions_AFTER_INSERT` AFTER INSERT ON `questions` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questions_AFTER_UPDATE` AFTER UPDATE ON `questions` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Questions_AFTER_DELETE` AFTER DELETE ON `questions` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `response_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `questionnaire_id` int DEFAULT NULL,
  `completionTime` datetime DEFAULT NULL,
  `totalScore` int DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTimt` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`response_id`),
  KEY `user_is_idx` (`user_id`),
  KEY `questionnaire_id_idx` (`questionnaire_id`),
  CONSTRAINT `questionnaire_id` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaires` (`questionnaire_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='选项表，与问卷表关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Response_AFTER_INSERT` AFTER INSERT ON `response` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `risklevels`
--

DROP TABLE IF EXISTS `risklevels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `risklevels` (
  `risklevel_id` int NOT NULL AUTO_INCREMENT,
  `response_id` int DEFAULT NULL,
  `level_name` varchar(255) DEFAULT NULL,
  `level_score` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`risklevel_id`),
  KEY `response_id_idx` (`response_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风险等级表，5个风险等级';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risklevels`
--

LOCK TABLES `risklevels` WRITE;
/*!40000 ALTER TABLE `risklevels` DISABLE KEYS */;
INSERT INTO `risklevels` VALUES (1,NULL,'高风险','20<=得分<=40','2023-11-18 19:41:38','2023-11-18 19:41:38',0),(2,NULL,'较高风险','40<=得分<=60','2023-11-18 19:41:38','2023-11-18 19:41:38',0),(3,NULL,'中等风险','60<=得分<=70','2023-11-18 19:41:38','2023-11-18 19:41:38',0),(4,NULL,'较低风险','70<=得分<=80','2023-11-18 19:41:38','2023-11-18 19:41:38',0),(5,NULL,'低风险','80<=得分<=100','2023-11-18 19:41:38','2023-11-18 19:41:38',0);
/*!40000 ALTER TABLE `risklevels` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `RiskLevels_AFTER_INSERT` AFTER INSERT ON `risklevels` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `RiskLevels_AFTER_UPDATE` AFTER UPDATE ON `risklevels` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `RiskLevels_AFTER_DELETE` AFTER DELETE ON `risklevels` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `user_type` enum('user','admin') DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Users_AFTER_INSERT` AFTER INSERT ON `users` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Users_AFTER_UPDATE` AFTER UPDATE ON `users` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Users_AFTER_DELETE` AFTER DELETE ON `users` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'risk_assesment_db'
--

--
-- Dumping routines for database 'risk_assesment_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-19 11:06:30
