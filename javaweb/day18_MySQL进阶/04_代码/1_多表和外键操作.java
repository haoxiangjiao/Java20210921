-- --------------------------------ΪʲôҪ�ж��----------------------------------------------------------
CREATE TABLE emp (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	age INT,
	dep_name VARCHAR(30),
	dep_location VARCHAR(30)
);

-- �������
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '�з���', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 21, '�з���', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '�з���', '����');

INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '���۲�', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 22, '���۲�', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('С��', 18, '���۲�', '����');


-- ���:
-- �������ű�
CREATE TABLE department (
	id INT PRIMARY KEY AUTO_INCREMENT,
	dep_name VARCHAR(20),
	dep_location VARCHAR(20)
);

-- ����Ա����
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT
);

-- ���2������
INSERT INTO department (dep_name, dep_location) VALUES ('�з���', '����');
INSERT INTO department (dep_name, dep_location) VALUES('���۲�', '����');

-- ���Ա��,dep_id��ʾԱ�����ڵĲ���
INSERT INTO employee (NAME, age, dep_id) VALUES 
('����', 20, 1), 
('����', 21, 1), 
('����', 20, 1), 
('����', 20, 2),
('����', 22, 2),
('С��', 18, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 20, 6);


-- -------------------------------------------------------������-----------------------------------
-- �﷨: constraint ����� foreign key(����ֶ���) references ������(����);
-- Ϊ���б�������: alter table ���� add constraint ����� foreign key(����ֶ���) references ������(����);
alter table employee add constraint emp_dep_fk1 foreign key(dep_id) references department(id);
-- �������֮��,��ӷǷ�����,��ʧ��
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 20, 6);-- ����

-- �������ʱ��������
create table ����(
	�ֶ� �ֶ����� �ֶ�Լ��,
	�ֶ� �ֶ����� �ֶ�Լ��,
	...
	constraint ����� foreign key(����ֶ���) references ������(����)
);
-- ����Ա����
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT,
	constraint emp_dep_fk1 foreign key(dep_id) references department(id)
);

-- -------------------------------------------------------ɾ�����-----------------------------------
-- �﷨:alter table ���� drop foreign key �����;
alter table employee drop foreign key emp_dep_fk1;


-- -------------------------------------------------------����������ºͼ���ɾ��-----------------------------------
-- ��������: ������������ֵ�����˸ı�,�ӱ��е�����ͻ���Ÿı�---> on update cascade
-- ����ɾ��: ������������ֵ��ɾ����,�ӱ��������ֵҲ�����ɾ��---> on delete cascade
-- û����������������ºͼ���ɾ��
-- ����1: �޸����۲���idΪ5----��ʧ��
update department set id = 5 where id = 2;
-- ����2: ɾ��idΪ1���з���----��ʧ��
delete from department where id = 1;

-- ��������������ºͼ���ɾ��
alter table employee add constraint emp_dep_fk1 foreign key(dep_id) references department(id) on update cascade on delete cascade;
-- ����1: �޸����۲���idΪ5----��ɹ�
update department set id = 5 where id = 2;
-- ����2: ɾ��idΪ1���з���----��ɹ�
delete from department where id = 1;


-- -------------------------------------------------------�������ϰ-----------------------------------
create table class(
 id int primary key auto_increment,
 name varchar(40)  
);

create table student(
 id int primary key auto_increment,
 name varchar(40),
 c_id int,
 constraint stu_cls_fk1 foreign key(c_id) references class(id)
);

create table course(
 id int primary key auto_increment,
 name varchar(40)  
);

create table stu_cou(
	sno int,
    cno int,
    constraint stu_cou_fk1 foreign key(cno) references course(id),
    constraint stu_cou_fk2 foreign key(sno) references student(id)
);

