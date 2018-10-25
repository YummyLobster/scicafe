drop table attender_events;
drop table authorities;
drop table events;
drop table events_attendance;
drop table eventsToReward;
drop table hibernate_sequence;
drop table program;
drop table reward;
drop table roles;
drop table tags;
drop table use_tags;
drop table user_programs;
drop table users;

create table attender_events (
       user_id bigint not null,
        event_id bigint not null,
        primary key (user_id, event_id)
    ) engine=InnoDB;

    create table authorities (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB;

    create table events (
       id bigint not null,
        description varchar(255) not null,
        end_date datetime(6) not null,
        location varchar(255) not null,
        start_date datetime(6) not null,
        status varchar(255) DEFAULT 'SUBMITTED',
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table events_attendance (
       user_id bigint not null,
        events_id bigint not null,
        primary key (user_id, events_id)
    ) engine=InnoDB;

    create table eventsToReward (
       reward_id bigint not null,
        event_id bigint not null,
        primary key (reward_id, event_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
   ) engine=InnoDB;


    create table program (
       program_id bigint not null,
        description varchar(255) not null,
        fullName varchar(255) not null,
        name varchar(255) not null,
        primary key (program_id)
    ) engine=InnoDB;

    create table reward (
       reward_id bigint not null,
        description varchar(255) not null,
        end_date datetime(6) not null,
        provider varchar(255) not null,
        reward_criteria integer,
        start_date datetime(6) not null,
        status varchar(255) DEFAULT 'SUBMITTED',
        primary key (reward_id)
    ) engine=InnoDB;

    create table roles (
       id bigint not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tags (
       id bigint not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table use_tags (
       reward_id bigint not null,
        tag_id bigint not null,
        events_id bigint not null,
        primary key (tag_id)
    ) engine=InnoDB;

    create table user_programs (
       user_id bigint not null,
        program_id bigint not null,
        primary key (user_id, program_id)
    ) engine=InnoDB;

    create table users (
       id bigint not null,
        email varchar(255) not null,
        enabled bit not null default true,
        firstName varchar(255) not null,
        lastName varchar(255) not null,
        orgOrMajor varchar(255) not null,
        password varchar(255) not null,
        position varchar(255) not null,
        title varchar(255),
        username varchar(255) not null unique,
        primary key (id)
    ) engine=InnoDB;
    insert into hibernate_sequence values ( 2 );

    insert into roles values (1, 'ADMIN');
    insert into roles values (2, 'EVENTORG');
    insert into roles values (3, 'REWARDORG');
    insert into roles values (4, 'USER');


    insert into users (id, username, password, firstName, lastName, email, position,orgOrMajor) values (1, 'admin', '1234', 'Daniel', 'Chang', 'dchang@cal.edu' ,'student',"csula");
    insert into users (id, username, password, firstName, lastName, email, position,orgOrMajor) values (2, 'lobster', 'yummy', 'David', 'Chang', 'dchang@cal.edu' ,'student',"computer science");

    insert into authorities (user_id, role_id) value (1, 2);
    insert into authorities (user_id, role_id) value (1, 1);



    insert into events (id, title, description, location, start_date, end_date, status)
        value(1,'Welcome Week','Welcome all students come to CSULA.', 'Main Walkway','2018-08-20 12:00:00','2018-08-27 12:00:00','POSTED' );
    insert into events (id, title, description, location, start_date, end_date, status)
            value(2,'Orientation','All new gradaute students orientation', 'Golden Eagle Ball room','2018-08-19 12:00:00','2018-08-19 12:59:59','SUBMITTED' );


    insert into events_attendance (user_id, events_id)value (1, 1);
    insert into events_attendance (user_id, events_id)value (1, 2);
    insert into events_attendance (user_id, events_id)value (2, 1);

    insert into tags(id, name)value(1,"CSULA");
    insert into tags(id, name)value(2,"WELCOME");

    insert into reward (reward_id, description, reward_criteria, start_date, end_date, provider, status) values (1, 'Creation-reward', 2, '2018-8-8 8:00', ' 2018-8-30 8:00', 'dean of CS deparment', 'POSTED');

    insert into use_tags (tag_id, events_id, reward_id)value (2, 1, 1);

    insert into program (program_id,description, fullName,name) value (1,"share first year Experience to the Fresh man.","First-Year Experience Program at ECST","FYrE@ECST");
    insert into program (program_id,description, fullName,name) value (2,"Programmers, lets coding together!","Programmers at ECST","Ps@ECST");
select * from program;
