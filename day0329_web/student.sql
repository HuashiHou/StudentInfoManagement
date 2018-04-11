prompt PL/SQL Developer import file
prompt Created on 2018年4月11日 by Administrator
set feedback off
set define off
prompt Creating STUDENT...
create table STUDENT
(
  S_ID    NUMBER not null,
  S_NAME  VARCHAR2(20),
  S_SEX   VARCHAR2(4),
  S_AGE   NUMBER,
  S_CLASS VARCHAR2(20)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STUDENT
  add primary key (S_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating USRINFO...
create table USRINFO
(
  U_NAME VARCHAR2(50),
  U_PWD  VARCHAR2(50)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for STUDENT...
alter table STUDENT disable all triggers;
prompt Disabling triggers for USRINFO...
alter table USRINFO disable all triggers;
prompt Deleting USRINFO...
delete from USRINFO;
commit;
prompt Deleting STUDENT...
delete from STUDENT;
commit;
prompt Loading STUDENT...
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (7, '小明', '男', 18, '一班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (8, '小红', '女', 19, '一班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (9, '小刚', '男', 20, '二班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (10, '小强', '男', 16, '二班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (11, '2018年', '男', 18, '一班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (12, '3月', '女', 19, '二班');
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (1, '一号选手', '男', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (19, 'bluce', 'man', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (18, 'eric1', '男', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (17, 'lucy', '女', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (2, 'lily', 'f', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (3, 'bruce', 'm', null, null);
insert into STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_CLASS)
values (122, '维持', '男', null, null);
commit;
prompt 13 records loaded
prompt Loading USRINFO...
insert into USRINFO (U_NAME, U_PWD)
values ('root', '123');
commit;
prompt 1 records loaded
prompt Enabling triggers for STUDENT...
alter table STUDENT enable all triggers;
prompt Enabling triggers for USRINFO...
alter table USRINFO enable all triggers;
set feedback on
set define on
prompt Done.
