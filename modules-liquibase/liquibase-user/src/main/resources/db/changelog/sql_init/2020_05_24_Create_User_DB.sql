create schema if not exists user_info;

create table if not exists user_info.app_user
       (
       user_id serial not null,
       username varchar(255) not null,
       password varchar(255) not null,
       email varchar(255) not null,
       primary key (user_id));

create unique index user_unique_index on user_info.app_user (username, email);
create unique index user_unique_email_index on user_info.app_user (email);
