/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : hsp

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 06/09/2023 10:42:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drivers
-- ----------------------------
DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '司机',
  `phone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电话',
  `wx_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'wx号',
  `origin` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '始发地',
  `dest` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '目的地',
  `equipment_count` int(2) NOT NULL COMMENT '装备数',
  `p_count` int(2) NOT NULL COMMENT '人数',
  `go_date` datetime NOT NULL COMMENT '出发日期',
  `remake` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `status` int(1) NULL DEFAULT NULL COMMENT '0正在拼 1已拼成 2已过期',
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '司机' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drivers_passenger_relation
-- ----------------------------
DROP TABLE IF EXISTS `drivers_passenger_relation`;
CREATE TABLE `drivers_passenger_relation`  (
  `id` int(11) NOT NULL,
  `drivers_id` int(11) NULL DEFAULT NULL COMMENT '司机id',
  `passenger_id` int(11) NULL DEFAULT NULL COMMENT '乘客id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '司机乘客关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for passenger
-- ----------------------------
DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger`  (
  `id` int(11) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电话',
  `wx_number` int(12) NULL DEFAULT NULL COMMENT 'wx号',
  `origin` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '始发地',
  `dest` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '目的地',
  `status` int(1) NOT NULL COMMENT '0正在拼 1已拼成',
  `go_date` datetime NOT NULL COMMENT '出发日期',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '乘客' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
