-- ���������С: ctrl+shift+������  ���� ctrl+������ 
-- ע��: ctrl + /
-- ----------------------------�������ݿ�--------------------------------------
-- �﷨:
-- ��--�������ݿ�: create database ���ݿ� [character set �ַ���][collect У�Թ���];   []��ʾ��ѡ
-- ��--��ѯ���ݿ�: show databases;��ѯ���е����ݿ�     show create database ���ݿ���;��ѯָ�����ݿ�Ķ���ṹ
-- ��--�޸����ݿ�: alter database ���ݿ��� character set �ַ���; ע��:1.�����޸����ݿ���;  2.��utf8,����utf-8
-- ɾ--ɾ�����ݿ�: drop  database ���ݿ���;
-- ��������:  use ���ݿ���; �л����ݿ�     select database();��ѯĿǰѡ�е����ݿ�

-- ��ϰ:����һ�����ݿ�,����Ϊday17_1,����Ϊutf8
create database day17_1;

-- ��ϰ:����һ�����ݿ�,����Ϊday17_2,����Ϊgbk
create database day17_2 character set gbk;

-- ��ϰ:��ѯ���е�У�Թ���
show collation;

-- ��ϰ:��ѯ���е����ݿ�
show databases;

-- ��ϰ:��ѯday17_1���ݿ�Ķ���ṹ
show create database day17_1;

-- ��ϰ:��ѯday17_2���ݿ�Ķ���ṹ
show create database day17_2;

-- ��ϰ:�޸�day17_2���ݿ�ı���Ϊutf8
alter database day17_2 character set utf8;

-- ��ϰ:ɾ��day17_2������ݿ�
drop database day17_2;

-- ��ϰ: ѡ��day17_1���ݿ�
use day17_1;

-- ��ϰ: ��ѯĿǰѡ�е����ݿ�
 select database();


-- --------------------------------------�Ա�Ĳ���----------------------------------------
-- �﷨: 
-- 	create table ����(
				�ֶ��� �ֶ����� Լ��,
				�ֶ��� �ֶ����� Լ��,
				....
				�ֶ��� �ֶ����� Լ��
-- );
-- �ֶ�����: int,bigint,float,double,varchar(size),date,datetime
-- �ֶ�Լ��: not null, unique,primary key auto_increment
-- ��ϰ:����һ��ѧ����(����id�ֶ�,�����ֶ�,�Ա��ֶ�. idΪ�����Զ�����)
create table student(
	id int primary key auto_increment,
    name varchar(40),
    sex varchar(25)
);

-- �鿴��:
-- �鿴���еı�:show tables;
-- �鿴��Ķ���ṹ:desc  ������
-- ��ϰ: ��ѯday17_1���ݿ������б�
show tables;

-- ��ϰ: ��ѯstudent��Ķ���ṹ
desc student;


-- �޸ı�:
-- ����һ��:         alter table ���� add �ֶ��� �ֶ�����  �ֶ�Լ��;
-- �޸��ֶ�����Լ��: alter table ���� modify �ֶ��� �ֶ�����  �ֶ�Լ��;
-- �޸��ֶ���:       alter table ���� change ���ֶ��� ���ֶ��� �ֶ�����  �ֶ�Լ��;
-- ɾ���ֶ�:         alter table ���� drop �ֶ���;
-- �޸ı���          rename table �ɱ��� to �±���;
-- ��ϰ: ��ѧ��������һ��grade�ֶ�
alter table student add grade varchar(40) not null;

-- ��ϰ: ��ѧ�����sex�ֶθĳ��ַ������� 
alter table student modify sex varchar(20) not null;

-- ��ϰ: ��ѧ�����grade�ֶ��޸ĳ�class�ֶ�
alter table student change grade class varchar(40) ;

-- ��ϰ: ��class�ֶ�ɾ��
alter table student drop class;

-- ��ϰ: ��ѧ�����޸ĳ���ʦ��(�˽�)
rename table student to teacher;


-- ɾ����:drop table ������
-- ��ϰ:ɾ��teacher��
drop table teacher;

