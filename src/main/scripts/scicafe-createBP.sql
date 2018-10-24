create table users (
    id          bigint primary key,
    username    varchar(255) not null unique,
    password    varchar(255) not null,
    enabled     boolean not null default true,
    firstName   varchar(255) not null,
    lastName    varchar(255) not null,
    email       varchar(255) not null,
    postion     varchar(255) not null,
    title       varchar(255),
    organization bigint not null,
    programAffiliations    varchar(255)

);
create table roles (
    id      bigint primary key,
    name    varchar(255) not null unique
);
create table authorities (
    user_id bigint not null references users(id),
    role_id bigint not null references roles(id),
  primary key (user_id, role_id)
);
create table organizations(
 id     bigint primary key,
 name   varchar(255) not null unique,
 above  bigint
);
create table events (
    id          bigint primary key,
    title    varchar(255) not null,
    description    varchar(255) not null,
    location     varchar(255) not null,
    start_date   DATETIME,
    end_date    DATETIME,
    status     varchar(255) not null
);
create table events_poster (
    user_id bigint not null references users(id),
    events_id bigint not null references roles(id),
  primary key (user_id, events_id)
);
create table events_attendance (
    user_id bigint not null references users(id),
    events_id bigint not null references roles(id),
  primary key (user_id, events_id)
);
create table program (
    id      bigint primary key,
    name    varchar(255) not null unique,
    fullname    varchar(255) not null unique,
    description    varchar(255) not null
);
create table reward(
    id      bigint primary key,
    title    varchar(255) not null,
    description    varchar(255) not null,
    provider varchar(255) not null,
    status varchar(255) not null,
    start_date   DATETIME,
    end_date    DATETIME,
    qualified_events  varchar(255) not null,
    reward_criteria varchar(255) not null
);
create table tags(
    id      bigint primary key,
    name    varchar(255) not null unique
);
create table use_tags (
    tag_id bigint references tags(id),
    events_id bigint references events(id),
    reward_id bigint references reward(id),
  primary key (tag_id,reward_id, events_id)
);
