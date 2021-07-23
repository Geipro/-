``` MySQL
-- USER_ID를 받아야되기 때문에 수정예정


drop table Game;
drop table Room;
drop table Room_History;
drop table Room_User;


create table Game(
	game_type varchar(20) Primary key,
    info varchar(100) not null,
    max_user int not null,
    game_image varchar(100)
);

insert into Game values("마피아게임", "마피아게임", 8);
insert into Game values("번역기게임", "번역기게임", 8);

-- USER DB 연동시에 owner DB 연동 예정
create table Room(
	room_id Integer Primary key auto_increment,
    game_type varchar(20) not null,
    room_title varchar(50) not null,
    room_owner varchar(13) not null,
    created_at DateTime not null DEFAULT NOW(),
    room_status varchar(2) not null,
	foreign key (game_type) references Game(game_type)
);

create table Room_Result(
	room_id int not null,
    game_type varchar(20) not null,
    user_id varchar(20) not null,
    point varchar(50) not null,
    result int not null,
    finished_at DateTime not null DEFAULT NOW(),
	foreign key (game_type) references Game(game_type),
	foreign key (room_id) references Room(room_id)
);


create table Room_user(
	room_id int not null,
    user_id varchar(13) not null,
    finish boolean not null,
    point int,
    foreign key(room_id) references Room(room_id)
);

-- Room_User
select * from game;
select * from room;
select * from room_history;
select * from room_user;
```