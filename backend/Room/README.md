```mySQL

-- USER_ID를 받아야되기 때문에 수정예정


drop table Game;
drop table Room;
drop table Room_History;


create table Game(
	game_title varchar(20) Primary key,
    info varchar(100) not null,
    max_user int not null
);

insert into Game values("마피아게임", "마피아게임", 8);
insert into Game values("번역기게임", "번역기게임", 8);

-- USER DB 연동시에 owner DB 연동 예정
create table Room(
	room_id Integer Primary key auto_increment,
    game_title varchar(20) not null,
    name varchar(50) not null,
    password varchar(13),
    playing bool not null,
    owner varchar(13) not null,
    created_at DateTime not null DEFAULT NOW(),
	foreign key (game_title) references Game(game_title)
);

create table Room_History(
	room_id int not null,
    game_title varchar(20) not null,
    name varchar(50) not null,
    owner varchar(13) not null,
    created_at DateTime not null,
    finished_at DateTime not null DEFAULT NOW(),
	foreign key (game_title) references Game(game_title),
	foreign key (room_id) references Room(room_id)
);

-- Room_User
select * from game;
select * from room;
select * from room_history;
```