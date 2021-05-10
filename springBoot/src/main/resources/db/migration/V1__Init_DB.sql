create sequence if not exists hibernate_sequence start 10000 increment 10;

create table if not exists message_$t (
    id int8 not null,
    date_message
    timestamp,
    file varchar(65535),
    tag varchar(255),
    text varchar(2048) not null,
    user_id int8,
     primary key (id)
 );

create table if not exists user_$t (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

create table if not exists userrole_$t (
    user_id int8 not null,
    roles varchar(255)
);

alter table message_$t
    add constraint message_user_fk
    foreign key (user_id) references user_$t;

alter table userrole_$t
    add constraint user_role_user_fk
    foreign key (user_id) references user_$t;