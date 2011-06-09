drop table javaboard.res;
create table javaboard.res(
    id int auto_increment not null primary key, 
    author tinytext not null,
    content text not null,
    time datetime not null
);
drop table javaboard.thread;
create table javaboard.thread(
    id int not null primary key,
    threadid int not null
);
drop table javaboard.userinfo;
create table javaboard.userinfo(
    id int not null primary key,
    name tinytext not null
);
