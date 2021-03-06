insert into hibernate_sequence values ( 20 );

insert into roles values (1, 'ADMIN');
insert into roles values (2, 'EVENTORG');
insert into roles values (3, 'REWARDORG');
insert into roles values (4, 'USER');


insert into users (id, username, password, firstName, lastName, email, position,orgOrMajor) values (1, 'admin', '1234', 'Daniel', 'Chang', 'dchang@cal.edu' ,'student',"csula");
insert into users (id, username, password, firstName, lastName, email, position,orgOrMajor) values (2, 'lobster', 'yummy', 'David', 'Chang', 'dchang@cal.edu' ,'student',"computer science");
    insert into users (id, username, password, firstName, lastName, email, position,orgOrMajor) values (3, 'Sexy', 'yummy', 'John', 'Chang', 'jchang@cal.edu' ,'student',"computer science");

insert into authorities (user_id, role_id) value (1, 2);
insert into authorities (user_id, role_id) value (1, 1);



insert into events (id, title, description, location, start_date, end_date, status)
    value(1,'Welcome Week','Welcome all students come to CSULA.', 'Main Walkway','2018-08-20 12:00:00','2018-08-27 12:00:00','POSTED' );
insert into events (id, title, description, location, start_date, end_date, status)
        value(2,'Grad Orientation','All new gradaute students orientation', 'Golden Eagle Ball room','2018-08-19 12:00:00','2018-08-19 12:59:59','SUBMITTED' );
insert into events (id, title, description, location, start_date, end_date, status)
        value(3,'UnderGrad Orientation','All new under gradaute students orientation', 'Golden Eagle Ball room','2018-08-20 12:00:00','2018-08-20 12:59:59','SUBMITTED' );


insert into events_attendance (user_id, events_id)value (1, 1);
insert into events_attendance (user_id, events_id)value (1, 2);
insert into events_attendance (user_id, events_id)value (2, 1);

insert into tags(id, name)value(1,"CSULA");
insert into tags(id, name)value(2,"WELCOME");

insert into reward (reward_id, description, reward_criteria, start_date, end_date, provider, status) values (1, 'Creation-reward', 2, '2018-8-8 8:00', ' 2018-8-30 8:00', 'dean of CS deparment', 'POSTED');

insert into use_tags (tag_id, events_id, reward_id)value (2, 1, 1);

insert into program (program_id,description, fullName,name) value (1,"share first year Experience to the Fresh man.","First-Year Experience Program at ECST","FYrE@ECST");
insert into program (program_id,description, fullName,name) value (2,"Programmers, lets coding together!","Programmers at ECST","Ps@ECST");
insert into program (program_id,description, fullName,name) value (3,"Programmers, lets coding together!","Programmers at CSULA","Ps@CSULA");
