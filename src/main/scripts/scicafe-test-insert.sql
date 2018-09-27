insert into roles values (1, 'ADMIN');
insert into roles values (2, 'EVENTORG');
insert into roles values (3, 'REWARDORG');
insert into roles values (4, 'USER');
insert into authorities (user_id, role_id) value (1, 1);
insert into users (id, username, password, firstName, lastName, email, postion,organization) values (1, 'admin', '1234', 'Daniel', 'Chang', 'dchang@cal.edu' ,'student',4);
insert into users (id, username, password, firstName, lastName, email, postion,organization) values (2, 'lobster', 'yummy', 'David', 'Chang', 'dchang@cal.edu' ,'student',4);

insert into authorities (user_id, role_id) value (1, 2);
insert into organizations(id,name,above) value(1,"CSULA",NULL);
insert into organizations(id,name,above) value(2,"ECST",1);
insert into organizations(id,name,above) value(3,"Computer Science",2);
insert into organizations(id,name,above) value(4,"undeclared",NULL);


insert into events (id, title, description, location, start_date, end_date, status)
    value(1,'Welcome Week','Welcome all students come to CSULA.', 'Main Walkway','2018-08-20 12:00:00','2018-08-27 12:00:00','1' );
insert into events (id, title, description, location, start_date, end_date, status)
        value(2,'Orientation','All new gradaute students orientation', 'Golden Eagle Ball room','2018-08-19 12:00:00','2018-08-19 12:59:59','1' );

insert into events_poster (user_id, events_id)value (1, 1);
insert into events_poster (user_id, events_id)value (1, 2);

insert into events_attendance (user_id, events_id)value (1, 1);
insert into events_attendance (user_id, events_id)value (1, 2);
insert into events_attendance (user_id, events_id)value (2, 1);
