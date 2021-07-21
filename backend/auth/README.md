create database if not exists `ssafy_web_db` collate utf8mb4_general_ci;

use ssafy_web_db; 

CREATE TABLE `User`(
	`user_id` varchar(13) NOT NULL,
	`email` varchar(50) NOT NULL,
    `username` varchar(10) NOT NULL,
    `password` varchar(60) NOT NULL,
    PRIMARY KEY (user_id)
)default CHARACTER SET UTF8 collate utf8_general_ci;

CREATE TABLE `Profile`(
	`profile_id` int NOT NULL AUTO_INCREMENT primary KEY,
    `user_id` varchar(13),
    `audio` varchar(40),
    `mic` varchar(40),
    `camera` varchar(40),
    `total_point` int,
    `is_leave` boolean,
    foreign key (user_id) REFERENCES `User` (user_id)
)default CHARACTER SET UTF8 collate utf8_general_ci;