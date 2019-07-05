/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-07-05 16:15:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `depart_desc` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'IT部', '程序猿');
INSERT INTO `department` VALUES ('2', '人事部', '很多美女');
INSERT INTO `department` VALUES ('3', '施工部', '糙汉子');
INSERT INTO `department` VALUES ('4', '财务部', '千万别惹他们！');
INSERT INTO `department` VALUES ('5', '行政部', '生活大管家');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user` int(11) DEFAULT NULL COMMENT '修改用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '部门1', null, null, null, null, null);
INSERT INTO `sys_dept` VALUES ('2', '部门2', null, null, null, null, null);
INSERT INTO `sys_dept` VALUES ('3', '部门3', null, null, null, null, null);
INSERT INTO `sys_dept` VALUES ('4', '部门4', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL COMMENT 'id',
  `format` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '格式',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `data` longblob COMMENT '数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `pass_word` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `email` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '用户部门id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '张三', '111', '111', '1');
INSERT INTO `sys_user` VALUES ('2', '李斯', '222', '222', '2');
INSERT INTO `sys_user` VALUES ('3', '王二', '333', '333', '3');
INSERT INTO `sys_user` VALUES ('4', '麻子', '444', '444', '4');
INSERT INTO `sys_user` VALUES ('5', '麻子2', '5555', '555', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_index_1` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'Jack', '20', '1');
INSERT INTO `user` VALUES ('3', 'Mike', '25', '1');
INSERT INTO `user` VALUES ('4', 'Lucy', '22', '2');
INSERT INTO `user` VALUES ('5', 'Mircle', '30', '3');
INSERT INTO `user` VALUES ('6', 'Josn', '45', '4');
INSERT INTO `user` VALUES ('7', 'Sgodon', '30', '5');

-- ----------------------------
-- Procedure structure for CountUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `CountUser`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CountUser`(IN sName VARCHAR(10), OUT num INT)
BEGIN
    SELECT COUNT(*) INTO num FROM user WHERE age > 30;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc`()
BEGIN
    SELECT * FROM user;
END
;;
DELIMITER ;
