/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/* Admin Table */
CREATE TABLE `admininfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) NOT NULL,
  `adminpwd` varchar(20) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

/* Admin Data */
insert into `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) values('1','admin-1','12345','1,2,3','2016-12-05 14:38:10');
insert into `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) values('2','admin-2','23456','1','2016-12-05 14:42:44');
insert into `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) values('3','admin-3','11111','2','2016-12-05 14:42:44');

/* Student Table */
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(20) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8

/* Student Data */
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('5','005','学生1','20','3434@565.c');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('6','006','学生2','30','5454@dfd.c');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('7','007','学生3','50','232@dfd.co');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('8','008','学生4','20','9898@65');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('9','009','学生5','10','989@fgd');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('10','010','学生6','30','2323@dssd');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('11','011','学生7','23','48@sds');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('12','012','学生8','12','11111@qq.com');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('15','111','222','33','44');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('16','B001','测试2','12','ssds@ssd.com');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('17','B002','Liu Zhan','34','124232@sdsd.com');
insert into `student` (`id`, `sid`, `sname`, `age`, `email`) values('18','B003','Ce Shi','24','iuf@sdse.com');

/* Menu Table */
CREATE TABLE `tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(30) NOT NULL,
  `iconCls` varchar(30) DEFAULT NULL,
  `url` varchar(30) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `isleaf` int(11) DEFAULT NULL,
  `access` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8

/* Menu Data */
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('8','User Menu','icon-sum','','0','1','1,2');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('9','Tools','icon-cut','','8','1','1');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('10','Tools Form 2','','Test2','9','1','1');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('11','Tools Form 8','','Test1','9','1','1');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('12','Actions','icon-save','','8','2','2');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('13','User Form','','Datagrid','12','2','2');
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`, `access`) values('14','User List','','student','12','2','2');
