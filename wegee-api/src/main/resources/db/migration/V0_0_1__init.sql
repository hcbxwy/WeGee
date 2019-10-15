/*==============================================================*/
/* Table: wg_user                                               */
/*==============================================================*/
create table wg_user
(
   id                   bigint not null auto_increment comment '主键',
   nickname             varchar(50) not null comment '昵称',
   avatar_url           varchar(255) comment '头像',
   gender               tinyint unsigned default 2 comment '性别：0 女，1 男，2 不详',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table wg_user comment '用户表';

/*==============================================================*/
/* Table: wg_user_account                                       */
/*==============================================================*/
create table wg_user_account
(
   id                   bigint not null auto_increment comment '主键',
   user_id              bigint not null comment '用户ID',
   account_type         tinyint unsigned default 0 comment '账号类型：0  默认，1  微信，2  微博，3  QQ',
   account              varchar(50) not null comment '账号',
   salt                 varchar(8) comment '密码盐',
   password             varchar(512) comment '密码',
   expired              int unsigned comment '有效期（秒）',
   status               tinyint unsigned default 0 comment '状态：0 正常，1 未认证，2 已过期，3 已冻结，4 已作废',
   union_id             varchar(32) comment '联合ID（主要是微信和QQ）',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table wg_user_account comment '用户账号表';

/*==============================================================*/
/* Index: uk_account                                            */
/*==============================================================*/
create unique index uk_account on wg_user_account
(
   account
);
