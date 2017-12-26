

/*==============================================================*/
/* Table: APP_USER                                              */
/*==============================================================*/
create table APP_USER
(
   ID                   bigint(20) not null auto_increment comment '主键ID',
   UNIQUE_ID            varchar(64) not null comment '用户唯一id',
   ACCOUNT              varchar(64) null comment '账号',
   EMAIL                varchar(128) null comment '邮箱',
   MOBILE               varchar(128) null comment '移动电话',
   PIN                  varchar(128) null comment '身份证号码',
   ICON_FILE_ID         varchar(64) null comment '头像文件id',
   OPEN_ID              varchar(128) null comment '开放用户ID',
   PASSWORD1            varchar(128) not null comment '密码',
   PASSWORD2            varchar(128) not null comment '旧密码',
   NICK_NAME            varchar(64) null comment '昵称',
   STATUS               int not null default 1 comment '状态(0=注销,1=帐户正常, 2=下次登录时需修改密码, 4=用户不得更改密码, 8=密码永久有效, 9=未激活,16=帐户已锁定)',
   CREATOR              bigint(20) null comment '创建人',
   CREATION_DATE        timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   MODIFIER             bigint(20) null comment '修改人',
   MODIFICATION_DATE    timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   VSERSION             int not null default 1 comment '版本',
   primary key (ID),
   unique key UNQ_APP_USER_USERNAME (ACCOUNT),
   unique key UNQ_APP_USER_MOBILE (MOBILE),
   unique key UNQ_APP_USER_PIN (PIN),
   unique key UNQ_APP_USER_OPEN_ID (OPEN_ID)
)
auto_increment = 10000;

alter table APP_USER comment 'app用户表';


/*==============================================================*/
/* Table: APP_USER_BY_ACCOUNT                                   */
/*==============================================================*/
create table APP_USER_BY_ACCOUNT
(
   ACCOUNT              varchar(50) not null,
   USER_ID              bigint(20) not null,
   primary key (ACCOUNT)
);

alter table APP_USER_BY_ACCOUNT comment '根据账号搜索用户';


/*==============================================================*/
/* Table: APP_USER_BY_EMAIL                                     */
/*==============================================================*/
create table APP_USER_BY_EMAIL
(
   EMAIL                varchar(128) not null,
   USER_ID              bigint(20) not null,
   primary key (EMAIL)
);

alter table APP_USER_BY_EMAIL comment '用户账号搜索BY_email';


/*==============================================================*/
/* Table: APP_USER_BY_MOBILE                                    */
/*==============================================================*/
create table APP_USER_BY_MOBILE
(
   MOBILE               varchar(128) not null,
   USER_ID              bigint(20) not null,
   primary key (MOBILE)
);

alter table APP_USER_BY_MOBILE comment '用户账号搜索BY_mobile';


/*==============================================================*/
/* Table: APP_USER_CONFIG                                       */
/*==============================================================*/
create table APP_USER_CONFIG
(
   USER_ID              varchar(64) not null comment '用户ID',
   CREATOR_ORG_LIMIT    int not null default 3 comment '可以创建组织个数',
   ADD_ORG_LIMIT        int not null default 2 comment '可以添加组织个数',
   BACKGROUND_IMAGE     varchar(256) null comment '用户背景图片',
   primary key (USER_ID)
);

alter table APP_USER_CONFIG comment '用户配置表';


