select * from person
create database newdb1 charset=utf8;
use newdb1;
create table emp(id int,name varchar(50),sal int,deptId int)charset=utf8;
create table dept(id int,name varchar(50),loc varchar(50))charset=utf8;
insert into dept values(1,"神仙部","天庭"),(2,"妖怪部","盘丝洞");
insert into emp values(1,"悟空",5000,1),(2,"八戒",2000,1),(3,"蜘蛛精",8000,2),(4,"白骨精",9000,2);
select name,sal from emp where sal<6000;
update dept set name="取经部" where name="神仙部";
alter table emp add comm int;
update table emp set comm=500 where deptId=1;
update table dept set loc="五台山" where name="取经部";
alter table emp change comm gender varchar(50);
update emp set gender="男" where deptId=1;
delete from emp where gender is null;
alter table emp drop gender;








