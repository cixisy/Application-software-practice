-- create database if not exists ems default character set=utf8;admin_info
-- 员工基本信息：姓名、编号、性别，密码，上级员工编号、所在部门编号、
-- 员工加班信息：加班日期、员工编号、加班开始时间、加班类型编号、加班结束时间、加班累计时间、加班工作描述、确认标志、申请时间、审批描述、确认人
-- 管理员：姓名、账号、密码、性别
-- 员工请假表：编号，请假类型编号，请假开始日期，请假结束日期，请假累计日期，请假原因描述，确认标志，确认人,审批描述
-- 考勤表：编号、姓名、上班打卡时间、下班打卡时间、日期、备注
use ems;
create table if not exists employee_info
(
epnum int primary key not null,
ename varchar(9) not null,
pwd varchar(20),
sex int,
superior_epnum int,
dep_num int,
superior_mark int
);
create table if not exists admin_info
(
adnum int primary key not null,
ename varchar(9) not null,
pwd varchar(20),
sex int,
dep_num int
);
create table if not exists overtime_info(
epnum int not null,
o_type int ,
o_start datetime,
o_end datetime,
o_total int,
o_descrip text,
o_mark int,
o_confirm_person varchar(9),
o_comfirm_descrip text,
apply_time datetime not null DEFAULT '2020-06-03 00:00:00',
primary key(epnum,apply_time),
foreign key(epnum) references employee_info(epnum)
);
create table if not exists leave_info(
epnum int not null,
l_type int ,
l_start datetime,
l_end datetime,
l_total int,
l_descrip text,
l_mark int,
leave_confirm_person varchar(9),
leave_comfirm_descrip text,
apply_time datetime not null DEFAULT '2020-06-03 00:00:00',
primary key(epnum,apply_time),
foreign key(epnum) references employee_info(epnum)
);
create table if not exists cwa_info(
epnum int not null,
ename varchar(9) not null,
work_date date,
work_start datetime,
work_end datetime,
work_descrip text,
primary key(epnum,work_date),
foreign key(epnum) references employee_info(epnum)
)
