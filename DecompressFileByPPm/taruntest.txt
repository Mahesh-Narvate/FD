/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.45-community-nt : Database - cloud1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cloud1`;

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `Name` varchar(45) NOT NULL,
  `Email` varchar(100) default NULL,
  `Address` varchar(100) default NULL,
  `PhonNo` varchar(100) default NULL,
  `Password` varchar(100) default NULL,
  `ExpectedStorage` varchar(100) default NULL,
  `ExpectedGetRequest` varchar(100) default NULL,
  `ExpectedPutRequest` varchar(100) default NULL,
  `ReplicationRequired` varchar(100) NOT NULL default 'No',
  `NoofReplication` varchar(100) NOT NULL default '0',
  `cloudId` varchar(45) default NULL,
  `ReservationTimeSpan` varchar(100) default NULL,
  `Dominant` varchar(100) default NULL,
  `Discount` double default NULL,
  PRIMARY KEY  (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`Name`,`Email`,`Address`,`PhonNo`,`Password`,`ExpectedStorage`,`ExpectedGetRequest`,`ExpectedPutRequest`,`ReplicationRequired`,`NoofReplication`,`cloudId`,`ReservationTimeSpan`,`Dominant`,`Discount`) values ('a','a@gmail.com','aaaaaa','9049676149','aaaaaa','10GB','10000000','100000','2018-11-10','2019-11-10','751439',NULL,NULL,NULL),('alex@gmail.com','alex@gmail.com','aaaaaa','9049676149','aaaaaa','10GB','10000000','100000','2018-11-10','2019-11-10','154567',NULL,NULL,NULL),('d','d@gmail.com','ddddddd','9049676149','dddddd','1GB','10000000','100000','2018-11-10','2019-11-10','975402',NULL,NULL,NULL),('m','m@gmail.com','mmmmmm','9049676149','mmmmmm','100GB','10000000','100000','2018-10-11','2019-11-12','751562',NULL,NULL,NULL),('nancy','nancy@gmail.com','nnnnnn','9049676149','nnnnnn','10GB','10000000','100000','2018-11-12','2019-12-21','661634',NULL,NULL,NULL),('sohail','s@gmail.com','pune','8411844464','ssssss','1MB','10000000','100000','No','100000','870983','15days',NULL,NULL),('t','t@gmail.com','tttttt','9049676149','tttttt','10GB','10000000','100000','2018-11-12','2019-11-12','410834',NULL,NULL,NULL),('yy','yy@gmail.com','yy','9049676149','yyyyyy','1GB','1000','200','2011-12-18','2011-12-18','789968',NULL,NULL,NULL),('zz','zz@gmail.com','zz','9049676149','zzzzzz','1GB','400','200','2018-12-11','2019-12-11','856537',NULL,NULL,NULL);

/*Table structure for table `requirment` */

DROP TABLE IF EXISTS `requirment`;

CREATE TABLE `requirment` (
  `Duration` varchar(12) NOT NULL default '',
  `StorageSize` varchar(6) NOT NULL,
  `Get` varchar(100) NOT NULL,
  `Put` varchar(100) NOT NULL,
  `ReplicationRequired` varchar(100) NOT NULL,
  `NoofReplication` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `requirment` */

insert  into `requirment`(`Duration`,`StorageSize`,`Get`,`Put`,`ReplicationRequired`,`NoofReplication`) values ('1 month','2mb','20','50','10','20'),('5 month','50 mb','30','20','10','5'),('5 month','50 mb','30','20','10','5'),('1 year','30 mb','45','15','60','70'),('2 year','60 mb','35','20','15','12'),('5 month','','','','',''),('5 month','','','','',''),('5 month','100 gb','1000000','100000','10000','20000');

/*Table structure for table `userregister` */

DROP TABLE IF EXISTS `userregister`;

CREATE TABLE `userregister` (
  `Name` varchar(40) default NULL,
  `Email` varchar(40) default NULL,
  `Address` varchar(40) default NULL,
  `mo_no` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `cloudId` varchar(100) NOT NULL default '0',
  PRIMARY KEY  (`cloudId`),
  UNIQUE KEY `cloudId_UNIQUE` (`cloudId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userregister` */

insert  into `userregister`(`Name`,`Email`,`Address`,`mo_no`,`password`,`cloudId`) values ('alex','alex@gmail.com','U.S.A','7410258969','aaaaaa','154567'),('t','t@gmail.com','INDIA','8806537614','tttttt','410834'),('nancy','nancy@gmail.com','USA','3210456907','nnnnnn','661634'),('a','a@gmail.com','INDIA','9513576824','aaaaaa','751439'),('m','m@gmail.com','INDIA','7410289630','mmmmmm','751562'),('yy','yy@gmail.com','yy','9049676149','yyyyyy','789968'),('zz','zz@gmail.com','zz','9049676149','zzzzzz','856537'),('d','d@gmail.com','U.A.E','7410258900','dddddd','975402');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