-- -------------------------------------������¼-----------------------------------------
-- ׼������: ����һ����Ʒ��(��Ʒid,��Ʒ����,��Ʒ�۸�,��Ʒ����.) 
create table product(
	pid int primary key auto_increment,  -- ֻ��������auto_increment id�вſ��Ը�ֵΪnull
	pname varchar(40) not null,
	price double,
	num int
);

-- �����¼:
-- ��ʽһ:ָ���ֶβ���---> insert into ����(�ֶ���1,�ֶ���2,...) values(ֵ1,ֵ2,...);
-- ��ʽ��:Ĭ�������в���-> insert into ���� values(ֵ1,ֵ2,...);
-- ע��:
-- - �����ض�����:û�и�ֵ����,ϵͳ�Զ���Ϊnull(ǰ���ǵ�ǰ��û������not null Լ��)
-- - �ֶ�����ֵ�����͡�������˳��Ҫһһ��Ӧ��
-- - ֵ��Ҫ�����ж���ĳ��ȡ�
-- - ��������ں��ַ�����ʹ�������������� 
-- - Ĭ�������в���,values������������ÿһ���ֶθ�ֵ,һ��������һ��null
-- ��ϰ: ָ��pname,price�в����¼
insert into product(pname,price) values("Mac",8888.9);

-- ��ϰ: ָ��price�в����¼
insert into product(price) values(8888.9);-- ����,��Ϊpname�ֶ������˷ǿ�Լ��,���ܸ�ֵΪnull

-- ��ϰ: ָ�������в����¼
insert into product values(null,'Macbook',9999.9,5);

-- ������������
insert into product values(null,'ƻ������',18000.0,10);
insert into product values(null,'��Ϊ5G�ֻ�',30000,20);
insert into product values(null,'С���ֻ�',1800,30);
insert into product values(null,'iPhonex',8000,10);
insert into product values(null,'ƻ������',8000,100);
insert into product values(null,'iPhone7',6000,200);
insert into product values(null,'iPhone6s',4000,1000);
insert into product values(null,'iPhone6',3500,100);
insert into product values(null,'iPhone5s',3000,100);
insert into product values(null,'������',4.5,1000);
insert into product values(null,'����',11,200); 
insert into product values(null,'��Ȫˮ',3,500);


-- �޸��е��﷨: update ���� set ���� = ֵ, ���� =ֵ,... [where ����];
-- - ��������Ʒ�ļ۸��޸�Ϊ5000Ԫ
update product set price = 5000;

-- - ����Ʒ����Mac�ļ۸��޸�Ϊ18000Ԫ
update product set price = 18000 where pname='Mac';

-- - ����Ʒ����Mac�ļ۸��޸�Ϊ17000,�����޸�Ϊ5
update product set price = 17000,num=5 where pname='Mac';

-- - ����Ʒ���Ƿ��������Ʒ�ļ۸���ԭ�л���������2Ԫ
update product set price = price + 2  where pname="������";


-- ɾ����:
-- ��ʽһ: delete from �� ��where ������;--����ɾ���������м�¼,Ҳ����ָ����¼ɾ��
-- ��ʽ��: truncate table ��;----->ɾ���������м�¼
-- - ɾ����������Ϊ��Mac���ļ�¼
delete from product where pname='Mac';

-- - ɾ���۸�С��5001����Ʒ��¼
delete from product where price < 5001;

-- - ɾ�����е����м�¼
delete from product;-- һ��һ����¼��ɾ��
truncate table product;-- ֱ��ɾ����,Ȼ�󴴽�һ�ź�֮ǰ�ṹһ���Ŀձ�


-- ---------------------------------------������ѯ------------------------------------------------
-- ��ѯ���������е�����: select * from ����;
-- ��ѯ����ָ���е�����: select ����,����,... from ����;
-- ȥ�ز�ѯ: select distinct ���� from ����;  ע��: distinctǰ�治�����ֶ���
-- ȡ������ѯ: select ���� as ����,���� as ����,... from ���� as ����;  ע��: as����ʡ��
-- ȡ������ѯ: select ����  ����,���� ����,... from ����  ����;  ע��: as����ʡ��
-- ������ѯ: select ... from ���� where ����;
-- ����: 
-- �Ƚ������: >,>=,<,<=,=,<>(!=)
-- �߼������: and,or,not
-- ģ����ѯ:  like ����;      %:��ʾƥ��������ַ�, _��ʾƥ��һ���ַ�    eg: '%��%','��%','��__',...
-- ��Χ��ѯ:  between ... and ...
-- ��Χ��ѯ:  in(ֵ1,ֵ2,ֵ3,...)
-- �������ѯ: select ������(+-*/) from ����

