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

insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('1','刘德华','40','001','kjhjdf@sdf');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('2','刘强','38','002','sdd123@sds');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('3','张学友','50','003','4544@dff.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('4','张惠妹','30','004','2344@dfd.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('5','学生1','20','005','3434@565.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('6','学生2','30','006','5454@dfd.c');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('7','学生3','50','007','232@dfd.co');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('8','学生4','20','008','9898@65');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('9','学生5','10','009','989@fgd');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('10','学生6','30','010','2323@dssd');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('11','学生7','23','011','48@sds');
insert into `student` (`id`, `sname`, `age`, `sid`, `email`) values('12','学生8','12','012','879@dfd');
