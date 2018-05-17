# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.21)
# Database: demo
# Generation Time: 2018-05-17 02:17:39 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table company
# ------------------------------------------------------------

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `HR` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;

INSERT INTO `company` (`id`, `name`, `introduce`, `address`, `HR`, `email`, `password`, `number`)
VALUES
  (1,'网易','网易 (NASDAQ_58_ NTES)是中国领先的互联网技术公司，在开发互联网应用、服务及其它技术方面，始终保持国内业界的领先地位。网易对中国互联网的发展具有强烈的使命感，网易利用最先进的互联网技术','广州市天河区科韵路16号','李女士','careers@wangyi.cn','123456','15100000000'),
  (2,'百度','百度是一家持续创新的,以\"用科技让复杂世界更简单\"为使命的高科技公司','北京市海淀区上地十街','李先生','campusmaster@baidu.cn','123456','15100000001'),
  (3,'腾讯','深圳市腾讯计算机系统有限公司成立于1998年11月，是中国最大的互联网综合服务提供商之一，也是中国服务用户最多的互联网企业之一。','中国深圳','王经理','careers@tengxun.cn','123456','15100000002'),
  (4,'京东','京东于2004年正式涉足电商领域。2016年，京东集团市场交易额达到9392亿元*。京东是中国收入规模最大的互联网企业。2017年7月，京东再次入榜《财富》全球500强，位列第261位，成为排名最高的','北京市北京经济技术开发区科创十一街','张先生','zhaopin@jd.com','123456','15100000003'),
  (5,'新浪','新浪是全球最具影响力与公信力的中文门户网站，是中国大陆及全球华人社群中最受推崇的互联网品牌，以服务大中华地区与海外华人为己任。新浪日均浏览量超过20亿，月度覆盖网民超过4亿。','北京市北四环西路','梁先生','careers@xinlang.cn','123456','15100000004'),
  (6,'360','\r\n360公司作为中国领先的互联网络安全企业，汇聚了国内规模领先的高水平安全技术团队，积累了接近万件原创技术和核心技术的专利，并在此基础上开发出拥有数亿用户的360安全卫士、360手机卫士等安全产品','北京市','周先生','careers@360.cn','123456','15100000005'),
  (7,'华为','我们一直专注于ICT领域，为运营商、企业客户和消费者提供有竞争力的ICT解决方案、产品和服务。\r\n30年来我们不断积攒实力，如今已拥有来自全球170多个国家和地区的客户，全球三分之一的人口因华为受益。','广东省深圳市龙岗区坂田街道办华为基地','张先生','careers@huawei.cn','123456','15100000006'),
  (8,'爱奇艺','爱奇艺，中国高品质视频娱乐服务提供者。2010年4月22日正式上线，秉承“悦享品质”的品牌口号，积极推动产品、技术、内容、营销等全方位创新，为用户提供丰富、高清、流畅的专业视频体验，致力于让人们平等、','北京市','齐女士','careers@aiqiyi.cn','123456','15100000007'),
  (9,'阿里巴巴','我们旨在赋能企业改变营销、销售和经营的方式。我们为商家、品牌及其他企业提供基本的互联网基础设施以及营销平台，让其可借助互联网的力量与用户和客户互动。我们的业务包括核心电商、云计算、数字媒体和娱乐以及创','浙江省杭州市滨江区网商路','程先生','careers@alibaba.cn','123456','15100000008'),
  (10,'苏宁','1990年，苏宁开始创业之路，历经空调专营、综合电器连锁、互联网零售三个阶段，目前在中国和日本拥有两家上市公司，员工18万人，位列中国民营企业前三强。','南京市玄武区徐庄软件园','苏先生','careers@suning.cn','123456','15100000009'),
  (11,'美的集团','美的集团创业于1968年，是一家以家电制造业为主的大型综合性企业集团，旗下拥有美的电器（SZ000527）、小天鹅（SZ000418）、威灵控股（HK00382）等三家上市公司。','广东省佛山市顺德区美的总部大楼','华先生','careers@meide.cn','123456','15100000011');

/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table job
# ------------------------------------------------------------

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `responsibility` varchar(1000) DEFAULT NULL,
  `require` varchar(1000) DEFAULT NULL,
  `money` varchar(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `company_id` varchar(20) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;

INSERT INTO `job` (`id`, `name`, `responsibility`, `require`, `money`, `education`, `company_id`)
VALUES
  (1,'销售经理','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (2,'行政经理','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (3,'人事专员','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (4,'IT工程师','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (5,'大数据工程师','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (6,'Java工程师','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (7,'市场经理','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (8,'销售总监','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (9,'项目经理','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1'),
  (10,'产品经理','1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回','1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；','3k—4k','不限','1');

/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table major
# ------------------------------------------------------------

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

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;

INSERT INTO `major` (`id`, `name`, `introduce`, `academy`, `teacher`, `number`)
VALUES
  (1,NULL,NULL,NULL,NULL,NULL),
  (2,NULL,NULL,NULL,NULL,NULL),
  (3,NULL,NULL,NULL,NULL,NULL),
  (4,NULL,NULL,NULL,NULL,NULL),
  (5,NULL,NULL,NULL,NULL,NULL),
  (6,NULL,NULL,NULL,NULL,NULL),
  (7,NULL,NULL,NULL,NULL,NULL),
  (8,NULL,NULL,NULL,NULL,NULL),
  (9,NULL,NULL,NULL,NULL,NULL),
  (10,NULL,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table school
# ------------------------------------------------------------

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `introduce` varchar(20) DEFAULT NULL,
  `quantity` varchar(20) DEFAULT NULL,
  `adress` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) DEFAULT NULL,
  `number` int(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;

INSERT INTO `school` (`id`, `introduce`, `quantity`, `adress`, `teacher`, `number`, `name`)
VALUES
  (1,'北京大学',NULL,NULL,NULL,NULL,'北京大学'),
  (2,'清华大学',NULL,NULL,NULL,NULL,'清华大学');

/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student
# ------------------------------------------------------------

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

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;

INSERT INTO `student` (`id`, `name`, `sex`, `ago`, `number`, `email`, `andress`, `major_id`, `school_id`, `enjlish`, `experience`, `password`)
VALUES
  (1,'刘','男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456'),
  (2,'李','男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456'),
  (3,'王','男',NULL,'123',NULL,NULL,NULL,NULL,NULL,NULL,'123456'),
  (19,'李智','男','23','15101578395','','',NULL,'2',NULL,'','123456');

/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table studentjob
# ------------------------------------------------------------

DROP TABLE IF EXISTS `studentjob`;

CREATE TABLE `studentjob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `studentjob` WRITE;
/*!40000 ALTER TABLE `studentjob` DISABLE KEYS */;

INSERT INTO `studentjob` (`id`, `student_id`, `job_id`)
VALUES
  (1,19,1),
  (2,19,2),
  (3,19,3);

/*!40000 ALTER TABLE `studentjob` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
