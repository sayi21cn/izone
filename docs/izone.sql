/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.44 : Database - izone
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`izone` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `i_activecode` */

DROP TABLE IF EXISTS `i_activecode`;

CREATE TABLE `i_activecode` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL COMMENT '激活码',
  `email` varchar(100) NOT NULL COMMENT '发送给哪个邮箱',
  `status` tinyint(4) NOT NULL DEFAULT '2' COMMENT '0：未使用，1：已使用',
  `dateline` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `i_activecode` */

/*Table structure for table `i_attach` */

DROP TABLE IF EXISTS `i_attach`;

CREATE TABLE `i_attach` (
  `attach_id` varchar(16) NOT NULL COMMENT '附件主键',
  `uid` varchar(16) NOT NULL COMMENT '附件产生人',
  `attach_type` varchar(10) NOT NULL COMMENT '附件类型：image',
  `attach_name` varchar(50) NOT NULL COMMENT '附件名称',
  `save_path` varchar(255) NOT NULL COMMENT '文件保存路径',
  `suffix` varchar(10) DEFAULT NULL COMMENT '附件后缀',
  `dateline` int(11) NOT NULL COMMENT '产生时间',
  PRIMARY KEY (`attach_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='附件表';

/*Data for the table `i_attach` */

/*Table structure for table `i_comment` */

DROP TABLE IF EXISTS `i_comment`;

CREATE TABLE `i_comment` (
  `comment_id` varchar(16) NOT NULL,
  `post_id` varchar(16) NOT NULL,
  `create_tim` int(11) NOT NULL,
  `content` text,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_comment` */

/*Table structure for table `i_home` */

DROP TABLE IF EXISTS `i_home`;

CREATE TABLE `i_home` (
  `home_id` varchar(50) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '主页标题',
  `description` varchar(255) DEFAULT NULL COMMENT '主页描述',
  PRIMARY KEY (`home_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_home` */

/*Table structure for table `i_message` */

DROP TABLE IF EXISTS `i_message`;

CREATE TABLE `i_message` (
  `message_id` varchar(16) NOT NULL COMMENT '消息id',
  `message` text NOT NULL COMMENT '消息内容',
  `dateline` int(11) NOT NULL COMMENT '消息产生时间',
  PRIMARY KEY (`message_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='消息表';

/*Data for the table `i_message` */

/*Table structure for table `i_notice` */

DROP TABLE IF EXISTS `i_notice`;

CREATE TABLE `i_notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notice_type` varchar(20) NOT NULL COMMENT '通知类型，system：系统通知，message：用户留言',
  `from_uid` varchar(16) NOT NULL COMMENT '发送人',
  `to_uid` varchar(16) NOT NULL COMMENT '接收人',
  `notice_status` tinyint(4) NOT NULL COMMENT '通知状态，0：未读，1：已读',
  `dateline` int(11) NOT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_notice` */

/*Table structure for table `i_options` */

DROP TABLE IF EXISTS `i_options`;

CREATE TABLE `i_options` (
  `opt_name` varchar(50) NOT NULL,
  `opt_value` text,
  PRIMARY KEY (`opt_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_options` */

/*Table structure for table `i_post` */

DROP TABLE IF EXISTS `i_post`;

CREATE TABLE `i_post` (
  `post_id` varchar(16) NOT NULL COMMENT '文章id',
  `post_type` varchar(20) NOT NULL COMMENT '文章类型，text：文字，image：图片，music：音乐',
  `title` varchar(50) DEFAULT NULL COMMENT '文章标题',
  `content` text COMMENT '文章内容',
  `star_count` int(10) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `reply_count` int(10) NOT NULL DEFAULT '0' COMMENT '回复数',
  `dateline` int(11) NOT NULL COMMENT '发布时间',
  `update_time` int(11) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`post_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_post` */

/*Table structure for table `i_tag` */

DROP TABLE IF EXISTS `i_tag`;

CREATE TABLE `i_tag` (
  `tag_id` varchar(16) NOT NULL COMMENT '标签id',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名称',
  `count` int(10) NOT NULL DEFAULT '0' COMMENT '标签下内容数',
  PRIMARY KEY (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_tag` */

/*Table structure for table `i_tag_post` */

DROP TABLE IF EXISTS `i_tag_post`;

CREATE TABLE `i_tag_post` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tag_id` varchar(16) NOT NULL,
  `post_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `i_tag_post` */

/*Table structure for table `i_user` */

DROP TABLE IF EXISTS `i_user`;

CREATE TABLE `i_user` (
  `uid` varchar(16) NOT NULL COMMENT '用户uuid，唯一标识',
  `login_name` varchar(30) NOT NULL COMMENT '用户登录名',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `pass_word` varchar(32) NOT NULL COMMENT '密码',
  `sex` char(2) NOT NULL COMMENT '性别，M：男，F：女',
  `email` varchar(200) NOT NULL COMMENT '用户邮箱',
  `avatar` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态，0：未激活，1：正常，2：禁用',
  `group_id` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户所在组id，默认为0，普通用户，1：系统管理',
  `reg_time` int(11) NOT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `i_user` */

/*Table structure for table `i_user_follow` */

DROP TABLE IF EXISTS `i_user_follow`;

CREATE TABLE `i_user_follow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) NOT NULL,
  `follow_uid` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='关注表';

/*Data for the table `i_user_follow` */

/*Table structure for table `i_user_log` */

DROP TABLE IF EXISTS `i_user_log`;

CREATE TABLE `i_user_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(16) NOT NULL COMMENT '日志产生人',
  `action` varchar(50) NOT NULL COMMENT '动作',
  `action_data` text COMMENT '日志数据',
  `dateline` int(11) NOT NULL COMMENT '日志产生时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户日志表';

/*Data for the table `i_user_log` */

/*Table structure for table `i_user_post` */

DROP TABLE IF EXISTS `i_user_post`;

CREATE TABLE `i_user_post` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) NOT NULL COMMENT '用户id',
  `post_id` varchar(16) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `i_user_post` */

/*Table structure for table `i_user_unfollow` */

DROP TABLE IF EXISTS `i_user_unfollow`;

CREATE TABLE `i_user_unfollow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) NOT NULL,
  `unfollow_uid` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='被关注表';

/*Data for the table `i_user_unfollow` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
