/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 26/04/2018 00:48:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `HR` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of company
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES (1, '网易', '网易 (NASDAQ_58_ NTES)是中国领先的互联网技术公司，在开发互联网应用、服务及其它技术方面，始终保持国内业界的领先地位。网易对中国互联网的发展具有强烈的使命感，网易利用最先进的互联网技术', '广州市天河区科韵路16号', '李女士', 'careers@wangyi.cn');
INSERT INTO `company` VALUES (2, '百度', '百度是一家持续创新的,以\"用科技让复杂世界更简单\"为使命的高科技公司', '北京市海淀区上地十街', '李先生', 'campusmaster@baidu.cn');
INSERT INTO `company` VALUES (3, '腾讯', '深圳市腾讯计算机系统有限公司成立于1998年11月，是中国最大的互联网综合服务提供商之一，也是中国服务用户最多的互联网企业之一。', '中国深圳', '王经理', 'careers@tengxun.cn');
INSERT INTO `company` VALUES (4, '京东', '京东于2004年正式涉足电商领域。2016年，京东集团市场交易额达到9392亿元*。京东是中国收入规模最大的互联网企业。2017年7月，京东再次入榜《财富》全球500强，位列第261位，成为排名最高的', '北京市北京经济技术开发区科创十一街', '张先生', 'zhaopin@jd.com');
INSERT INTO `company` VALUES (5, '新浪', '新浪是全球最具影响力与公信力的中文门户网站，是中国大陆及全球华人社群中最受推崇的互联网品牌，以服务大中华地区与海外华人为己任。新浪日均浏览量超过20亿，月度覆盖网民超过4亿。', '北京市北四环西路', '梁先生', 'careers@xinlang.cn');
INSERT INTO `company` VALUES (6, '360', '\r\n360公司作为中国领先的互联网络安全企业，汇聚了国内规模领先的高水平安全技术团队，积累了接近万件原创技术和核心技术的专利，并在此基础上开发出拥有数亿用户的360安全卫士、360手机卫士等安全产品', '北京市', '周先生', 'careers@360.cn');
INSERT INTO `company` VALUES (7, '华为', '我们一直专注于ICT领域，为运营商、企业客户和消费者提供有竞争力的ICT解决方案、产品和服务。\r\n30年来我们不断积攒实力，如今已拥有来自全球170多个国家和地区的客户，全球三分之一的人口因华为受益。', '广东省深圳市龙岗区坂田街道办华为基地', '张先生', 'careers@huawei.cn');
INSERT INTO `company` VALUES (8, '爱奇艺', '爱奇艺，中国高品质视频娱乐服务提供者。2010年4月22日正式上线，秉承“悦享品质”的品牌口号，积极推动产品、技术、内容、营销等全方位创新，为用户提供丰富、高清、流畅的专业视频体验，致力于让人们平等、', '北京市', '齐女士', 'careers@aiqiyi.cn');
INSERT INTO `company` VALUES (9, '阿里巴巴', '我们旨在赋能企业改变营销、销售和经营的方式。我们为商家、品牌及其他企业提供基本的互联网基础设施以及营销平台，让其可借助互联网的力量与用户和客户互动。我们的业务包括核心电商、云计算、数字媒体和娱乐以及创', '浙江省杭州市滨江区网商路', '程先生', 'careers@alibaba.cn');
INSERT INTO `company` VALUES (10, '苏宁', '1990年，苏宁开始创业之路，历经空调专营、综合电器连锁、互联网零售三个阶段，目前在中国和日本拥有两家上市公司，员工18万人，位列中国民营企业前三强。', '南京市玄武区徐庄软件园', '苏先生', 'careers@suning.cn');
INSERT INTO `company` VALUES (11, '美的集团', '美的集团创业于1968年，是一家以家电制造业为主的大型综合性企业集团，旗下拥有美的电器（SZ000527）、小天鹅（SZ000418）、威灵控股（HK00382）等三家上市公司。', '广东省佛山市顺德区美的总部大楼', '华先生', 'careers@meide.cn');
COMMIT;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `responsibility` varchar(50) DEFAULT NULL,
  `require` varchar(50) DEFAULT NULL,
  `number` int(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
BEGIN;
INSERT INTO `job` VALUES (1, '销售经理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (2, '行政经理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (3, '人事专员', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (4, 'IT工程师', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (5, '大数据工程师', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (6, 'Java工程师', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (7, '市场经理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (8, '销售总监', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (9, '项目经理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job` VALUES (10, '产品经理', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `introduce` varchar(20) DEFAULT NULL,
  `academy` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) DEFAULT NULL,
  `number` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES (1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (9, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (10, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `introduce` varchar(20) DEFAULT NULL,
  `quantity` varchar(20) DEFAULT NULL,
  `adress` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) DEFAULT NULL,
  `number` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT '男',
  `ago` varchar(20) DEFAULT NULL,
  `number` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `andress` varchar(20) DEFAULT NULL,
  `major_id` varchar(20) DEFAULT NULL,
  `school_id` varchar(20) DEFAULT NULL,
  `enjlish` varchar(20) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '刘', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (2, '李', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (3, '王', '男', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
