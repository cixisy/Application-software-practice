use employee_overtime;
create table employee_info
(
epnum int primary key not null,
ename varchar(9) not null,
superior_epnum int,
dep_num int,
salary int,
sex varchar(5),
overtime_salary int,
total_salary int,
superior_mark boolean,
pwd varchar(20)
);
create table overtime_info(
otime date not null DEFAULT '2020-06-03',
epnum int not null,
otype int ,
o_start date,
o_end date,
o_total int,
o_descrip text,
o_mark boolean,
o_confirm_person varchar(9),
primary key(epnum,otime,o_start),
foreign key(epnum) references employee_info(epnum)
);
create table admin_info
(
adnum int primary key not null,
ename varchar(9) not null,
sex varchar(5),
pwd varchar(20)
);






