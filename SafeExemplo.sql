CREATE DATABASE  IF NOT EXISTS `cadastrosfe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cadastrosfe`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cadastrosfe
-- ------------------------------------------------------
-- Server version	8.0.22

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
  `id_admin` int NOT NULL AUTO_INCREMENT,
  `nome_admin` varchar(40) NOT NULL,
  `cpf_admin` int NOT NULL,
  `instituição_admin` varchar(60) NOT NULL,
  `email_admin` varchar(50) NOT NULL,
  `senha_admin` varchar(20) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `email_admin_UNIQUE` (`email_admin`),
  UNIQUE KEY `cpf_admin_UNIQUE` (`cpf_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK2pojw9weqmkc0476cs86vyyrb` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `idade_aluno` int NOT NULL,
  `matricula_aluno` varchar(20) NOT NULL,
  `responsavel_aluno` varchar(30) NOT NULL,
  `id` bigint NOT NULL,
  `id_turma` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ec3awj7r0vo8fkkbbhdbtpgq8` (`matricula_aluno`),
  KEY `FK6u9nh0rofks23793tl5j0f7v3` (`id_turma`),
  CONSTRAINT `FK6u9nh0rofks23793tl5j0f7v3` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKc8wsngo14dwn23nvgsty37bfx` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (22,'1','Daniel',4,1),(22,'2','Maria',5,1),(22,'3','Dorival',6,2),(15,'1234-1234','Rosangela Silva',7,3),(14,'4782-5478','Alberto Souza',8,2),(14,'4568-4567','mariza cardoso',10,2);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividade`
--

DROP TABLE IF EXISTS `atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividade` (
  `data_entrega_atividade` varchar(255) DEFAULT NULL,
  `id_atividade` bigint NOT NULL,
  `id_professor` bigint DEFAULT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FKgn6u008vo7rmamrtsk7irmm9f` (`id_professor`),
  CONSTRAINT `FKgn6u008vo7rmamrtsk7irmm9f` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id`),
  CONSTRAINT `FKm2dndv4kbtsl855ce6s9enupn` FOREIGN KEY (`id_atividade`) REFERENCES `extraatividade` (`id_atividade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade`
--

LOCK TABLES `atividade` WRITE;
/*!40000 ALTER TABLE `atividade` DISABLE KEYS */;
INSERT INTO `atividade` VALUES ('23/02/2021',1,NULL),('24/02/2021',2,NULL),('24/02/2021',3,NULL);
/*!40000 ALTER TABLE `atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividade_aluno`
--

DROP TABLE IF EXISTS `atividade_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividade_aluno` (
  `id_atividade` bigint NOT NULL AUTO_INCREMENT,
  `conteudo_atividade` varchar(255) DEFAULT NULL,
  `corrigido_atividade` bit(1) DEFAULT NULL,
  `data_entrega_atividade` datetime(6) DEFAULT NULL,
  `entregue_atividade` bit(1) DEFAULT NULL,
  `nota_atividade` varchar(255) DEFAULT NULL,
  `id` bigint DEFAULT NULL,
  `id_turma` bigint DEFAULT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FK2e90y509f0km5axkaom01kkja` (`id`),
  KEY `FKt1b18geascytvv1roohyudgfq` (`id_turma`),
  CONSTRAINT `FK2e90y509f0km5axkaom01kkja` FOREIGN KEY (`id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `FKt1b18geascytvv1roohyudgfq` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade_aluno`
--

LOCK TABLES `atividade_aluno` WRITE;
/*!40000 ALTER TABLE `atividade_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `atividade_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraatividade`
--

DROP TABLE IF EXISTS `extraatividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extraatividade` (
  `id_atividade` bigint NOT NULL AUTO_INCREMENT,
  `conteudo_atividade` varchar(255) DEFAULT NULL,
  `data_postagem_atividade` varchar(255) DEFAULT NULL,
  `materia_atividade` varchar(40) NOT NULL,
  `nome_atividade` varchar(255) DEFAULT NULL,
  `id_professor` bigint DEFAULT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FKj1whgqmwd3r2oysuee77hhjwr` (`id_professor`),
  CONSTRAINT `FKj1whgqmwd3r2oysuee77hhjwr` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraatividade`
--

LOCK TABLES `extraatividade` WRITE;
/*!40000 ALTER TABLE `extraatividade` DISABLE KEYS */;
INSERT INTO `extraatividade` VALUES (1,NULL,'23/02/2021','Português','',2),(2,NULL,'24/02/2021','','',2),(3,NULL,'24/02/2021','Português','Apresentação',2);
/*!40000 ALTER TABLE `extraatividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraatividade_turma`
--

DROP TABLE IF EXISTS `extraatividade_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extraatividade_turma` (
  `ExtraAtividade_id_atividade` bigint NOT NULL,
  `turmas_id_turma` bigint NOT NULL,
  KEY `FK3wilkkgjxt6mw2dtocksatdew` (`turmas_id_turma`),
  KEY `FKjx8xtbipbt8yvc4u1wtr11wld` (`ExtraAtividade_id_atividade`),
  CONSTRAINT `FK3wilkkgjxt6mw2dtocksatdew` FOREIGN KEY (`turmas_id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKjx8xtbipbt8yvc4u1wtr11wld` FOREIGN KEY (`ExtraAtividade_id_atividade`) REFERENCES `extraatividade` (`id_atividade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraatividade_turma`
--

LOCK TABLES `extraatividade_turma` WRITE;
/*!40000 ALTER TABLE `extraatividade_turma` DISABLE KEYS */;
INSERT INTO `extraatividade_turma` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(1,1),(2,3),(3,3);
/*!40000 ALTER TABLE `extraatividade_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frequencia`
--

DROP TABLE IF EXISTS `frequencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frequencia` (
  `id_frequencia` bigint NOT NULL AUTO_INCREMENT,
  `presenca` varchar(30) NOT NULL,
  `id_aluno` bigint DEFAULT NULL,
  `id_turma` bigint DEFAULT NULL,
  PRIMARY KEY (`id_frequencia`),
  KEY `FKrugb8qb45joomoqo6lpgl9qlt` (`id_aluno`),
  KEY `FKb8el3l0va38qeooty2q9l5oib` (`id_turma`),
  CONSTRAINT `FKb8el3l0va38qeooty2q9l5oib` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKrugb8qb45joomoqo6lpgl9qlt` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frequencia`
--

LOCK TABLES `frequencia` WRITE;
/*!40000 ALTER TABLE `frequencia` DISABLE KEYS */;
INSERT INTO `frequencia` VALUES (1,'sim',4,1),(2,'sim',5,1),(3,'nao',6,1),(4,'sim',7,1),(5,'sim',8,1),(6,'sim',4,1),(7,'sim',5,1),(8,'nao',6,1),(9,'sim',7,1),(10,'sim',8,1);
/*!40000 ALTER TABLE `frequencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKluxnu0qdopy9qdid4brfrw5wt` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (2),(3),(9);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsavel`
--

DROP TABLE IF EXISTS `responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsavel` (
  `id_responsavel` int NOT NULL AUTO_INCREMENT,
  `nome_responsavel` varchar(30) NOT NULL,
  `sobrenome_responsavel` varchar(20) NOT NULL,
  `numero_responsavel` int NOT NULL,
  `cpf_responsavel` int NOT NULL,
  `email_responsavel` varchar(40) NOT NULL,
  `senha_responsavel` varchar(20) NOT NULL,
  PRIMARY KEY (`id_responsavel`),
  UNIQUE KEY `cpf_responsavel_UNIQUE` (`cpf_responsavel`),
  UNIQUE KEY `numero_responsavel_UNIQUE` (`numero_responsavel`),
  UNIQUE KEY `email_responsavel_UNIQUE` (`email_responsavel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsavel`
--

LOCK TABLES `responsavel` WRITE;
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumo`
--

DROP TABLE IF EXISTS `resumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resumo` (
  `id_atividade` bigint NOT NULL,
  `id_professor` bigint DEFAULT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FKe46khjj7sny9cavy37jgb2rk8` (`id_professor`),
  CONSTRAINT `FK2ipfgv1eydtk4hioobhw5vqk9` FOREIGN KEY (`id_atividade`) REFERENCES `extraatividade` (`id_atividade`),
  CONSTRAINT `FKe46khjj7sny9cavy37jgb2rk8` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumo`
--

LOCK TABLES `resumo` WRITE;
/*!40000 ALTER TABLE `resumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `resumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `id_turma` bigint NOT NULL AUTO_INCREMENT,
  `turma_serie` varchar(1) NOT NULL,
  `tipoEnsino` varchar(255) DEFAULT NULL,
  `turma` varchar(40) NOT NULL,
  PRIMARY KEY (`id_turma`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'1','ANOS_INICIAIS','A'),(2,'7','ENSINO_FUNDAMENTAL','B'),(3,'2','ENSINO_MEDIO','B');
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_atividade`
--

DROP TABLE IF EXISTS `turma_atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma_atividade` (
  `turma_id` bigint NOT NULL,
  `atividade_id` bigint NOT NULL,
  KEY `FKc7e71brbrkfi127t8dth0jcbn` (`atividade_id`),
  KEY `FKfaysx9ok5iqyljt002pfw5r6a` (`turma_id`),
  CONSTRAINT `FKc7e71brbrkfi127t8dth0jcbn` FOREIGN KEY (`atividade_id`) REFERENCES `atividade` (`id_atividade`),
  CONSTRAINT `FKfaysx9ok5iqyljt002pfw5r6a` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_atividade`
--

LOCK TABLES `turma_atividade` WRITE;
/*!40000 ALTER TABLE `turma_atividade` DISABLE KEYS */;
INSERT INTO `turma_atividade` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `turma_atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_professor`
--

DROP TABLE IF EXISTS `turma_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma_professor` (
  `turma_id` bigint NOT NULL,
  `id` bigint NOT NULL,
  KEY `FKs7l0axjv9te9qnla7c5tghs1f` (`id`),
  KEY `FKgebnucfia04rcb2rv3773hlhh` (`turma_id`),
  CONSTRAINT `FKgebnucfia04rcb2rv3773hlhh` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKs7l0axjv9te9qnla7c5tghs1f` FOREIGN KEY (`id`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_professor`
--

LOCK TABLES `turma_professor` WRITE;
/*!40000 ALTER TABLE `turma_professor` DISABLE KEYS */;
INSERT INTO `turma_professor` VALUES (1,3),(1,9);
/*!40000 ALTER TABLE `turma_professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_resumo`
--

DROP TABLE IF EXISTS `turma_resumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma_resumo` (
  `turma_id` bigint NOT NULL,
  `resumo_id` bigint NOT NULL,
  KEY `FKln20dce3uuiqyk67562twpppq` (`resumo_id`),
  KEY `FKa5ahwxgs4p6vojh4nfkhhx9wl` (`turma_id`),
  CONSTRAINT `FKa5ahwxgs4p6vojh4nfkhhx9wl` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKln20dce3uuiqyk67562twpppq` FOREIGN KEY (`resumo_id`) REFERENCES `resumo` (`id_atividade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_resumo`
--

LOCK TABLES `turma_resumo` WRITE;
/*!40000 ALTER TABLE `turma_resumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turma_resumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `sobrenome` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_692bsnqxa8m9fmx7m1yc6hsui` (`cpf`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'32132132155','carlos@email.com','Carlos','12345678','Gabriel'),(2,'12365412365','allan@email.com','Allan','12345678','Sabino'),(3,'47357538358','simone@email.com','Simone','87654321','Fraga'),(4,'23572485256','nicolas@email.com','Nicolas','12345678','Seibel'),(5,'24561451464','guilherme@email.com','Guilherme','87654321','Martins'),(6,'14735854545','william@email.com','William','01020304','Souza'),(7,'12345678901','GustavoSi@email.com','Gustavo','123123123','Silva'),(8,'01245612342','joaquinGon@email.com','Joaquin','jojo1234','Gonsalves'),(9,'11122233344','reginaca@email.com','Regina','reginhinha123','casé'),(10,'14562398744','joselitinho@email.com','joselito','joseLito123','morais');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-25 21:33:19
