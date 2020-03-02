# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2020-02-25 22:02:30
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "dept"
#

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "dept"
#

INSERT INTO `dept` VALUES (1,'�з���'),(2,'�г���1'),(3,'ϵͳ���ɲ�');

#
# Structure for table "meeting"
#

DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `use_machine` tinyint(3) DEFAULT NULL COMMENT '0δʹ�ã�1ʹ��',
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `meeting_room_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `important` tinyint(3) DEFAULT NULL COMMENT '0����Ҫ��1����Ҫ',
  `status` varchar(255) DEFAULT NULL COMMENT '0δ������1����ͨ����2��������',
  `user` varchar(255) DEFAULT NULL,
  `res_status` varchar(255) DEFAULT '0' COMMENT '0��ԤԼ��1ԤԼ',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "meeting"
#

INSERT INTO `meeting` VALUES (13,0,'2020-02-24 19:32','2020-02-24 20:57',8,'11',0,'1','admin',NULL),(14,0,'2020-02-25 10:07','2020-02-25 11:00',8,'111',0,'2','admin',NULL),(15,0,'2020-02-25 10:07','2020-02-25 11:00',8,'23',0,'1','admin',NULL),(18,0,'2020-02-26 19:15','2020-02-26 19:50',8,'222',1,'0','admin','1');

#
# Structure for table "meeting_room"
#

DROP TABLE IF EXISTS `meeting_room`;
CREATE TABLE `meeting_room` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `machine` varchar(255) DEFAULT NULL COMMENT '0δʹ���豸��1ʹ���豸',
  `remark` varchar(255) DEFAULT NULL,
  `status` tinyint(3) DEFAULT '0' COMMENT '0���У�1ռ��',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "meeting_room"
#

INSERT INTO `meeting_room` VALUES (7,'001��','������001',10,'δʹ��','',0),(8,'002��','������002',10,'����','',1);

#
# Structure for table "meeting_user"
#

DROP TABLE IF EXISTS `meeting_user`;
CREATE TABLE `meeting_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "meeting_user"
#

INSERT INTO `meeting_user` VALUES (11,13,4),(12,14,2),(13,15,2),(18,18,4),(19,18,2),(20,18,1);

#
# Structure for table "permission"
#

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

#
# Data for table "permission"
#

INSERT INTO `permission` VALUES (66,'��ɫ����','��ɫ����','listRole',68),(67,'Ȩ�޹���','Ȩ�޹���','listPermission',68),(68,'ϵͳ����','ϵͳ����','',0),(73,'�û�����','�û�����','listUser',68),(77,'�������','�������','',0),(82,'ԤԼ����','ԤԼ����','listReservationManage',77),(83,'��������','��������','listMeetingRoom',77),(84,'����ԤԼ','����ԤԼ','listReservation',77),(85,'��������','��������','listCheck',77),(87,'�����ҹ���','�����ҹ���','listMeetingRoomManage',77),(88,'�ҵ�����','�ҵ�����','listMyApply',77),(89,'������Ϣͳ��','������Ϣͳ��','listMeetingCount',77),(90,'�����ѯ','�����ѯ','listMeeting',77),(91,'���Ź���','���Ź���','listDeptManage',68);

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc_` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (2,'����Ա','����Ա'),(4,'�û�','�û�');

#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=991 DEFAULT CHARSET=utf8;

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` VALUES (972,2,68),(973,2,66),(974,2,67),(975,2,73),(976,2,91),(977,2,77),(978,2,82),(979,2,83),(980,2,84),(981,2,85),(982,2,87),(983,2,88),(984,2,89),(985,2,90),(986,4,77),(987,4,83),(988,4,84),(989,4,88),(990,4,90);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '����',
  `password` varchar(255) DEFAULT NULL COMMENT '����',
  `number` varchar(255) DEFAULT NULL COMMENT '�û����',
  `email` varchar(255) DEFAULT NULL COMMENT '����',
  `job` varchar(255) DEFAULT NULL COMMENT 'ְ��',
  `deptId` int(11) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'admin','admin','1','789@qq.com111','�з�����',3,'����Ա111'),(2,'hehuan','123123','2','456@qq.com','����ʦ',3,'�λ�'),(4,'zmy','zmy','3','123@qq.com','�г�������',2,'����');

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (118,4,4),(119,2,4),(120,1,2);