-- ��ϰ:��ѯproduct�������е�����
select * from product;
-- ��ϰ:��ѯpid,pname,price���е�����
select pid,pname,price from product;
-- ��ϰ:ȥ�ز�ѯ��Ʒ�۸�
select distinct price from product;
select pname,distinct price from product;-- ����,distinctǰ�治�����ֶ���
-- ��ϰ:��ѯpid,pname,price���е����ݲ�����ȡ����
select pid as ���,pname as ��Ʒ����,price as ��Ʒ�۸� from product as p;
select pid  ���,pname  ��Ʒ����,price  ��Ʒ�۸� from product  p;
-- ��ϰ:��ѯ�۸����5000����Ʒ��Ϣ
select * from product where price > 5000;
-- ��ϰ:��ѯ�۸����5000����Ʒ������������10����Ʒ��Ϣ
select * from product where price > 5000 and num > 10;
select * from product where not(price > 5000);
-- ��ϰ: ��ѯ��Ʒ���ƺ���'iPh'����Ʒ��Ϣ
select * from product where pname like '%iPh%';
-- ��ϰ:��ѯ��Ʒ�۸���3000��8000֮�����Ʒ��Ϣ,����3000,8000
select * from product where price between 3000 and 8000;
select * from product where price >= 3000 and price <= 8000;
-- ��ϰ:��ѯpidΪ1,3,5,7,9,19����Ʒ��Ϣ
select * from product where pid = 1 or pid = 3 or pid = 5 or pid = 7 or pid = 9 or pid = 19;
select * from product where pid in(1,3,5,7,9,19);
-- ��ϰ: ��ѯÿ����Ʒ��Ҫ���ܼ�
select pname ��Ʒ����,price*num �ܼ� from product;

-- ������ѯ��ϰ
-- - ��ѯ��Ʒ�۸�>3000����Ʒ
select * from product where price > 3000;

-- - ��ѯid=1����Ʒ
select * from product where pid = 1;

-- - ��ѯid<>1����Ʒ
select * from product where pid <> 1;

-- - ��ѯ�۸���3000��6000֮�����Ʒ
select * from product where price between 3000 and 6000;

-- - ��ѯid��1��5��7��15��Χ�ڵ���Ʒ
select * from product where pid in(1,5,7,15);

-- - ��ѯ��Ʒ����iPho��ͷ����Ʒ(iPhoneϵ��) 
select * from product where pname like 'iPho%';

-- - ��ѯ��Ʒ�۸����3000������������20����Ʒ   (���� and ���� and...)
select * from product where price > 3000 and num > 20;

-- - ��ѯid=1���߼۸�С��3000����Ʒ 
select * from product where pid = 1 or price < 3000;

-- ----------------------------------------�����ѯ---------------------------------------------
# ����ѧ����(��sid,ѧ������,ѧ���Ա�,ѧ������,������,����sidΪ�����Զ�����)
CREATE TABLE student(
	sid INT PRIMARY KEY auto_increment,
	sname VARCHAR(40),
	sex VARCHAR(10),
	age INT,
  score DOUBLE
);

INSERT INTO student VALUES(null,'zs','��',18,98.5);
INSERT INTO student VALUES(null,'ls','Ů',18,96.5);
INSERT INTO student VALUES(null,'ww','��',15,50.5);
INSERT INTO student VALUES(null,'zl','Ů',20,98.5);
INSERT INTO student VALUES(null,'tq','��',18,60.5);
INSERT INTO student VALUES(null,'wb','��',38,98.5);
INSERT INTO student VALUES(null,'С��','��',18,100);
INSERT INTO student VALUES(null,'С��','Ů',28,28);
INSERT INTO student VALUES(null,'Сǿ','��',21,95);

