drop table login

/


drop table experience

/

drop sequence experience_seq

/


drop table salary

/

drop sequence salary_seq

/


drop table attendance

/

drop sequence attendance_seq

/


drop table loan_tran

/

drop sequence loan_tran_seq

/

drop table loan_master

/

drop sequence loan_master_seq

/

drop table employee_profile

/

drop sequence employee_profile_seq

/


drop table employee

/

drop sequence employee_seq

/

drop table bank_master

/

drop table company_master

/

drop table dept

/

drop sequence dept_seq

/

drop table designation

/

drop sequence designation_seq

/




create table bank_master
(
  bank_code varchar2(5) primary key,
  bank_name varchar2(50) not null,
  bank_address varchar2(200) not null,
  bank_city varchar2(20),
  bank_phone varchar2(20),
  bank_branch varchar2(40)
)

/

create table company_master
(
  cmp_code varchar2(5) primary key,
  cmp_name varchar2(100),
  cmp_address varchar2(200),
  cmp_city varchar2(30),
  cmp_state varchar2(20),
  cmp_pin varchar2(6)
)

/

create table dept
(
   dept_code number(2) primary key,
   dept_name varchar2(30)
)

/

create sequence dept_seq

/

create table designation
(
  dg_code number(2) primary key,
  dg_name varchar2(30)
)

/

create sequence designation_seq

/

create table employee
(
   emp_code number(5) primary key,
   cmp_code varchar2(5) references company_master(cmp_code),
   first_name varchar2(20),
   middle_name varchar2(20),
   last_name varchar2(20),
   address varchar2(200),
   city varchar2(30),
   state varchar2(20),
   pin varchar2(6),
   phone varchar2(20),
   dg_code number(2) references designation(dg_code),
   dept_code number(2) references dept(dept_code),
   join_date date,
   birth_date date,
   bank_code varchar2(5) references bank_master(bank_code),
   bank_account varchar2(15),
   pf_no varchar2(10),
   email varchar2(50)
)

/

create sequence employee_seq

/

create table employee_profile
(
   profile_code  number(7) primary key,
   emp_code number(5) references employee(emp_code),
   dg_code number(2) references designation(dg_code),
   dept_code number(2) references dept(dept_code),
   start_date date,
   end_date date,
   basic_salary number(15,2) 
)

/

create sequence employee_profile_seq

/


create table loan_master
(
   loan_code number(7) primary key,
   profile_code number(7) references employee_profile(profile_code),
   loan_date date,
   loan_amount number(15,2),
   inst_amount number(15,2) 
)

/

create sequence loan_master_seq

/

create table loan_tran
(
   loan_tran_code number(10) primary key,
   loan_code number(7) references loan_master(loan_code),
   tran_date date,
   tran_amount number(15,2),
   narration varchar2(50)
)

/


create sequence loan_tran_seq

/


create table attendance
(
  att_code number(10) primary key,
  profile_code number(7) references employee_profile(profile_code),
  att_date date,
  overtime_hours number(3),
  present number(2),
  absent number(2),
  weekoff number(2),
  leave number(2),
  holiday number(2),
  halfday number(2)
)

/

create sequence attendance_seq

/

create table salary
(
  salaryid number(10) primary key,
  salarydate date,
  profile_code number(7) references employee_profile(profile_code),
  da number(15),
  hra number(15),
  ma number(15),
  ptax number(15),
  leave_dedu number(15),
  overtime number(15),
  pf_amount number(15),
  other_allow number(15),
  other_dedu number(15)
)

/

create sequence salary_seq

/

create table experience
(
  exp_id number(5) primary key,
  emp_code number(5) references employee(emp_code),
  cmp_name varchar2(50),
  from_date date,
  to_date date,
  desig varchar2(15)
)

/

create sequence experience_seq

/


create table login
(
   username varchar2(15) primary key,
   password varchar2(40),
   question varchar2(50),
   answer varchar2(50)
)

/

insert into login values ('admin','admin',
'What is your cell number','90909090')

/

