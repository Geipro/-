create database if not exists `ssafy_web_db` collate utf8mb4_general_ci; 
 
use ssafy_web_db;  
drop table `user`; 
drop table `Profile`; 
drop table `game`;
drop table `room`;
drop table `roomresult`;
drop table `roomuser`;
 
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
    foreign key (`userId`) REFERENCES `user` (`userId`) 
)default CHARACTER SET UTF8 collate utf8_general_ci; 

create table `game`(
	`game_type` varchar(20) Primary key,
    `info` varchar(100) not null,
    `max_user` int not null,
    `game_image` varchar(100)
)default CHARACTER SET UTF8 collate utf8_general_ci;

create table `room`(
	`room_id` Integer Primary key auto_increment,
    `game_type` varchar(20) not null,
    `room_title` varchar(50) not null,
    `room_owner` varchar(13) not null,
    `created_at` DateTime not null DEFAULT NOW(),
    `room_status` varchar(2) not null,
	foreign key (`game_type`) references `game` (`game_type`),
	foreign key (`room_owner`) references `profile` (`userId`)
)default CHARACTER SET UTF8 collate utf8_general_ci;

create table `roomResult`(
	`room_id` int not null,
    `game_type` varchar(20) not null,
    `user_id` varchar(20) not null,
    `point` varchar(50) not null,
    `result` int not null,
    `finished_at` DateTime not null DEFAULT NOW(),
	foreign key (`game_type`) references Game(`game_type`),
	foreign key (`room_id`) references Room(`room_id`)
)default CHARACTER SET UTF8 collate utf8_general_ci;


create table `roomUser`(
	`room_id` int not null,
    `user_id` varchar(13) not null,
    `finish` boolean not null,
    `point` int,
	foreign key (`user_id`) references `profile` (`useriD`),
    foreign key(`room_id`) references Room(`room_id`)
)default CHARACTER SET UTF8 collate utf8_general_ci;

insert into Game(game_type, info, max_user) values("마피아게임", "마피아게임", 8);
insert into Game(game_type, info, max_user) values("번역기게임", "번역기게임", 8);

-- Room_User
select * from `user`;
select * from `profile`;
select * from `game`;
select * from `room`;
select * from `room_result`;
select * from `room_user`;