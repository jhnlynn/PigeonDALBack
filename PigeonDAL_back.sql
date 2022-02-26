/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : PigeonDAL_back

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 26/02/2022 17:05:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `bid` bigint NOT NULL COMMENT 'Batch ID',
  `bnum` bigint NOT NULL COMMENT 'Batch number',
  `bstatus` tinyint NOT NULL COMMENT '0 - In warehouse\n1 - In transit\n2 - arrived\n',
  `btrack` varchar(40) NOT NULL COMMENT 'Tracking number',
  `donations_did` varchar(40) NOT NULL,
  `carrier_cid` tinyint DEFAULT NULL,
  `warehouse_wid` tinyint DEFAULT NULL,
  `manufacturer_mid` tinyint NOT NULL,
  `product_pid` tinyint NOT NULL,
  `shipment_sid` varchar(40) NOT NULL,
  `request_rid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `batch_carrier_fk` (`carrier_cid`),
  KEY `batch_donations_fk` (`donations_did`),
  KEY `batch_manufacturer_fk` (`manufacturer_mid`),
  KEY `batch_product_fk` (`product_pid`),
  KEY `batch_request_fk` (`request_rid`),
  KEY `batch_shipment_fk` (`shipment_sid`),
  KEY `batch_warehouse_fk` (`warehouse_wid`),
  CONSTRAINT `batch_carrier_fk` FOREIGN KEY (`carrier_cid`) REFERENCES `carrier` (`cid`),
  CONSTRAINT `batch_manufacturer_fk` FOREIGN KEY (`manufacturer_mid`) REFERENCES `manufacturer` (`mid`),
  CONSTRAINT `batch_product_fk` FOREIGN KEY (`product_pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `batch_shipment_fk` FOREIGN KEY (`shipment_sid`) REFERENCES `shipment` (`sid`),
  CONSTRAINT `batch_warehouse_fk` FOREIGN KEY (`warehouse_wid`) REFERENCES `warehouse` (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for carrier
-- ----------------------------
DROP TABLE IF EXISTS `carrier`;
CREATE TABLE `carrier` (
  `cid` tinyint NOT NULL COMMENT 'Carrier ID',
  `cname` varchar(10) NOT NULL COMMENT 'Carrier Name',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for donations
-- ----------------------------
DROP TABLE IF EXISTS `donations`;
CREATE TABLE `donations` (
  `did` varchar(40) NOT NULL COMMENT 'Donations ID',
  `dtotal` bigint NOT NULL COMMENT 'Total number',
  `dmin` bigint NOT NULL COMMENT 'The smallest number this supply can be divided into. E.g. 1000 masks are packed into smaller packets each contains 10 masks. MUST > 0 and is a divisible of total number.',
  `user_uid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `donations_user_fk` (`user_uid`),
  CONSTRAINT `donations_user_fk` FOREIGN KEY (`user_uid`) REFERENCES `USER` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Donations, stored in Firestore';

-- ----------------------------
-- Table structure for manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE `manufacturer` (
  `mid` tinyint NOT NULL COMMENT 'Manufacturer ID',
  `mname` varchar(40) NOT NULL COMMENT 'Manufacturer NAME',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for manufacturer_product
-- ----------------------------
DROP TABLE IF EXISTS `manufacturer_product`;
CREATE TABLE `manufacturer_product` (
  `manufacturer_mid` tinyint NOT NULL,
  `product_pid` tinyint NOT NULL,
  PRIMARY KEY (`manufacturer_mid`,`product_pid`),
  KEY `manufacturer_product_product_fk` (`product_pid`),
  CONSTRAINT `manufacturer_product_manufacturer_fk` FOREIGN KEY (`manufacturer_mid`) REFERENCES `manufacturer` (`mid`),
  CONSTRAINT `manufacturer_product_product_fk` FOREIGN KEY (`product_pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` tinyint NOT NULL,
  `pname` varchar(25) NOT NULL COMMENT 'Product name',
  `request_rid` varchar(40) DEFAULT NULL,
  `rptotal` bigint DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `product_request_fk` (`request_rid`),
  CONSTRAINT `product_request_fk` FOREIGN KEY (`request_rid`) REFERENCES `request` (`rid`),
  CONSTRAINT `product_chk_1` CHECK ((((`request_rid` is null) and (`rptotal` is null)) or ((`request_rid` is not null) and (`rptotal` is not null))))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `rid` varchar(40) NOT NULL COMMENT 'Request ID',
  `rpid` bigint NOT NULL COMMENT 'Request product type, ArrayList',
  `user_uid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `request_user_fk` (`user_uid`),
  CONSTRAINT `request_user_fk` FOREIGN KEY (`user_uid`) REFERENCES `USER` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for shipment
-- ----------------------------
DROP TABLE IF EXISTS `shipment`;
CREATE TABLE `shipment` (
  `sid` varchar(40) NOT NULL COMMENT 'Shipment/Package ID.',
  `stype` tinyint NOT NULL COMMENT '0 - Ground\n1 - Air\n2 - Sea',
  `trackid` varbinary(40) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `UID` varchar(40) NOT NULL,
  `ufname` varchar(20) NOT NULL COMMENT 'User''s first name',
  `ulname` varchar(20) NOT NULL COMMENT 'User''s last name',
  `usex` double NOT NULL COMMENT 'Male - 1 Female 0',
  `uemail` varchar(40) NOT NULL,
  `utype` tinyint NOT NULL COMMENT '0 - Super Admin\n1 - Warehouse Admin\n2 - Regional Admin\n1 - general user\n... TODO',
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `wid` tinyint NOT NULL COMMENT 'Warehouse ID',
  `waddr1` varchar(80) NOT NULL COMMENT 'Warehouse address line 1',
  `waddr2` varchar(20) NOT NULL COMMENT 'Warehouse address line 2',
  `wcity` varchar(20) NOT NULL COMMENT 'Warehouse City',
  `wstate` varchar(20) NOT NULL COMMENT 'Warehouse State/Provience',
  `wcountry` varchar(20) NOT NULL COMMENT 'Warehouse Country',
  `wzip` bigint NOT NULL COMMENT 'Warehouse zip code',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
