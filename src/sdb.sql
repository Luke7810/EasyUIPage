/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `student` (
	`id` int ,
	`sname` varchar ,
	`age` int ,
	`sid` varchar ,
	`email` varchar 
); 

CREATE TABLE `admininfor`(
`id` INT NOT NULL AUTO_INCREMENT,
`adminname` VARCHAR(20) NOT NULL,
`adminpwd` VARCHAR(20) NOT NULL,
`author` VARCHAR(50),
`createdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) VALUES (NULL, 'admin-1', '12345', '1,2,3', CURRENT_TIMESTAMP); 
INSERT INTO `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) VALUES (NULL, 'admin-2', '23456', '1,3', CURRENT_TIMESTAMP); 
INSERT INTO `admininfor` (`id`, `adminname`, `adminpwd`, `author`, `createdate`) VALUES (NULL, 'admin-3', '11111', '1', CURRENT_TIMESTAMP); 

insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('1','åˆ˜å¾·å�Ž','40','001','kjhjdf@sdf');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('2','åˆ˜å¼º','38','002','sdd123@sds');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('3','å¼ å­¦å�‹','50','003','4544@dff.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('4','å¼ æƒ å¦¹','30','004','2344@dfd.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('5','å­¦ç”Ÿ1','20','005','3434@565.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('6','å­¦ç”Ÿ2','30','006','5454@dfd.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('7','å­¦ç”Ÿ3','50','007','232@dfd.co');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('8','å­¦ç”Ÿ4','20','008','9898@65');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('9','å­¦ç”Ÿ5','10','009','989@fgd');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('10','å­¦ç”Ÿ6','30','010','2323@dssd');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('11','å­¦ç”Ÿ7','23','011','48@sds');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('12','å­¦ç”Ÿ8','12','012','879@dfd');


CREATE TABLE `tree`( 
`id` INT NOT NULL AUTO_INCREMENT, 
`text` VARCHAR(30) NOT NULL, 
`iconCls` VARCHAR(30), 
`url` VARCHAR(30), 
`pid` INT, `isleaf` INT, 
PRIMARY KEY (`id`) 
); 


create table `tree` (
	`id` int ,
	`text` varchar ,
	`iconCls` varchar ,
	`url` varchar ,
	`pid` int ,
	`isleaf` int 
); 
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('8','User Menu','icon-sum','',NULL,NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('9','Tools','icon-cut','','8',NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('10','Tools Form 2','','Test2','9',NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('11','Tools Form 8','','Test1','9',NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('12','Actions','icon-save','','8',NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('13','User Form','','Datagrid','12',NULL);
insert into `tree` (`id`, `text`, `iconCls`, `url`, `pid`, `isleaf`) values('14','User List','','student','12',NULL);
