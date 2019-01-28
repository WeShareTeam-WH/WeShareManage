/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : wesharedb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-14 21:52:10
*/
SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE IF NOT EXISTS `wesharedb` CHARACTER SET UTF8;

USE `wesharedb`;

-- ----------------------------
-- Table structure for agent_area
-- ----------------------------
DROP TABLE IF EXISTS `agent_area`;
CREATE TABLE `agent_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(20) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_area
-- ----------------------------

-- ----------------------------
-- Table structure for attributes_sku_mapping
-- ----------------------------
DROP TABLE IF EXISTS `attributes_sku_mapping`;
CREATE TABLE `attributes_sku_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) NOT NULL,
  `attribute_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `attribute_id` (`attribute_id`),
  KEY `sku_id` (`sku_id`) USING BTREE,
  CONSTRAINT `attributes_sku_mapping_ibfk_1` FOREIGN KEY (`sku_id`) REFERENCES `goods_sku` (`id`),
  CONSTRAINT `attributes_sku_mapping_ibfk_2` FOREIGN KEY (`attribute_id`) REFERENCES `goods_attributes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attributes_sku_mapping
-- ----------------------------
INSERT INTO `attributes_sku_mapping` VALUES ('1', '1', '1', '170', '2018-08-12 14:42:26', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('2', '1', '2', '红色', '2018-08-12 14:48:26', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('3', '1', '3', '布料', '2018-08-12 14:48:56', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('4', '2', '1', '170', '2018-08-14 21:44:38', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('5', '2', '2', '绿色', '2018-08-14 21:44:46', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('6', '2', '3', '棉', '2018-08-14 21:44:58', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('7', '3', '1', '170', '2018-08-14 21:48:43', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('8', '3', '2', '蓝色', '2018-08-14 21:49:03', '\0');
INSERT INTO `attributes_sku_mapping` VALUES ('9', '3', '3', '布料', '2018-08-14 21:49:10', '\0');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_type_id` bigint(20) NOT NULL,
  `goods_title` varchar(50) NOT NULL,
  `goods_descripe` varchar(200) NOT NULL,
  `goods_materiel` varchar(20) NOT NULL,
  `goods_address` varchar(100) DEFAULT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `goods_type_id` (`goods_type_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`goods_type_id`) REFERENCES `goods_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', 'sss', 'ssssssss', 'true', '中建康城', '2018-08-05 15:42:26', '\0');
INSERT INTO `goods` VALUES ('2', '1', 'afafa', 'dsdad', 'true', '中建康城', '2018-08-05 22:08:52', '\0');
INSERT INTO `goods` VALUES ('3', '1', 'gdgdg', 'sgsg', 'true', '中建康城', '2018-08-08 22:16:16', '\0');
INSERT INTO `goods` VALUES ('6', '1', 'gfsggs', 'sfsfsf', '', '中建康城', '2018-08-13 06:59:52', '\0');
INSERT INTO `goods` VALUES ('7', '1', 'dhdhdh', 'dhdhdhd', '', '中建康城', '2018-08-13 07:09:43', '\0');
INSERT INTO `goods` VALUES ('8', '1', 'sfsgsgsgsgs', '沙发', '', '中建康城', '2018-08-13 07:22:37', '\0');
INSERT INTO `goods` VALUES ('9', '1', 'sdsdsdds', 'sdsdsdsdsdsdsdsd', '', '中建康城', '2018-08-13 07:28:02', '\0');
INSERT INTO `goods` VALUES ('10', '1', 'asaasas', '', '', '', '2018-08-14 08:16:12', '\0');
INSERT INTO `goods` VALUES ('11', '1', 'asaasas', '', '', '', '2018-08-14 08:16:12', '\0');
INSERT INTO `goods` VALUES ('12', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('13', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('14', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('15', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('16', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('17', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('18', '1', 'j1', '', '', '中建康城', '2018-08-14 08:19:15', '\0');
INSERT INTO `goods` VALUES ('19', '1', 'dadada', '', '', '中建康城', '2018-08-14 08:33:04', '\0');
INSERT INTO `goods` VALUES ('20', '1', 'czz', '', '', '中建康城', '2018-08-14 08:49:57', '\0');
INSERT INTO `goods` VALUES ('21', '1', 'hjhkk', '', '', '中建康城', '2018-08-17 07:26:30', '\0');

-- ----------------------------
-- Table structure for goods_attributes
-- ----------------------------
DROP TABLE IF EXISTS `goods_attributes`;
CREATE TABLE `goods_attributes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_type_id` bigint(20) NOT NULL,
  `attribute` varchar(20) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `goods_type_id` (`goods_type_id`),
  CONSTRAINT `goods_attributes_ibfk_1` FOREIGN KEY (`goods_type_id`) REFERENCES `goods_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_attributes
-- ----------------------------
INSERT INTO `goods_attributes` VALUES ('1', '1', '尺码', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_attributes` VALUES ('2', '1', '颜色', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_attributes` VALUES ('3', '1', '面料', '2018-08-05 13:35:44', '\0');

-- ----------------------------
-- Table structure for goods_collection
-- ----------------------------
DROP TABLE IF EXISTS `goods_collection`;
CREATE TABLE `goods_collection` (
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `collection_time` datetime DEFAULT NULL,
  `cancel` bit(1) DEFAULT b'0',
  PRIMARY KEY (`user_id`,`goods_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `goods_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `goods_collection_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_collection
-- ----------------------------

-- ----------------------------
-- Table structure for goods_description
-- ----------------------------
DROP TABLE IF EXISTS `goods_description`;
CREATE TABLE `goods_description` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image_type_id` int(11) NOT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `image_order` int(11) NOT NULL,
  `image_description` varchar(300) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `image_type_id` (`image_type_id`),
  CONSTRAINT `goods_description_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `goods_description_ibfk_2` FOREIGN KEY (`image_type_id`) REFERENCES `image_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_description
-- ----------------------------
INSERT INTO `goods_description` VALUES ('1', '11', '很好看的校服', '1', 'https://cbu01.alicdn.com/img/ibank/2018/025/412/8687214520_114707678.310x310.jpg', '1', 'AAAAAAA', '2018-08-12 00:47:36', '\0');

-- ----------------------------
-- Table structure for goods_label
-- ----------------------------
DROP TABLE IF EXISTS `goods_label`;
CREATE TABLE `goods_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_type_id` bigint(20) NOT NULL,
  `label` varchar(20) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `goods_type_id` (`goods_type_id`),
  CONSTRAINT `goods_label_ibfk_1` FOREIGN KEY (`goods_type_id`) REFERENCES `goods_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_label
-- ----------------------------
INSERT INTO `goods_label` VALUES ('1', '1', '正装', '2018-08-05 13:35:43', '\0');
INSERT INTO `goods_label` VALUES ('2', '1', '演出服', '2018-08-05 13:35:43', '\0');
INSERT INTO `goods_label` VALUES ('3', '1', '毕业服', '2018-08-05 13:35:43', '\0');
INSERT INTO `goods_label` VALUES ('4', '1', '节日服', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_label` VALUES ('5', '1', '礼服', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_label` VALUES ('6', '1', 'Cosplay', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_label` VALUES ('7', '1', '古装', '2018-08-05 13:35:44', '\0');
INSERT INTO `goods_label` VALUES ('8', '1', '民族', '2018-08-05 13:35:44', '\0');

-- ----------------------------
-- Table structure for goods_label_mapping
-- ----------------------------
DROP TABLE IF EXISTS `goods_label_mapping`;
CREATE TABLE `goods_label_mapping` (
  `goods_id` bigint(20) NOT NULL,
  `goods_label_id` bigint(20) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`goods_id`,`goods_label_id`),
  KEY `goods_label_id` (`goods_label_id`),
  CONSTRAINT `goods_label_mapping_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `goods_label_mapping_ibfk_2` FOREIGN KEY (`goods_label_id`) REFERENCES `goods_label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_label_mapping
-- ----------------------------
INSERT INTO `goods_label_mapping` VALUES ('1', '1', '2018-08-13 21:59:14', '\0');
INSERT INTO `goods_label_mapping` VALUES ('1', '2', '2018-08-21 21:59:26', '\0');
INSERT INTO `goods_label_mapping` VALUES ('1', '3', '2018-08-14 21:59:35', '\0');
INSERT INTO `goods_label_mapping` VALUES ('2', '1', '2018-08-15 21:59:46', '\0');
INSERT INTO `goods_label_mapping` VALUES ('3', '2', '2018-08-14 22:00:00', '\0');
INSERT INTO `goods_label_mapping` VALUES ('19', '2', '2018-08-14 00:33:46', '\0');
INSERT INTO `goods_label_mapping` VALUES ('19', '4', '2018-08-14 00:33:46', '\0');
INSERT INTO `goods_label_mapping` VALUES ('20', '2', '2018-08-14 00:50:10', '\0');
INSERT INTO `goods_label_mapping` VALUES ('20', '4', '2018-08-14 00:50:10', '\0');
INSERT INTO `goods_label_mapping` VALUES ('21', '1', '2018-08-16 23:26:54', '\0');
INSERT INTO `goods_label_mapping` VALUES ('21', '3', '2018-08-16 23:26:54', '\0');
INSERT INTO `goods_label_mapping` VALUES ('21', '5', '2018-08-16 23:26:54', '\0');

-- ----------------------------
-- Table structure for goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL,
  `unit_price` decimal(5,2) NOT NULL,
  `avaliable_num` bigint(20) NOT NULL DEFAULT '0',
  `url` varchar(255) DEFAULT NULL,
  `collection_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `cancel` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `goods_sku_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------
INSERT INTO `goods_sku` VALUES ('1', '11', '20.00', '20', 'https://cbu01.alicdn.com/img/ibank/2015/734/075/2090570437_1165643193.310x310.jpg', '2018-08-12 01:37:36', '\0');
INSERT INTO `goods_sku` VALUES ('2', '11', '30.00', '25', 'https://cbu01.alicdn.com/img/ibank/2017/171/151/4636151171_1030411513.310x310.jpg', '2018-08-31 01:37:51', '\0');
INSERT INTO `goods_sku` VALUES ('3', '11', '40.00', '30', 'https://cbu01.alicdn.com/img/ibank/2016/485/629/2778926584_54216028.310x310.jpg', '2018-08-12 14:47:21', '\0');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '衣服', '2018-08-05 13:35:43', '\0');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('22');
INSERT INTO `hibernate_sequence` VALUES ('22');
INSERT INTO `hibernate_sequence` VALUES ('22');
INSERT INTO `hibernate_sequence` VALUES ('22');
INSERT INTO `hibernate_sequence` VALUES ('22');

-- ----------------------------
-- Table structure for image_type
-- ----------------------------
DROP TABLE IF EXISTS `image_type`;
CREATE TABLE `image_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image_type
-- ----------------------------
INSERT INTO `image_type` VALUES ('1', '首页图', '首页推荐图', '2018-08-12 00:49:43', '\0');
INSERT INTO `image_type` VALUES ('2', '详情图', '商品详情页面图', '2018-08-12 00:50:17', '\0');
INSERT INTO `image_type` VALUES ('3', '属性图', '商品详情页属性图', '2018-08-12 00:51:09', '\0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `total_count` decimal(5,2) NOT NULL,
  `actually_paid` decimal(5,2) NOT NULL,
  `status` varchar(10) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `user_address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `sku_id` bigint(20) NOT NULL,
  `unite_price` decimal(5,2) NOT NULL,
  `goods_number` int(5) NOT NULL,
  `total_count` decimal(5,2) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `sku_id` (`sku_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`sku_id`) REFERENCES `goods_sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) NOT NULL,
  `add_time` datetime NOT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '学生', '2018-08-05 13:35:41', '\0');
INSERT INTO `role` VALUES ('2', '学校代理', '2018-08-05 13:35:41', '\0');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `sku_id` bigint(20) NOT NULL,
  `purchase_quantity` int(5) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `remove` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `goods_id` (`goods_id`),
  KEY `sku_id` (`sku_id`),
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `shopping_cart_ibfk_3` FOREIGN KEY (`sku_id`) REFERENCES `goods_sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(100) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `agent_area_id` bigint(20) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `password_salt` varchar(50) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `email_true` bit(1) DEFAULT b'0',
  `phone` varchar(20) NOT NULL,
  `phone_true` bit(1) DEFAULT b'0',
  `pic_url` varchar(200) DEFAULT NULL,
  `head_img_url` varchar(200) DEFAULT NULL,
  `sex` tinyint(3) unsigned zerofill DEFAULT '000',
  `country` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `note` text,
  `type` int(11) DEFAULT NULL,
  `this_login_time` datetime NOT NULL,
  `this_login_ip` varchar(50) DEFAULT NULL,
  `last_login_time` datetime NOT NULL,
  `last_login_ip` varchar(50) DEFAULT NULL,
  `last_weixin_sigin_time` datetime DEFAULT NULL,
  `wallet` decimal(18,2) DEFAULT NULL,
  `add_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `agent_area_id` (`agent_area_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`agent_area_id`) REFERENCES `agent_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `country` varchar(10) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `county` varchar(10) DEFAULT NULL,
  `township` varchar(20) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  `detail_address` varchar(50) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_address
-- ----------------------------

-- ----------------------------
-- Table structure for user_comments
-- ----------------------------
DROP TABLE IF EXISTS `user_comments`;
CREATE TABLE `user_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `score` int(5) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `user_comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_comments_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comments
-- ----------------------------

-- ----------------------------
-- Table structure for user_comments_images
-- ----------------------------
DROP TABLE IF EXISTS `user_comments_images`;
CREATE TABLE `user_comments_images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) NOT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `user_comments_images_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `user_comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comments_images
-- ----------------------------