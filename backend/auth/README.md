create database if not exists `ssafy_web_db` collate utf8mb4_general_ci;

use ssafy_web_db; 
drop table `user`;
drop table `Profile`;

CREATE TABLE `user`(
	`userId` varchar(13) NOT NULL,
	`email` varchar(50) NOT NULL,
    `username` varchar(10) NOT NULL,
    `password` varchar(60) NOT NULL,
    `user_status` int,
    PRIMARY KEY (userId)
)default CHARACTER SET UTF8 collate utf8_general_ci;

CREATE TABLE `profile`(
	`profileId` int NOT NULL AUTO_INCREMENT primary KEY,
    `userId` varchar(13),
    `nickname` varchar(32) Not Null,
    `phoneNum` varchar(11) Not Null,
    `about_me` varchar(200),
    `audio` varchar(40),
    `mic` varchar(40),
    `camera` varchar(40),
    `profile_img` varchar(100),
    `back_img` varchar(100),
    `total_point` int,
    foreign key (userId) REFERENCES `user` (userId)
)default CHARACTER SET UTF8 collate utf8_general_ci;