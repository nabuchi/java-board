drop table javaboard.res;
create table javaboard.res(
    id int auto_increment not null primary key, 
    author tinytext not null,
    content text not null,
    time timestamp not null default current_timestamp,
    userid int not null,
    topicid int not null
);
drop table javaboard.topic;
create table javaboard.topic(
    id int auto_increment not null primary key,
    title text not null,
    created_date timestamp not null default current_timestamp,
    userid int not null
);
drop table javaboard.userinfo;
create table javaboard.userinfo(
    id int auto_increment not null primary key,
    name varchar(255) unique not null,
    password tinytext not null,
    birthday date not null
);
