/*
SQLyog Community v8.82 
MySQL - 5.1.47-community : Database - pharmacy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pharmacy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pharmacy`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`category`) values (1,'syrup'),(3,'syrups'),(4,'liquid');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_address` varchar(100) DEFAULT NULL,
  `customer_contact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`id`,`customer_name`,`customer_address`,`customer_contact`) values (1,'seasons','ktm','1234567896');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(50) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `qty` int(10) DEFAULT NULL,
  `costprice` varchar(50) DEFAULT NULL,
  `sellingprice` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `purchase_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `inventory` */

insert  into `inventory`(`id`,`itemname`,`supplier`,`qty`,`costprice`,`sellingprice`,`category`,`purchase_date`) values (1,'Opidol','ktm pharma',-22,'300','400','liquid','2018-02-05'),(2,'vatcr','ktm pharma',415,'6000','500','syrup','2018-02-01'),(5,'vatcruu','ktm pharma',-12,'6000','500','syrup','2018-02-02');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `alretunit` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`id`,`itemname`,`category`,`alretunit`) values (1,'vatcr','syrup',8),(3,'Opidol','liquid',9),(4,'Opidol','liquid',3),(5,'Opidol','liquid',10),(6,'vatcruu','syrup',10),(7,'vatcr','syrup',9);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(50) DEFAULT NULL,
  `Lastname` varchar(50) DEFAULT NULL,
  `Phone` bigint(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`Firstname`,`Lastname`,`Phone`,`username`,`password`,`role`) values (1,'seas','banjade',9811408869,'seees','admi','Admin'),(2,'season','banjade',9811408860,'sales','sales','staff'),(3,'season','banjade',9811408860,'seas','admin','Admin'),(4,'season','banjade',9811409960,'seas','admin','Admin'),(5,'seas','banjade',1234567890,'seees','seees','Admin'),(6,'seasi','banjaade',1234567892,'seas','drer','Admin'),(8,'admin','aadmin',9732910239,'admins','admin','Admin');

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `customername` varchar(59) DEFAULT NULL,
  `itemname` varchar(60) DEFAULT NULL,
  `category` varchar(60) DEFAULT NULL,
  `Price` varchar(60) DEFAULT NULL,
  `qty` varchar(60) DEFAULT NULL,
  `Total` varchar(10) DEFAULT NULL,
  `Costprice` varchar(20) DEFAULT NULL,
  `Grandtotal` varchar(20) DEFAULT 'sameas',
  `Date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `sales` */

insert  into `sales`(`id`,`customername`,`itemname`,`category`,`Price`,`qty`,`Total`,`Costprice`,`Grandtotal`,`Date`) values (1,'1','seasons','Opidol','liquid','400','7','2800','2772.0',NULL),(2,'2','seasons','vatcr','syrup','500','6','3000','2970.0',NULL),(3,'seasons','Opidol','liquid','400','8','3200','2400','3174.08',NULL),(4,'1','seasons','Opidol','liquid','400','2','800',NULL,'2018-02-10 12:13:44'),(5,'5','seasons','vatcruu','syrup','500','3','1500',NULL,'2018-02-10 12:13:44'),(6,'1','seasons','Opidol','liquid','400','7','2800',NULL,'2018-02-10 12:15:06'),(7,'2','seasons','vatcr','syrup','500','5','2500',NULL,'2018-02-10 12:15:06'),(8,'1','seasons','Opidol','liquid','400','3','1200',NULL,'2018-02-10 12:18:27'),(9,'2','seasons','vatcr','syrup','500','6','3000',NULL,'2018-02-10 12:18:27'),(10,'1','seasons','Opidol','liquid','400','6','2400',NULL,'2018-02-10 12:18:56'),(11,'2','seasons','vatcr','syrup','500','7','3500',NULL,'2018-02-10 12:18:56'),(12,'2','seasons','vatcr','syrup','500','7','3500',NULL,'2018-02-10 12:21:51'),(13,'1','seasons','Opidol','liquid','400','7','2800',NULL,'2018-02-10 12:21:51'),(14,'2','seasons','vatcr','syrup','500','3','1500',NULL,'2018-02-10 12:22:42'),(15,'5','seasons','vatcruu','syrup','500','3','1500',NULL,'2018-02-10 12:22:42'),(16,'2','seasons','vatcr','syrup','500','6','3000',NULL,'2018-02-10 12:24:59'),(17,'5','seasons','vatcruu','syrup','500','6','3000',NULL,'2018-02-10 12:24:59'),(18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'6026.4','2018-02-10 12:24:59');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Supplier_name` varchar(70) NOT NULL,
  `Contact` varchar(30) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Supplier_name`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`Supplier_name`,`Contact`,`Address`) values (4,'bhw pharma','9867055678','bhw'),(3,'brt pharma','6783901927','brt'),(2,'ktm pharma','7398919010','ktm'),(7,'lalitour pharma','5555555555','lalittpur'),(1,'nepal pharm','9811408860','ktm'),(6,'pkr pharma','1234567890','pkr');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
