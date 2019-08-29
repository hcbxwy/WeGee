drop table if exists sys_account;

/*==============================================================*/
/* Table: sys_account                                           */
/*==============================================================*/
create table sys_account
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint not null comment '用户id',
   account              varchar(50) not null comment '登录账号',
   pwd                  char(32) not null comment '密码',
   salt                 char(8) not null comment '密码盐',
   account_type         varchar(20) not null comment '账号类型',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   create_by            varchar(50) comment '创建人',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   update_by            varchar(50) comment '修改人',
   primary key (id)
);

alter table sys_account comment '账号表';

/*==============================================================*/
/* Index: uk_account                                            */
/*==============================================================*/
create index uk_account on sys_account
(
   account
);

/*==============================================================*/
/* Index: idx_account_pwd                                       */
/*==============================================================*/
create index idx_account_pwd on sys_account
(
   account,
   pwd
);
