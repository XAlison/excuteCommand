/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : rc_dev1_developer

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2019-01-11 18:29:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` varchar(36) NOT NULL COMMENT '应用id',
  `creator` varchar(36) DEFAULT NULL COMMENT '创建者',
  `applicationName` varchar(255) DEFAULT NULL COMMENT '应用名称',
  `applicationDescription` varchar(255) DEFAULT NULL COMMENT '应用描述',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo地址',
  `prodDomain` varchar(255) DEFAULT NULL COMMENT '生产域名',
  `testDomain` varchar(255) DEFAULT NULL COMMENT '测试域名',
  `status` int(2) DEFAULT NULL COMMENT '有效状态(1-有效，0-失效)',
  `applicationStatus` int(2) DEFAULT NULL COMMENT '应用发布状态(1-已发布,2-发布中,3-创建中)',
  `keepRecord` varchar(255) DEFAULT NULL COMMENT '备案信息',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `releaseTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `version` varchar(255) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('059e583b-101c-4426-a389-abcd279c0a54', '222ef3b8-9525-4f97-aa6e-081efb66df42', '北京华奥设计平台', '北京华奥设计平台', '', 'www.taobao.com', 'www.baidu.com', '1', '3', '京公网安备 11010102002019号', '2019-01-11 10:41:55', '2019-01-11 10:41:55', '1.0.1');
INSERT INTO `application` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2019-01-15 15:40:55', '2019-02-05 15:40:57', '1');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(36) NOT NULL COMMENT '会员ID',
  `phone` varchar(20) DEFAULT NULL COMMENT '会员手机号',
  `memberName` varchar(50) DEFAULT NULL COMMENT '会员名称',
  `companyName` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `registerTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('222ef3b8-9525-4f97-aa6e-081efb66df42', '15087429695', '李四', '北京华奥汽车服务有限公司', '9999999', '1', '2019-01-09 14:36:05');
INSERT INTO `member` VALUES ('222ef3b8-9525-4f97-aa6e-081efb66df43', '15087429694', '张三', '苏宁有限公司', '9999999', '1', '2019-01-10 14:38:57');

-- ----------------------------
-- Table structure for member_token
-- ----------------------------
DROP TABLE IF EXISTS `member_token`;
CREATE TABLE `member_token` (
  `memberId` varchar(36) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expireTime` datetime DEFAULT NULL COMMENT '过期时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`memberId`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of member_token
-- ----------------------------
INSERT INTO `member_token` VALUES ('222ef3b8-9525-4f97-aa6e-081efb66df42', 'b45acf44e9e6b4215440209ceb1d3d27', '2019-02-09 02:18:29', '2018-11-23 14:18:29');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` varchar(36) DEFAULT NULL COMMENT '团队id',
  `teamName` varchar(255) DEFAULT NULL COMMENT '团队名称',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '状态(1-生效,0-失效)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('4e67268d-acdc-40c8-b2e0-fa8f0d75e8f3', '苏宁有限公司', '222ef3b8-9525-4f97-aa6e-081efb66df43', '2019-01-10 15:08:16', '2019-01-10 15:08:16', '1');

-- ----------------------------
-- Table structure for team_member
-- ----------------------------
DROP TABLE IF EXISTS `team_member`;
CREATE TABLE `team_member` (
  `id` varchar(36) NOT NULL COMMENT '团队id',
  `teamName` varchar(255) DEFAULT NULL COMMENT '团队名称',
  `memberId` varchar(36) DEFAULT NULL COMMENT '成员id',
  `status` int(2) DEFAULT NULL COMMENT '状态(0-删除,1有效)',
  `joinTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '加入时间',
  `teamId` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`memberId`),
  CONSTRAINT `team_member_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team_member
-- ----------------------------
INSERT INTO `team_member` VALUES ('2e63ba75-7e55-408d-8e41-7d4ccb1d7351', '苏宁有限公司', '222ef3b8-9525-4f97-aa6e-081efb66df43', '1', '2019-01-10 15:10:17', '4e67268d-acdc-40c8-b2e0-fa8f0d75e8f3');
INSERT INTO `team_member` VALUES ('2e63ba75-7e55-408d-8e41-7d4ccb1d7352', '苏宁有限公司', '222ef3b8-9525-4f97-aa6e-081efb66df42', '1', '2019-01-10 15:10:19', '4e67268d-acdc-40c8-b2e0-fa8f0d75e8f3');

-- ----------------------------
-- Table structure for team_member_authority
-- ----------------------------
DROP TABLE IF EXISTS `team_member_authority`;
CREATE TABLE `team_member_authority` (
  `id` varchar(36) NOT NULL COMMENT '权限id',
  `applicationId` varchar(36) DEFAULT NULL COMMENT '应用id',
  `memberId` varchar(36) DEFAULT NULL COMMENT '开发者id',
  `teamId` varchar(36) DEFAULT NULL COMMENT '归属团队id',
  `isViewDetails` bit(1) DEFAULT NULL COMMENT '是否查看详情',
  `isRelease` bit(1) DEFAULT NULL COMMENT '是否发布',
  `isDevelop` bit(1) DEFAULT NULL COMMENT '是否开发',
  `status` int(2) DEFAULT NULL COMMENT '状态(0-失效,1-生效)',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team_member_authority
-- ----------------------------
INSERT INTO `team_member_authority` VALUES ('1', '1', '1', '1', '', '', '', '1', '2019-01-23 15:41:26', null);

-- ----------------------------
-- Table structure for team_member_invite
-- ----------------------------
DROP TABLE IF EXISTS `team_member_invite`;
CREATE TABLE `team_member_invite` (
  `id` varchar(36) DEFAULT NULL COMMENT '邀请id',
  `memberId` varchar(36) DEFAULT NULL COMMENT '会员id',
  `teamId` varchar(36) DEFAULT NULL COMMENT '团队id',
  `inviteCode` varchar(50) DEFAULT NULL COMMENT '邀请码',
  `status` int(2) DEFAULT NULL COMMENT '状态(0-失效,1-生效)',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `invalidTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '失效时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of team_member_invite
-- ----------------------------
INSERT INTO `team_member_invite` VALUES ('1', '222ef3b8-9525-4f97-aa6e-081efb66df43', '1', '112', '0', '2019-01-10 13:47:56', '2019-01-10 13:47:56');
INSERT INTO `team_member_invite` VALUES ('2', '222ef3b8-9525-4f97-aa6e-081efb66df43', '1', '112', '0', '2019-01-10 13:47:56', '2019-01-10 13:47:56');
INSERT INTO `team_member_invite` VALUES ('57816d9b-2661-430f-9262-e9b97cce4892', '222ef3b8-9525-4f97-aa6e-081efb66df43', '1', '78956', '1', '2019-01-10 13:30:16', '2019-01-11 13:30:16');
