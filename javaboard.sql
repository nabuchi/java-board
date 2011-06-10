drop table javaboard.res;
create table javaboard.res(
    id int auto_increment not null primary key, 
    author tinytext not null,
    content text not null,
    time datetime not null,
    userid int not null
);
drop table javaboard.thread;
create table javaboard.thread(
    id int auto_increment not null primary key,
    title text not null,
    created_date datetime not null,
    userid int not null
);
drop table javaboard.userinfo;
create table javaboard.userinfo(
    id int auto_increment not null primary key,
    name varchar(255) unique not null,
    password tinytext not null,
    secret_question tinytext not null,
    secret_question_answer tinytext not null
);
