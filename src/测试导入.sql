DROP DATABASE IF EXISTS xunfang;
CREATE DATABASE xunfang;
USE xunfang;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `account` VARCHAR(64) NOT NULL COMMENT '�ʻ�',
  `password` VARCHAR(64) NOT NULL COMMENT '����',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='�û�';
INSERT INTO user(account,password) VALUES("root","admin"); 
INSERT INTO user(account,password) VALUES("123","123"); 