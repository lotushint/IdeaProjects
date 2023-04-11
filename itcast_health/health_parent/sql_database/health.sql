/*
 Navicat Premium Data Transfer

 Source Server         : centos
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : 192.168.245.129:3306
 Source Schema         : health

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 10/04/2023 15:28:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_checkgroup
-- ----------------------------
DROP TABLE IF EXISTS `t_checkgroup`;
CREATE TABLE `t_checkgroup`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `helpCode` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `attention` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_checkgroup
-- ----------------------------
INSERT INTO `t_checkgroup` VALUES (5, '0001', '一般检查', 'YBJC', '0', '一般检查', '无');
INSERT INTO `t_checkgroup` VALUES (6, '0002', '视力色觉', 'SLSJ', '0', '视力色觉', NULL);
INSERT INTO `t_checkgroup` VALUES (7, '0003', '血常规', 'XCG', '0', '血常规', NULL);
INSERT INTO `t_checkgroup` VALUES (8, '0004', '尿常规', 'NCG', '0', '尿常规', NULL);
INSERT INTO `t_checkgroup` VALUES (9, '0005', '肝功三项', 'GGSX', '0', '肝功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (10, '0006', '肾功三项', 'NGSX', '0', '肾功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (11, '0007', '血脂四项', 'XZSX', '0', '血脂四项', NULL);
INSERT INTO `t_checkgroup` VALUES (12, '0008', '心肌酶三项', 'XJMSX', '0', '心肌酶三项', NULL);
INSERT INTO `t_checkgroup` VALUES (13, '0009', '甲功三项', 'JGSX', '0', '甲功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (14, '0010', '子宫附件彩超', 'ZGFJCC', '2', '子宫附件彩超', NULL);
INSERT INTO `t_checkgroup` VALUES (15, '0011', '胆红素三项', 'DHSSX', '0', '胆红素三项', NULL);
INSERT INTO `t_checkgroup` VALUES (16, '0012', 'fdfs', 'fdsa', '0', 'sad毛线', '毛线fdf');

-- ----------------------------
-- Table structure for t_checkgroup_checkitem
-- ----------------------------
DROP TABLE IF EXISTS `t_checkgroup_checkitem`;
CREATE TABLE `t_checkgroup_checkitem`  (
  `checkgroup_id` int NOT NULL DEFAULT 0,
  `checkitem_id` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`checkgroup_id`, `checkitem_id`) USING BTREE,
  INDEX `item_id`(`checkitem_id` ASC) USING BTREE,
  CONSTRAINT `group_id` FOREIGN KEY (`checkgroup_id`) REFERENCES `t_checkgroup` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `item_id` FOREIGN KEY (`checkitem_id`) REFERENCES `t_checkitem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_checkgroup_checkitem
-- ----------------------------
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 28);
INSERT INTO `t_checkgroup_checkitem` VALUES (16, 28);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 29);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 30);
INSERT INTO `t_checkgroup_checkitem` VALUES (16, 30);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 31);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 32);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 33);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 34);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 35);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 36);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 37);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 38);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 39);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 40);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 41);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 42);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 43);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 44);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 45);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 46);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 47);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 48);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 49);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 50);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 51);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 52);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 53);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 54);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 55);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 56);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 57);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 58);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 59);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 60);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 61);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 62);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 63);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 64);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 65);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 66);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 67);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 68);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 69);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 70);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 71);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 72);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 73);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 74);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 75);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 76);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 77);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 78);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 79);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 80);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 81);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 82);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 83);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 84);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 85);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 86);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 87);
INSERT INTO `t_checkgroup_checkitem` VALUES (14, 88);
INSERT INTO `t_checkgroup_checkitem` VALUES (14, 89);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 90);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 91);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 92);

-- ----------------------------
-- Table structure for t_checkitem
-- ----------------------------
DROP TABLE IF EXISTS `t_checkitem`;
CREATE TABLE `t_checkitem`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `type` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '查检项类型,分为检查和检验两种',
  `attention` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_checkitem
-- ----------------------------
INSERT INTO `t_checkitem` VALUES (28, '0001', '身高', '0', '0-100', 5, '1', '无', '身高');
INSERT INTO `t_checkitem` VALUES (29, '0002', '体重', '0', '0-100', 5, '1', '无', '体重');
INSERT INTO `t_checkitem` VALUES (30, '0003', '体重指数', '0', '0-100', 5, '1', '无', '体重指数');
INSERT INTO `t_checkitem` VALUES (31, '0004', '收缩压', '0', '0-100', 5, '1', '无', '收缩压');
INSERT INTO `t_checkitem` VALUES (32, '0005', '舒张压', '0', '0-100', 5, '1', '无', '舒张压');
INSERT INTO `t_checkitem` VALUES (33, '0006', '裸视力（右）', '0', '0-100', 5, '1', '无', '裸视力（右）');
INSERT INTO `t_checkitem` VALUES (34, '0007', '裸视力（左）', '0', '0-100', 5, '1', '无', '裸视力（左）');
INSERT INTO `t_checkitem` VALUES (35, '0008', '矫正视力（右）', '0', '0-100', 5, '1', '无', '矫正视力（右）');
INSERT INTO `t_checkitem` VALUES (36, '0009', '矫正视力（左）', '0', '0-100', 5, '1', '无', '矫正视力（左）');
INSERT INTO `t_checkitem` VALUES (37, '0010', '色觉', '0', '0-100', 5, '1', '无', '色觉');
INSERT INTO `t_checkitem` VALUES (38, '0011', '白细胞计数', '0', '0-100', 10, '2', '无', '白细胞计数');
INSERT INTO `t_checkitem` VALUES (39, '0012', '红细胞计数', '0', '0-100', 10, '2', NULL, '红细胞计数');
INSERT INTO `t_checkitem` VALUES (40, '0013', '血红蛋白', '0', '0-100', 10, '2', NULL, '血红蛋白');
INSERT INTO `t_checkitem` VALUES (41, '0014', '红细胞压积', '0', '0-100', 10, '2', NULL, '红细胞压积');
INSERT INTO `t_checkitem` VALUES (42, '0015', '平均红细胞体积', '0', '0-100', 10, '2', NULL, '平均红细胞体积');
INSERT INTO `t_checkitem` VALUES (43, '0016', '平均红细胞血红蛋白含量', '0', '0-100', 10, '2', NULL, '平均红细胞血红蛋白含量');
INSERT INTO `t_checkitem` VALUES (44, '0017', '平均红细胞血红蛋白浓度', '0', '0-100', 10, '2', NULL, '平均红细胞血红蛋白浓度');
INSERT INTO `t_checkitem` VALUES (45, '0018', '红细胞分布宽度-变异系数', '0', '0-100', 10, '2', NULL, '红细胞分布宽度-变异系数');
INSERT INTO `t_checkitem` VALUES (46, '0019', '血小板计数', '0', '0-100', 10, '2', NULL, '血小板计数');
INSERT INTO `t_checkitem` VALUES (47, '0020', '平均血小板体积', '0', '0-100', 10, '2', NULL, '平均血小板体积');
INSERT INTO `t_checkitem` VALUES (48, '0021', '血小板分布宽度', '0', '0-100', 10, '2', NULL, '血小板分布宽度');
INSERT INTO `t_checkitem` VALUES (49, '0022', '淋巴细胞百分比', '0', '0-100', 10, '2', NULL, '淋巴细胞百分比');
INSERT INTO `t_checkitem` VALUES (50, '0023', '中间细胞百分比', '0', '0-100', 10, '2', NULL, '中间细胞百分比');
INSERT INTO `t_checkitem` VALUES (51, '0024', '中性粒细胞百分比', '0', '0-100', 10, '2', NULL, '中性粒细胞百分比');
INSERT INTO `t_checkitem` VALUES (52, '0025', '淋巴细胞绝对值', '0', '0-100', 10, '2', NULL, '淋巴细胞绝对值');
INSERT INTO `t_checkitem` VALUES (53, '0026', '中间细胞绝对值', '0', '0-100', 10, '2', NULL, '中间细胞绝对值');
INSERT INTO `t_checkitem` VALUES (54, '0027', '中性粒细胞绝对值', '0', '0-100', 10, '2', NULL, '中性粒细胞绝对值');
INSERT INTO `t_checkitem` VALUES (55, '0028', '红细胞分布宽度-标准差', '0', '0-100', 10, '2', NULL, '红细胞分布宽度-标准差');
INSERT INTO `t_checkitem` VALUES (56, '0029', '血小板压积', '0', '0-100', 10, '2', NULL, '血小板压积');
INSERT INTO `t_checkitem` VALUES (57, '0030', '尿比重', '0', '0-100', 10, '2', NULL, '尿比重');
INSERT INTO `t_checkitem` VALUES (58, '0031', '尿酸碱度', '0', '0-100', 10, '2', NULL, '尿酸碱度');
INSERT INTO `t_checkitem` VALUES (59, '0032', '尿白细胞', '0', '0-100', 10, '2', NULL, '尿白细胞');
INSERT INTO `t_checkitem` VALUES (60, '0033', '尿亚硝酸盐', '0', '0-100', 10, '2', NULL, '尿亚硝酸盐');
INSERT INTO `t_checkitem` VALUES (61, '0034', '尿蛋白质', '0', '0-100', 10, '2', NULL, '尿蛋白质');
INSERT INTO `t_checkitem` VALUES (62, '0035', '尿糖', '0', '0-100', 10, '2', NULL, '尿糖');
INSERT INTO `t_checkitem` VALUES (63, '0036', '尿酮体', '0', '0-100', 10, '2', NULL, '尿酮体');
INSERT INTO `t_checkitem` VALUES (64, '0037', '尿胆原', '0', '0-100', 10, '2', NULL, '尿胆原');
INSERT INTO `t_checkitem` VALUES (65, '0038', '尿胆红素', '0', '0-100', 10, '2', NULL, '尿胆红素');
INSERT INTO `t_checkitem` VALUES (66, '0039', '尿隐血', '0', '0-100', 10, '2', NULL, '尿隐血');
INSERT INTO `t_checkitem` VALUES (67, '0040', '尿镜检红细胞', '0', '0-100', 10, '2', NULL, '尿镜检红细胞');
INSERT INTO `t_checkitem` VALUES (68, '0041', '尿镜检白细胞', '0', '0-100', 10, '2', NULL, '尿镜检白细胞');
INSERT INTO `t_checkitem` VALUES (69, '0042', '上皮细胞', '0', '0-100', 10, '2', NULL, '上皮细胞');
INSERT INTO `t_checkitem` VALUES (70, '0043', '无机盐类', '0', '0-100', 10, '2', NULL, '无机盐类');
INSERT INTO `t_checkitem` VALUES (71, '0044', '尿镜检蛋白定性', '0', '0-100', 10, '2', NULL, '尿镜检蛋白定性');
INSERT INTO `t_checkitem` VALUES (72, '0045', '丙氨酸氨基转移酶', '0', '0-100', 10, '2', NULL, '丙氨酸氨基转移酶');
INSERT INTO `t_checkitem` VALUES (73, '0046', '天门冬氨酸氨基转移酶', '0', '0-100', 10, '2', NULL, '天门冬氨酸氨基转移酶');
INSERT INTO `t_checkitem` VALUES (74, '0047', 'Y-谷氨酰转移酶', '0', '0-100', 10, '2', NULL, 'Y-谷氨酰转移酶');
INSERT INTO `t_checkitem` VALUES (75, '0048', '尿素', '0', '0-100', 10, '2', NULL, '尿素');
INSERT INTO `t_checkitem` VALUES (76, '0049', '肌酐', '0', '0-100', 10, '2', NULL, '肌酐');
INSERT INTO `t_checkitem` VALUES (77, '0050', '尿酸', '0', '0-100', 10, '2', NULL, '尿酸');
INSERT INTO `t_checkitem` VALUES (78, '0051', '总胆固醇', '0', '0-100', 10, '2', NULL, '总胆固醇');
INSERT INTO `t_checkitem` VALUES (79, '0052', '甘油三酯', '0', '0-100', 10, '2', NULL, '甘油三酯');
INSERT INTO `t_checkitem` VALUES (80, '0053', '高密度脂蛋白胆固醇', '0', '0-100', 10, '2', NULL, '高密度脂蛋白胆固醇');
INSERT INTO `t_checkitem` VALUES (81, '0054', '低密度脂蛋白胆固醇', '0', '0-100', 10, '2', NULL, '低密度脂蛋白胆固醇');
INSERT INTO `t_checkitem` VALUES (82, '0055', '磷酸肌酸激酶', '0', '0-100', 10, '2', NULL, '磷酸肌酸激酶');
INSERT INTO `t_checkitem` VALUES (83, '0056', '磷酸肌酸激酶同工酶', '0', '0-100', 10, '2', NULL, '磷酸肌酸激酶同工酶');
INSERT INTO `t_checkitem` VALUES (84, '0057', '乳酸脱氢酶', '0', '0-100', 10, '2', NULL, '乳酸脱氢酶');
INSERT INTO `t_checkitem` VALUES (85, '0058', '三碘甲状腺原氨酸', '0', '0-100', 10, '2', NULL, '三碘甲状腺原氨酸');
INSERT INTO `t_checkitem` VALUES (86, '0059', '甲状腺素', '0', '0-100', 10, '2', NULL, '甲状腺素');
INSERT INTO `t_checkitem` VALUES (87, '0060', '促甲状腺激素', '0', '0-100', 10, '2', NULL, '促甲状腺激素');
INSERT INTO `t_checkitem` VALUES (88, '0061', '子宫', '2', '0-100', 10, '2', NULL, '子宫');
INSERT INTO `t_checkitem` VALUES (89, '0062', '附件', '2', '0-100', 10, '2', NULL, '附件');
INSERT INTO `t_checkitem` VALUES (90, '0063', '总胆红素', '0', '0-100', 10, '2', NULL, '总胆红素');
INSERT INTO `t_checkitem` VALUES (91, '0064', '直接胆红素', '0', '0-100', 10, '2', NULL, '直接胆红素');
INSERT INTO `t_checkitem` VALUES (92, '0065', '间接胆红素', '0', '0-100', 10, '2', NULL, '间接胆红素');

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `fileNumber` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `idCard` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `regTime` date NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES (82, NULL, '小明', '1', '123456789000999999', '18511279942', '2023-03-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (83, NULL, '王美丽', '1', '132333333333333', '13412345678', '2023-03-11', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (84, NULL, 'test', NULL, NULL, '18511279942', '2023-03-13', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (85, NULL, NULL, NULL, NULL, NULL, '2023-03-06', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (86, NULL, NULL, NULL, NULL, NULL, '2023-04-04', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (87, NULL, NULL, NULL, NULL, NULL, '2023-02-06', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (88, NULL, NULL, NULL, NULL, NULL, '2023-04-10', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (89, NULL, NULL, NULL, NULL, NULL, '2022-12-01', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (90, NULL, NULL, NULL, NULL, NULL, '2022-12-02', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (91, NULL, NULL, NULL, NULL, NULL, '2022-02-01', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (92, NULL, '333', '2', '234234145432121345', '18019286521', '2023-03-19', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (93, NULL, '李梅', '2', '362203200502141023', '18479522791', '2023-04-01', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `linkUrl` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `path` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `priority` int NULL DEFAULT NULL,
  `icon` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `description` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `parentMenuId` int NULL DEFAULT NULL,
  `level` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_13`(`parentMenuId` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`parentMenuId`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '会员管理', NULL, '2', 1, 'fa-user-md', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (2, '会员档案', 'member.html', '/2-1', 1, NULL, NULL, 1, 2);
INSERT INTO `t_menu` VALUES (3, '体检上传', NULL, '/2-2', 2, NULL, NULL, 1, 2);
INSERT INTO `t_menu` VALUES (4, '会员统计', NULL, '/2-3', 3, NULL, NULL, 1, 2);
INSERT INTO `t_menu` VALUES (5, '预约管理', NULL, '3', 2, 'fa-tty', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (6, '预约列表', 'ordersettinglist.html', '/3-1', 1, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (7, '预约设置', 'ordersetting.html', '/3-2', 2, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (8, '套餐管理', 'setmeal.html', '/3-3', 3, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (9, '检查组管理', 'checkgroup.html', '/3-4', 4, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (10, '检查项管理', 'checkitem.html', '/3-5', 5, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (11, '健康评估', NULL, '4', 3, 'fa-stethoscope', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (12, '中医体质辨识', NULL, '/4-1', 1, NULL, NULL, 11, 2);
INSERT INTO `t_menu` VALUES (13, '统计分析', NULL, '5', 4, 'fa-heartbeat', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (14, '会员数量', 'report_member.html', '/5-1', 1, NULL, NULL, 13, 2);
INSERT INTO `t_menu` VALUES (15, '系统设置', NULL, '6', 5, 'fa-users', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (16, '菜单管理', 'menu.html', '/6-1', 1, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (17, '权限管理', 'permission.html', '/6-2', 2, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (18, '角色管理', 'role.html', '/6-3', 3, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (19, '用户管理', 'user.html', '/6-4', 4, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (20, '套餐占比', 'report_setmeal.html', '/5-2', 2, NULL, NULL, 13, 2);
INSERT INTO `t_menu` VALUES (21, '运营数据', 'report_business.html', '/5-3', 3, NULL, NULL, 13, 2);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NULL DEFAULT NULL COMMENT '员会id',
  `orderDate` date NULL DEFAULT NULL COMMENT '约预日期',
  `orderType` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '约预类型 电话预约/微信预约',
  `orderStatus` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '预约状态（是否到诊）',
  `setmeal_id` int NULL DEFAULT NULL COMMENT '餐套id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key_member_id`(`member_id` ASC) USING BTREE,
  INDEX `key_setmeal_id`(`setmeal_id` ASC) USING BTREE,
  CONSTRAINT `key_member_id` FOREIGN KEY (`member_id`) REFERENCES `t_member` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `key_setmeal_id` FOREIGN KEY (`setmeal_id`) REFERENCES `t_setmeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (17, 84, '2019-04-28', '微信预约', '未到诊', 12);
INSERT INTO `t_order` VALUES (22, 93, '2023-04-03', '微信预约', '未到诊', 13);

-- ----------------------------
-- Table structure for t_ordersetting
-- ----------------------------
DROP TABLE IF EXISTS `t_ordersetting`;
CREATE TABLE `t_ordersetting`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderDate` date NULL DEFAULT NULL COMMENT '约预日期',
  `number` int NULL DEFAULT NULL COMMENT '可预约人数',
  `reservations` int NULL DEFAULT NULL COMMENT '已预约人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 250 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ordersetting
-- ----------------------------
INSERT INTO `t_ordersetting` VALUES (13, '2019-03-04', 100, 100);
INSERT INTO `t_ordersetting` VALUES (14, '2019-03-05', 200, 0);
INSERT INTO `t_ordersetting` VALUES (15, '2019-03-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (16, '2019-03-07', 200, 0);
INSERT INTO `t_ordersetting` VALUES (17, '2019-03-08', 200, 1);
INSERT INTO `t_ordersetting` VALUES (18, '2019-03-09', 200, 0);
INSERT INTO `t_ordersetting` VALUES (19, '2019-03-10', 200, 0);
INSERT INTO `t_ordersetting` VALUES (20, '2019-03-11', 200, 3);
INSERT INTO `t_ordersetting` VALUES (21, '2019-03-13', 300, 1);
INSERT INTO `t_ordersetting` VALUES (22, '2019-03-14', 600, 0);
INSERT INTO `t_ordersetting` VALUES (23, '2019-03-15', 500, 1);
INSERT INTO `t_ordersetting` VALUES (24, '2019-03-16', 500, 0);
INSERT INTO `t_ordersetting` VALUES (25, '2019-03-17', 400, 0);
INSERT INTO `t_ordersetting` VALUES (26, '2019-03-19', 300, 1);
INSERT INTO `t_ordersetting` VALUES (27, '2019-04-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (28, '2019-04-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (29, '2019-04-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (30, '2019-03-20', 200, 1);
INSERT INTO `t_ordersetting` VALUES (31, '2019-05-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (32, '2019-03-28', 200, 1);
INSERT INTO `t_ordersetting` VALUES (33, '2019-04-03', 400, 0);
INSERT INTO `t_ordersetting` VALUES (34, '2019-09-30', 800, 0);
INSERT INTO `t_ordersetting` VALUES (35, '2019-04-04', 400, 0);
INSERT INTO `t_ordersetting` VALUES (36, '2019-04-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (37, '2019-04-14', 200, 1);
INSERT INTO `t_ordersetting` VALUES (38, '2019-04-13', 200, 0);
INSERT INTO `t_ordersetting` VALUES (39, '2019-04-17', 400, 0);
INSERT INTO `t_ordersetting` VALUES (40, '2019-04-18', 1, 1);
INSERT INTO `t_ordersetting` VALUES (41, '2019-04-20', 300, 1);
INSERT INTO `t_ordersetting` VALUES (42, '2019-04-21', 300, 1);
INSERT INTO `t_ordersetting` VALUES (43, '2019-04-22', 300, 1);
INSERT INTO `t_ordersetting` VALUES (44, '2019-04-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (45, '2019-04-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (46, '2019-04-25', 400, 0);
INSERT INTO `t_ordersetting` VALUES (47, '2019-04-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (48, '2019-04-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (49, '2019-04-28', 300, 2);
INSERT INTO `t_ordersetting` VALUES (50, '2019-04-29', 300, 0);
INSERT INTO `t_ordersetting` VALUES (51, '2019-04-30', 300, 0);
INSERT INTO `t_ordersetting` VALUES (52, '2019-05-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (53, '2019-05-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (54, '2019-05-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (55, '2019-05-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (56, '2019-05-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (57, '2019-05-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (58, '2019-05-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (59, '2019-05-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (60, '2019-05-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (61, '2019-05-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (69, '2020-02-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (70, '2020-02-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (71, '2020-02-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (72, '2020-02-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (73, '2020-02-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (74, '2020-02-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (75, '2020-02-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (76, '2020-02-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (77, '2020-02-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (78, '2020-02-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (79, '2020-02-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (80, '2020-02-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (81, '2020-02-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (82, '2020-02-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (83, '2020-02-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (84, '2020-02-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (85, '2020-02-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (86, '2020-02-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (87, '2020-02-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (88, '2020-02-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (89, '2020-02-22', 300, 0);
INSERT INTO `t_ordersetting` VALUES (90, '2020-02-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (91, '2020-02-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (92, '2020-02-25', 300, 0);
INSERT INTO `t_ordersetting` VALUES (93, '2020-02-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (94, '2020-02-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (95, '2020-02-28', 300, 0);
INSERT INTO `t_ordersetting` VALUES (96, '2020-02-29', 300, 0);
INSERT INTO `t_ordersetting` VALUES (97, '2020-03-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (98, '2020-03-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (99, '2020-03-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (100, '2020-03-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (101, '2020-03-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (102, '2020-03-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (103, '2020-03-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (104, '2020-03-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (105, '2020-03-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (106, '2020-03-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (107, '2020-03-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (108, '2020-03-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (109, '2020-03-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (110, '2020-03-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (111, '2020-03-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (112, '2020-03-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (113, '2020-03-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (114, '2020-03-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (115, '2020-03-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (116, '2020-03-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (117, '2020-03-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (118, '2023-01-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (119, '2023-01-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (120, '2023-01-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (121, '2023-01-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (122, '2023-01-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (123, '2023-01-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (124, '2023-01-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (125, '2023-01-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (126, '2023-01-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (127, '2023-01-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (128, '2023-01-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (129, '2023-01-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (130, '2023-01-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (131, '2023-01-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (132, '2023-01-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (133, '2023-01-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (134, '2023-01-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (135, '2023-01-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (136, '2023-01-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (137, '2023-01-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (138, '2023-01-22', 300, 0);
INSERT INTO `t_ordersetting` VALUES (139, '2023-01-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (140, '2023-01-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (141, '2023-01-25', 300, 0);
INSERT INTO `t_ordersetting` VALUES (142, '2023-01-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (143, '2023-01-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (144, '2023-01-28', 300, 0);
INSERT INTO `t_ordersetting` VALUES (145, '2023-01-29', 300, 0);
INSERT INTO `t_ordersetting` VALUES (146, '2023-01-30', 300, 0);
INSERT INTO `t_ordersetting` VALUES (147, '2023-01-31', 300, 0);
INSERT INTO `t_ordersetting` VALUES (148, '2023-02-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (149, '2023-02-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (150, '2023-02-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (151, '2023-02-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (152, '2023-02-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (153, '2023-02-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (154, '2023-02-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (155, '2023-02-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (156, '2023-02-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (157, '2023-02-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (158, '2023-02-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (159, '2023-02-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (160, '2023-02-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (161, '2023-02-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (162, '2023-02-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (163, '2023-02-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (164, '2023-02-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (165, '2023-02-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (166, '2023-02-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (167, '2023-02-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (168, '2023-02-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (169, '2023-02-22', 300, 0);
INSERT INTO `t_ordersetting` VALUES (170, '2023-02-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (171, '2023-02-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (172, '2023-02-25', 300, 0);
INSERT INTO `t_ordersetting` VALUES (173, '2023-02-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (174, '2023-02-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (175, '2023-02-28', 300, 0);
INSERT INTO `t_ordersetting` VALUES (176, '2023-03-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (177, '2023-03-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (178, '2023-03-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (179, '2023-03-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (180, '2023-03-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (181, '2023-03-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (182, '2023-03-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (183, '2023-03-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (184, '2023-03-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (185, '2023-03-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (186, '2023-03-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (187, '2023-03-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (188, '2023-03-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (189, '2023-03-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (190, '2023-03-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (191, '2023-03-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (192, '2023-03-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (193, '2023-03-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (194, '2023-03-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (195, '2023-03-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (196, '2023-03-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (197, '2023-03-22', 300, 0);
INSERT INTO `t_ordersetting` VALUES (198, '2023-03-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (199, '2023-03-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (200, '2023-03-25', 300, 0);
INSERT INTO `t_ordersetting` VALUES (201, '2023-03-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (202, '2023-03-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (203, '2023-03-28', 300, 0);
INSERT INTO `t_ordersetting` VALUES (204, '2023-03-29', 300, 0);
INSERT INTO `t_ordersetting` VALUES (205, '2023-03-30', 300, 0);
INSERT INTO `t_ordersetting` VALUES (206, '2023-03-31', 400, 0);
INSERT INTO `t_ordersetting` VALUES (207, '2023-04-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (208, '2023-04-02', 300, 1);
INSERT INTO `t_ordersetting` VALUES (209, '2023-04-03', 300, 2);
INSERT INTO `t_ordersetting` VALUES (210, '2023-04-04', 300, 1);
INSERT INTO `t_ordersetting` VALUES (211, '2023-04-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (212, '2023-04-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (213, '2023-04-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (214, '2023-04-08', 300, 1);
INSERT INTO `t_ordersetting` VALUES (215, '2023-04-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (216, '2023-04-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (217, '2023-04-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (218, '2023-04-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (219, '2023-04-13', 300, 0);
INSERT INTO `t_ordersetting` VALUES (220, '2023-04-14', 300, 0);
INSERT INTO `t_ordersetting` VALUES (221, '2023-04-15', 300, 0);
INSERT INTO `t_ordersetting` VALUES (222, '2023-04-16', 300, 0);
INSERT INTO `t_ordersetting` VALUES (223, '2023-04-17', 300, 0);
INSERT INTO `t_ordersetting` VALUES (224, '2023-04-18', 300, 0);
INSERT INTO `t_ordersetting` VALUES (225, '2023-04-19', 300, 0);
INSERT INTO `t_ordersetting` VALUES (226, '2023-04-20', 300, 0);
INSERT INTO `t_ordersetting` VALUES (227, '2023-04-21', 300, 0);
INSERT INTO `t_ordersetting` VALUES (228, '2023-04-22', 300, 0);
INSERT INTO `t_ordersetting` VALUES (229, '2023-04-23', 300, 0);
INSERT INTO `t_ordersetting` VALUES (230, '2023-04-24', 300, 0);
INSERT INTO `t_ordersetting` VALUES (231, '2023-04-25', 300, 0);
INSERT INTO `t_ordersetting` VALUES (232, '2023-04-26', 300, 0);
INSERT INTO `t_ordersetting` VALUES (233, '2023-04-27', 300, 0);
INSERT INTO `t_ordersetting` VALUES (234, '2023-04-28', 300, 0);
INSERT INTO `t_ordersetting` VALUES (235, '2023-04-29', 300, 0);
INSERT INTO `t_ordersetting` VALUES (236, '2023-04-30', 300, 0);
INSERT INTO `t_ordersetting` VALUES (237, '2023-05-01', 300, 0);
INSERT INTO `t_ordersetting` VALUES (238, '2023-05-02', 300, 0);
INSERT INTO `t_ordersetting` VALUES (239, '2023-05-03', 300, 0);
INSERT INTO `t_ordersetting` VALUES (240, '2023-05-04', 300, 0);
INSERT INTO `t_ordersetting` VALUES (241, '2023-05-05', 300, 0);
INSERT INTO `t_ordersetting` VALUES (242, '2023-05-06', 300, 0);
INSERT INTO `t_ordersetting` VALUES (243, '2023-05-07', 300, 0);
INSERT INTO `t_ordersetting` VALUES (244, '2023-05-08', 300, 0);
INSERT INTO `t_ordersetting` VALUES (245, '2023-05-09', 300, 0);
INSERT INTO `t_ordersetting` VALUES (246, '2023-05-10', 300, 0);
INSERT INTO `t_ordersetting` VALUES (247, '2023-05-11', 300, 0);
INSERT INTO `t_ordersetting` VALUES (248, '2023-05-12', 300, 0);
INSERT INTO `t_ordersetting` VALUES (249, '2023-05-13', 300, 0);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `keyword` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `description` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '新增检查项', 'CHECKITEM_ADD', NULL);
INSERT INTO `t_permission` VALUES (2, '删除检查项', 'CHECKITEM_DELETE', NULL);
INSERT INTO `t_permission` VALUES (3, '编辑检查项', 'CHECKITEM_EDIT', NULL);
INSERT INTO `t_permission` VALUES (4, '查询检查项', 'CHECKITEM_QUERY', NULL);
INSERT INTO `t_permission` VALUES (5, '新增检查组', 'CHECKGROUP_ADD', NULL);
INSERT INTO `t_permission` VALUES (6, '删除检查组', 'CHECKGROUP_DELETE', NULL);
INSERT INTO `t_permission` VALUES (7, '编辑检查组', 'CHECKGROUP_EDIT', NULL);
INSERT INTO `t_permission` VALUES (8, '查询检查组', 'CHECKGROUP_QUERY', NULL);
INSERT INTO `t_permission` VALUES (9, '新增套餐', 'SETMEAL_ADD', NULL);
INSERT INTO `t_permission` VALUES (10, '删除套餐', 'SETMEAL_DELETE', NULL);
INSERT INTO `t_permission` VALUES (11, '编辑套餐', 'SETMEAL_EDIT', NULL);
INSERT INTO `t_permission` VALUES (12, '查询套餐', 'SETMEAL_QUERY', NULL);
INSERT INTO `t_permission` VALUES (13, '预约设置', 'ORDERSETTING', NULL);
INSERT INTO `t_permission` VALUES (14, '查看统计报表', 'REPORT_VIEW', NULL);
INSERT INTO `t_permission` VALUES (15, '新增菜单', 'MENU_ADD', NULL);
INSERT INTO `t_permission` VALUES (16, '删除菜单', 'MENU_DELETE', NULL);
INSERT INTO `t_permission` VALUES (17, '编辑菜单', 'MENU_EDIT', NULL);
INSERT INTO `t_permission` VALUES (18, '查询菜单', 'MENU_QUERY', NULL);
INSERT INTO `t_permission` VALUES (19, '新增角色', 'ROLE_ADD', NULL);
INSERT INTO `t_permission` VALUES (20, '删除角色', 'ROLE_DELETE', NULL);
INSERT INTO `t_permission` VALUES (21, '编辑角色', 'ROLE_EDIT', NULL);
INSERT INTO `t_permission` VALUES (22, '查询角色', 'ROLE_QUERY', NULL);
INSERT INTO `t_permission` VALUES (23, '新增用户', 'USER_ADD', NULL);
INSERT INTO `t_permission` VALUES (24, '删除用户', 'USER_DELETE', NULL);
INSERT INTO `t_permission` VALUES (25, '编辑用户', 'USER_EDIT', NULL);
INSERT INTO `t_permission` VALUES (26, '查询用户', 'USER_QUERY', NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `keyword` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `description` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '系统管理员', 'ROLE_ADMIN', NULL);
INSERT INTO `t_role` VALUES (2, '健康管理师', 'ROLE_HEALTH_MANAGER', NULL);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `role_id` int NOT NULL,
  `menu_id` int NOT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE,
  INDEX `FK_Reference_10`(`menu_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (2, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (2, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (2, 3);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (2, 4);
INSERT INTO `t_role_menu` VALUES (1, 5);
INSERT INTO `t_role_menu` VALUES (1, 6);
INSERT INTO `t_role_menu` VALUES (1, 7);
INSERT INTO `t_role_menu` VALUES (1, 8);
INSERT INTO `t_role_menu` VALUES (1, 9);
INSERT INTO `t_role_menu` VALUES (1, 10);
INSERT INTO `t_role_menu` VALUES (1, 11);
INSERT INTO `t_role_menu` VALUES (1, 12);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 16);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (1, 21);

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `FK_Reference_12`(`permission_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1, 1);
INSERT INTO `t_role_permission` VALUES (2, 1);
INSERT INTO `t_role_permission` VALUES (1, 2);
INSERT INTO `t_role_permission` VALUES (1, 3);
INSERT INTO `t_role_permission` VALUES (2, 3);
INSERT INTO `t_role_permission` VALUES (1, 4);
INSERT INTO `t_role_permission` VALUES (2, 4);
INSERT INTO `t_role_permission` VALUES (1, 5);
INSERT INTO `t_role_permission` VALUES (2, 5);
INSERT INTO `t_role_permission` VALUES (1, 6);
INSERT INTO `t_role_permission` VALUES (2, 6);
INSERT INTO `t_role_permission` VALUES (1, 7);
INSERT INTO `t_role_permission` VALUES (2, 7);
INSERT INTO `t_role_permission` VALUES (1, 8);
INSERT INTO `t_role_permission` VALUES (2, 8);
INSERT INTO `t_role_permission` VALUES (1, 9);
INSERT INTO `t_role_permission` VALUES (2, 9);
INSERT INTO `t_role_permission` VALUES (1, 10);
INSERT INTO `t_role_permission` VALUES (2, 10);
INSERT INTO `t_role_permission` VALUES (1, 11);
INSERT INTO `t_role_permission` VALUES (2, 11);
INSERT INTO `t_role_permission` VALUES (1, 12);
INSERT INTO `t_role_permission` VALUES (2, 12);
INSERT INTO `t_role_permission` VALUES (1, 13);
INSERT INTO `t_role_permission` VALUES (2, 13);
INSERT INTO `t_role_permission` VALUES (1, 14);
INSERT INTO `t_role_permission` VALUES (2, 14);
INSERT INTO `t_role_permission` VALUES (1, 15);
INSERT INTO `t_role_permission` VALUES (1, 16);
INSERT INTO `t_role_permission` VALUES (1, 17);
INSERT INTO `t_role_permission` VALUES (1, 18);
INSERT INTO `t_role_permission` VALUES (1, 19);
INSERT INTO `t_role_permission` VALUES (1, 20);
INSERT INTO `t_role_permission` VALUES (1, 21);
INSERT INTO `t_role_permission` VALUES (1, 22);
INSERT INTO `t_role_permission` VALUES (1, 23);
INSERT INTO `t_role_permission` VALUES (1, 24);
INSERT INTO `t_role_permission` VALUES (1, 25);
INSERT INTO `t_role_permission` VALUES (1, 26);

-- ----------------------------
-- Table structure for t_setmeal
-- ----------------------------
DROP TABLE IF EXISTS `t_setmeal`;
CREATE TABLE `t_setmeal`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `code` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `helpCode` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `attention` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `img` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_setmeal
-- ----------------------------
INSERT INTO `t_setmeal` VALUES (12, '入职无忧体检套餐（男女通用）', '0001', 'RZTJ', '0', '18-60', 300, '入职体检套餐', NULL, 'b5a2f4a3-a8e4-4afa-8ca0-5ecd2042815d1.jpg');
INSERT INTO `t_setmeal` VALUES (13, '粉红珍爱(女)升级TM12项筛查体检套餐', '0002', 'FHZA', '2', '18-60', 1200, '本套餐针对宫颈(TCT检查、HPV乳头瘤病毒筛查）、乳腺（彩超，癌抗125），甲状腺（彩超，甲功验血）以及胸片，血常规肝功等有全面检查，非常适合女性全面疾病筛查使用。', NULL, '1c041c4f-e8f4-4125-bae1-38229f834b082.jpg');
INSERT INTO `t_setmeal` VALUES (14, '阳光爸妈升级肿瘤12项筛查（男女单人）体检套餐', '0003', 'YGBM', '0', '55-100', 1400, '本套餐主要针对常见肿瘤筛查，肝肾、颈动脉、脑血栓、颅内血流筛查，以及风湿、颈椎、骨密度检查', NULL, 'afdaef57-6789-47b3-b85d-12853965e6102.jpg');
INSERT INTO `t_setmeal` VALUES (15, '珍爱高端升级肿瘤12项筛查（男女单人）', '0004', 'ZAGD', '0', '14-20', 2400, '本套餐是一款针对生化五项检查，心，肝，胆，胃，甲状腺，颈椎，肺功能，脑部检查（经颅多普勒）以及癌症筛查，适合大众人群体检的套餐', NULL, 'b5a2f4a3-a8e4-4afa-8ca0-5ecd2042815d1.jpg');
INSERT INTO `t_setmeal` VALUES (16, '入学体检', '0005', 'RXTJ', '0', '15~25', 100, '入学体检', '无', 'b5a2f4a3-a8e4-4afa-8ca0-5ecd2042815d1.jpg');
INSERT INTO `t_setmeal` VALUES (17, '开学体检', '0006', 'KXTJ', '0', '19~25', 150, '体检前一小时空腹', '体检前一小时空腹', '1c041c4f-e8f4-4125-bae1-38229f834b082.jpg');
INSERT INTO `t_setmeal` VALUES (18, '入学体检2', '0007', 'RXTJ2', '2', '12', 120, '无', '无', 'afdaef57-6789-47b3-b85d-12853965e6102.jpg');
INSERT INTO `t_setmeal` VALUES (20, '公务员体检', '0008', 'GWUTJ', '0', '20~35', 200, '无', '无', '1caaa82e-9a39-4552-a67b-77255426c6162.jpg');

-- ----------------------------
-- Table structure for t_setmeal_checkgroup
-- ----------------------------
DROP TABLE IF EXISTS `t_setmeal_checkgroup`;
CREATE TABLE `t_setmeal_checkgroup`  (
  `setmeal_id` int NOT NULL DEFAULT 0,
  `checkgroup_id` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`setmeal_id`, `checkgroup_id`) USING BTREE,
  INDEX `checkgroup_key`(`checkgroup_id` ASC) USING BTREE,
  CONSTRAINT `checkgroup_key` FOREIGN KEY (`checkgroup_id`) REFERENCES `t_checkgroup` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `setmeal_key` FOREIGN KEY (`setmeal_id`) REFERENCES `t_setmeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_setmeal_checkgroup
-- ----------------------------
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (16, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (17, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (18, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (20, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (16, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (17, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (18, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (16, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (17, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (20, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (16, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (17, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 9);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (14, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (15, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (12, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (14, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (15, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (14, 12);
INSERT INTO `t_setmeal_checkgroup` VALUES (20, 12);
INSERT INTO `t_setmeal_checkgroup` VALUES (14, 13);
INSERT INTO `t_setmeal_checkgroup` VALUES (15, 13);
INSERT INTO `t_setmeal_checkgroup` VALUES (13, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (15, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (20, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (13, 15);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `birthday` date NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `remark` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `station` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, NULL, NULL, 'admin', '$2a$10$4FUSBdPU4qK63r2B9U9tqez7CpRTw5r1N6LgDywioPx/RNfNr01fi', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (2, NULL, NULL, 'xiaoming', '$2a$10$3xW2nBjwBM3rx1LoYprVsemNri5bvxeOd/QfmO7UDFQhW2HRHLi.C', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (3, NULL, NULL, 'test', '$2a$10$zYJRscVUgHX1wqwu90WereuTmIg6h/JGirGG4SWBsZ60wVPCgtF8W', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FK_Reference_8`(`role_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
