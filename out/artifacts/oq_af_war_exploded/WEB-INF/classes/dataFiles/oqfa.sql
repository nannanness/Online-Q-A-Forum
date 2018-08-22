/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : oqfa

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-27 20:08:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_Id` int(255) NOT NULL AUTO_INCREMENT,
  `user_Name` varchar(30) NOT NULL,
  `pass_Word` varchar(30) NOT NULL,
  `user_Sex` varchar(2) DEFAULT NULL,
  `user_Img` varchar(250) DEFAULT NULL,
  `user_Details` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
