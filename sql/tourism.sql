/*
Navicat MySQL Data Transfer

Source Server         : zhide
Source Server Version : 50153
Source Host           : localhost:13307
Source Database       : tourism

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2019-03-26 14:54:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL COMMENT '评论内容',
  `user_id` int(255) NOT NULL COMMENT '(外键)关联字段，与用户id相关联',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '图片名称',
  `path` varchar(255) NOT NULL COMMENT '图片路径',
  `view_id` int(255) NOT NULL COMMENT '(外键)关联字段，与景点id想关联',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ticketname` varchar(255) NOT NULL COMMENT '票名',
  `starttime` datetime NOT NULL COMMENT '开始生效时间',
  `endtime` datetime NOT NULL COMMENT '生效结束时间',
  `ticket_num` int(255) NOT NULL COMMENT '门票数',
  `price` int(255) NOT NULL COMMENT '门票价格',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `view_id` int(255) NOT NULL COMMENT '(外键)关联字段，与景点id相关联',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '登录账号',
  `password` varchar(255) NOT NULL COMMENT '登录密码',
  `fullname` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱信息',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for view
-- ----------------------------
DROP TABLE IF EXISTS `view`;
CREATE TABLE `view` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `viewname` varchar(255) NOT NULL COMMENT '景点名称',
  `introduction` text COMMENT '景点简介',
  `type` varchar(255) DEFAULT NULL COMMENT '景点类型(人文，自然)',
  `address` varchar(255) DEFAULT NULL COMMENT '景点地址',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of view
-- ----------------------------
