create table tbl_member(
	userid varchar(50) not null,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate timestamp default now(),
    updatedate timestamp default now(),
    primary key(userid)
);

create table tbl_board(
	bno int not null auto_increment,
    title varchar(200) not null,
    content TEXT null,
    writer varchar(50) not null,
    regdate timestamp not null default now(),
    viewcnt int default 0,
    primary key (bno)
);

insert into tbl_board (title, content, writer)
	values('제목입니다.','내용입니다.','user00');
    
select * from tbl_board;