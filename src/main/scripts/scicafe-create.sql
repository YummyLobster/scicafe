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
        status varchar(255),
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
        decription varchar(255) not null,
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
        status varchar(255),
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
        primary key (events_id, tag_id)
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
        organization varchar(255) not null,
        password varchar(255) not null,
        position varchar(255) not null,
        title varchar(255),
        username varchar(255) not null unique,
        primary key (id)
    ) engine=InnoDB;
