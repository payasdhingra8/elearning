create database elearning;
use elearning;

create table user(
user_id int auto_increment primary key not null,
username varchar(45) ,
phone_no varchar(10) ,
email varchar(100) ,
address varchar(100) ,
reg_date date ,
password varchar(100) ,
upload_photo varchar(100) );

insert into user(user_id, username, phone_no, email, address, reg_date, password, upload_photo)
values(101, 'Ankit', '4578008234', 'ankit@gmail.com', 'noida', '2021-01-03', 'ankit', 'img.jpg');
insert into user(user_id, username, phone_no, email, address, reg_date, password, upload_photo)
values(102, 'Rahul', '9586234712', 'rahul@gmail.com', 'banglore', '2021-03-03', 'ankit', 'img1.jpg');
insert into user(user_id, username, phone_no, email, address, reg_date, password, upload_photo)
values(103, 'gouthami', '8524379162', 'gouthami@gmail.com', 'anantapur', '2021-02-03', 'gouthami', 'img2.jpg');
insert into user(user_id, username, phone_no, email, address, reg_date, password, upload_photo)
values(104, 'iswarya', '9256279162', 'iswarya@gmail.com', 'nellore', '2021-02-22', 'iswarya', 'img3.jpg');
insert into user(user_id, username, phone_no, email, address, reg_date, password, upload_photo)
values(105, 'harshitha', '7456279162', 'harshitha@gmail.com', 'vijayawada', '2020-01-22', 'harshitha', 'img4.jpg');

commit;
select * from user;

create table contact( 
user_id int,
username varchar(45) ,
email varchar(100) ,
phone_no varchar(10) ,
message varchar(30),
contact_id int not null,
primary key(contact_id),
foreign key(user_id) references user(user_id));

insert into contact values (101, 'Ankit', 'ankit@gmail.com', 1234, 'Message',1);
insert into contact values (102, 'Rahul', 'rahul@gmail.com', 1235, 'Message',2); 
insert into contact values (103, 'Gouthami', 'Gouthami@gmail.com', 1236, 'Message',3); 
insert into contact values (104, 'Ishwarya', 'Ishwarya@gmail.com', 1237, 'Message',4); 
insert into contact values (105, 'Harshitha', 'Harshitha@gmail.com', 1238, 'Message',5);

create table admin ( 
admin_id int primary key not null,
username varchar(45),
email varchar(100), 
password varchar(100));

insert into admin values(1, 'rahul', 'rahul@gmail.com','pass');
insert into admin values (2,'ankit','ankit@gmail.com','pass');
insert into admin values (3,'gowthami','gowthami@gmail.com','pass');
insert into admin values (4,'aishwarya','aishwarya@gmail.com','pass');
insert into admin values (5,'harshitha','harshitha@gmail.com','pass');

create table course(
course_id int primary key,
c_name varchar(100),
c_desp varchar(100),
c_fees varchar(100),
c_resource varchar(100));


insert into course values(111,'JAVA','Programing language',299, 'video.mp4');
insert into course values (112,'C Programming','Programming language',199, 'cprogram.mp4');
insert into course values (113,'C++ Programming','Programming language',199, 'c++program.mp4');

Select * from course;

create table feedback(
user_id int,
username varchar(45),
email varchar(100),
f_id int primary key,
feedback varchar(100),
foreign key(user_id) references user(user_id));


insert into feedback(user_id,username,email,f_id,feedback)values(101,'ankit','ankit@gmail.com',1,'good');
insert into feedback(user_id,username,email,f_id,feedback)values(105,'harshitha','harshitha@gmail.com',2,'good');
select * from feedback;