-- �����ѯ: �Բ�ѯ�����������,�����޸ı��е�����
-- ���ֶ��﷨: select ... from ���� [where ����] [order by �ֶ��� asc|desc];  asc:����,��дĬ�Ͼ���asc; desc:����;
-- ���ֶ��﷨: select ... from ���� [where ����] [order by �ֶ��� asc|desc,�ֶ��� asc|desc,...]; 
-- 1. ��ϰ: �Է��������ѯ���е�ѧ��
select * from student order by score desc;

-- 2. ��ϰ: �Է��������ѯ���е�ѧ��, �������һ��,����age����
select * from student order by score desc,age desc;


-- ----------------------------------------�ۺϺ�����ѯ---------------------------------------------
-- �﷨: select �ۺϺ���(����) from ���� [where ����];
-- ��ϰ:���ѧ�����������߷���
select max(score) from student;

-- ��ϰ:���ѧ�����������ͷ���
select min(score) from student;

-- ��ϰ:���ѧ��������ķ������ܺ�
select sum(score) from student;-- 726

-- ��ϰ:���ѧ���������ƽ����
select avg(score) from student;-- 726/9 = 80.666...7

-- ��ϰ:ͳ��ѧ���������� 
select count(*) from student; -- 9

-- �����С��ķ�����Ϊnull
update student set score = null where sname = 'С��';
-- ��ϰ:ͳ��ѧ���������� 
select count(score) from student; -- 8
-- ����: �ۺϺ��������nullֵ
-- ���: ʹ��ifnull(����1,����2)����,�������1��ֵΪnull,��ȡ����2��ֵ��Ϊ���,�������1��ֵ��Ϊnull,�Ǿ�ȡ����1��ֵ��Ϊ���
-- ��ϰ:���ѧ��������ķ������ܺ�
select sum(score) from student;-- 698
-- ��ϰ:���ѧ���������ƽ����
select avg(score) from student;-- 698/8 = 87.25 -----�������, ��ʵ��Ӧ����: 698/9=77.555....6
select avg(ifnull(score,0)) from student;-- 698/9=77.555....6


-- ----------------------------------------�����ѯ---------------------------------------------
-- �﷨: SELECT ... FROM ����  [where ����] group by ���� [having ����];
-- 1. ��ϰ:�����Ա����,ͳ����������������Ů����������
select * from student group by sex; 
-- �������ֻ�Ƿ����ѯ,û���κ�����,��Ϊֻ�᷵��ÿһ��ĵ�һ����¼
-- �����Ŀ����Ϊ��ͳ�Ƽ���,���Է���һ���;ۺϺ���һ��ʹ��
select count(*) from student group by sex; -- �õ��Ľ���޷�ʶ������һ��Ľ��
-- �����ѯһ�㶼���ѯ�������ֶε�ֵ,�����޷�ʶ������������һ���
select sex,count(*) from student group by sex;


-- 2. ��ϰ�����Ա����, ͳ��ÿһ��ѧ����������> 5��(�����ɸѡ)
select sex,count(*) from student group by sex having count(*) > 5;




-- ----------------------------------------��ҳ��ѯ---------------------------------------------
-- select ... from ���� limit a,b; 
-- a:�����￪ʼ��ѯ, ��0��ʼ����,ʡ��a��д,Ĭ�Ͼ��Ǵ�0��ʼ
-- b:��ѯ���������̶���,�Զ���ġ�

-- ��ϰ: ��ѯsidΪ1��4--->��1ҳ
select * from student limit 0,4;

-- ��ϰ: ��ѯsidΪ5��8--->��2ҳ
select * from student limit 4,4;

-- ��ϰ: ��ѯsidΪ9��12--->��3ҳ
select * from student limit 8,4;
select * from student limit 12,4;-- ��4ҳ
select * from student limit 16,4;-- ��5ҳ
select * from student limit 20,4;-- ��6ҳ
-- ...
-- ��ҳ��ѯ�Ĺ���: limit (ҳ��-1)*ÿҳ��ʾ��������,ÿҳ��ʾ��������








