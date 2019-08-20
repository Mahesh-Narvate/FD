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

/*Table structure for table `admindiscount` */

DROP TABLE IF EXISTS `admindiscount`;

CREATE TABLE `admindiscount` (
  `UserEmail` varchar(100) NOT NULL,
  `Discount` double default '10',
  PRIMARY KEY  (`UserEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admindiscount` */

insert  into `admindiscount`(`UserEmail`,`Discount`) values ('mahesh1@gmail.com',50),('mahesh2@gmail.com',50),('mahesh@gmail.com',50),('mahsh2@gmail.com',50),('sharma@gmail.com',50),('tarun@gmail.com',50);

/*Table structure for table `adminlogin` */

DROP TABLE IF EXISTS `adminlogin`;

CREATE TABLE `adminlogin` (
  `Email` varchar(100) NOT NULL,
  `password` varchar(45) default NULL,
  PRIMARY KEY  (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `adminlogin` */

insert  into `adminlogin`(`Email`,`password`) values ('t@gmail.com','tttttt');

/*Table structure for table `finalpoolstoredudetails` */

DROP TABLE IF EXISTS `finalpoolstoredudetails`;

CREATE TABLE `finalpoolstoredudetails` (
  `Email` varchar(45) default NULL,
  `cloudid` varchar(100) default NULL,
  `filename` varchar(1000) default NULL,
  `filesize` double default '0',
  `date` date default NULL,
  `time` varchar(100) default NULL,
  `CloudName` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `finalpoolstoredudetails` */

insert  into `finalpoolstoredudetails`(`Email`,`cloudid`,`filename`,`filesize`,`date`,`time`,`CloudName`) values ('tarun@gmail.com','659695','cloud1.ppm',4,'2019-06-24','12:39 PM','aws'),('tarun@gmail.com','659695','cloud1.ppm',4,'2019-06-24','12:39 PM','azur'),('tarun@gmail.com','659695','cloud1.ppm',4,'2019-06-24','12:39 PM','gcs');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `Name` varchar(45) default '',
  `Email` varchar(100) NOT NULL,
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
  `StartDate` date default NULL,
  `EndDate` date default NULL,
  PRIMARY KEY  (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`Name`,`Email`,`Address`,`PhonNo`,`Password`,`ExpectedStorage`,`ExpectedGetRequest`,`ExpectedPutRequest`,`ReplicationRequired`,`NoofReplication`,`cloudId`,`ReservationTimeSpan`,`Dominant`,`StartDate`,`EndDate`) values ('mahesh','mahesh@gmail.com','pune','9049676149','mmmmmm','5MB','1000000','1000','Yes','3','188738','1Month','GetDominant','2019-05-15','2019-05-22'),('sharma','sharma@gmail.com','pune','7747474747','tarunsharma','10MB','5000','500000','Yes','3','520813','1Month','PutDominant','2019-05-30','2019-06-06'),('tarun','tarun@gmail.com','pune','9049676149','tttttt','1MB','900','1000000','Yes','3','659695','1Month','PutDominant','2019-04-26','2019-05-03');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
