-- auto-generated definition
CREATE TABLE pay_in_order
(
  pay_in_order_id INT(10) UNSIGNED AUTO_INCREMENT
    PRIMARY KEY,
  uid             INT(10)     NULL,
  oid             VARCHAR(36) NOT NULL
  COMMENT '订单id',
  pay_pay_id      INT(10)     NULL,
  amount          DECIMAL     NOT NULL,
  status          TINYINT     NOT NULL,
  ctime           BIGINT      NOT NULL
)
  COMMENT '收入订单表';

-- auto-generated definition
CREATE TABLE pay_in_order_detail
(
  pay_in_order_detail_id INT(10) UNSIGNED AUTO_INCREMENT
    PRIMARY KEY,
  pay_in_order_id        INT(10)      NULL,
  product_id             VARCHAR(50)  NULL,
  product_name           VARCHAR(100) NULL,
  product_price          DECIMAL      NULL,
  product_count          INT(10)      NULL,
  remark                 VARCHAR(500) NULL
)
  COMMENT '收入订单明细表';

-- auto-generated definition
CREATE TABLE pay_out_order
(
  pay_out_order_id INT(10) UNSIGNED AUTO_INCREMENT
    PRIMARY KEY,
  uid              INT(10) NULL,
  pay_pay_id       INT(10) NULL,
  amount           DECIMAL NOT NULL,
  status           TINYINT NOT NULL,
  ctime            BIGINT  NOT NULL
)
  COMMENT '支出订单表';

-- auto-generated definition
CREATE TABLE pay_out_order_detail
(
  pay_out_order_detail_id INT(10) UNSIGNED AUTO_INCREMENT
    PRIMARY KEY,
  pay_out_order_id        INT(10)      NULL,
  remark                  VARCHAR(500) NULL
)
  COMMENT '支出订单明细表';

-- auto-generated definition
CREATE TABLE pay_pay
(
  pay_pay_id  INT(10) AUTO_INCREMENT
    PRIMARY KEY,
  pay_type_id INT(10)       NULL,
  param       VARCHAR(1000) NULL
)
  COMMENT '支付参数配置表';

-- auto-generated definition
CREATE TABLE platform_device
(
  did            VARCHAR(36)      NOT NULL
  COMMENT '设配id',
  hostname       VARCHAR(36)      NOT NULL
  COMMENT '主机名',
  ip             VARCHAR(36)      NOT NULL
  COMMENT 'ip地址',
  login_password VARCHAR(36)      NOT NULL
  COMMENT '登录密码',
  local_ip       VARCHAR(36)      NOT NULL
  COMMENT '私有ip地址',
  user_id        VARCHAR(36)      NOT NULL
  COMMENT '用户id',
  sys            VARCHAR(36)      NOT NULL
  COMMENT '操作系统',
  disksize       VARCHAR(36)      NOT NULL
  COMMENT '磁盘大小',
  enabled        CHAR DEFAULT '1' NULL
  COMMENT '是否可用
	1：可用
	0：停用',
  hdcapacity_cpu VARCHAR(36)      NULL
  COMMENT '是否可用
	1：可用
	0：停用',
  region         VARCHAR(36)      NULL
  COMMENT '地域',
  start_time     DATETIME         NULL
  COMMENT '开始时间',
  end_time       DATETIME         NULL
  COMMENT '结束时间',
  PRIMARY KEY (did, user_id)
)
  COMMENT '设配';

-- auto-generated definition
CREATE TABLE platform_order
(
  oid        VARCHAR(36)      NOT NULL
  COMMENT '订单id',
  order_num  INT AUTO_INCREMENT,
  user_id    VARCHAR(36)      NOT NULL
  COMMENT '用户id',
  device_id  VARCHAR(36)      NOT NULL
  COMMENT '设配id',
  salary     DECIMAL(10, 2)   NOT NULL
  COMMENT '价格',
  state      CHAR DEFAULT '0' NULL
  COMMENT '是否结清,0 未付款,1 已取消,3 已结清',
  start_time DATETIME         NULL
  COMMENT '开始时间',
  end_time   DATETIME         NULL
  COMMENT '结束时间',
  PRIMARY KEY (oid, user_id, device_id),
  KEY(order_num)
)
  COMMENT '订单';
CREATE INDEX order_num
  ON platform_order (order_num);


-- auto-generated definition
CREATE TABLE platform_role
(
  role_id   VARCHAR(36) NOT NULL
  COMMENT '角色ID'
    PRIMARY KEY,
  role_name VARCHAR(36) NOT NULL
  COMMENT '角色'
)
  COMMENT '角色';

-- auto-generated definition
CREATE TABLE platform_user
(
  uid         VARCHAR(36)                         NOT NULL
  COMMENT '编号'
    PRIMARY KEY,
  login_name  VARCHAR(100)                        NOT NULL
  COMMENT '登录名',
  password    VARCHAR(100)                        NOT NULL
  COMMENT '密码',
  salt        VARCHAR(36)                         NOT NULL
  COMMENT '密码盐',
  nickname    VARCHAR(255)                        NULL
  COMMENT '昵称',
  sex         CHAR                                NULL
  COMMENT '性别
	0：未知
	1：男
	2：女',
  name        VARCHAR(100)                        NOT NULL
  COMMENT '姓名',
  email       VARCHAR(200)                        NULL
  COMMENT '邮件',
  mobile      VARCHAR(200)                        NULL
  COMMENT '手机',
  enabled     CHAR DEFAULT '1'                    NULL
  COMMENT '是否可用
	1：可用
	0：停用',
  remarks     VARCHAR(255)                        NULL
  COMMENT '备注',
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL
  COMMENT '更新时间',
  last_ip     VARCHAR(100)                        NULL
  COMMENT '最后登录ip',
  del_flag    CHAR DEFAULT '0'                    NULL
  COMMENT '删除标记
	1：删除
	0：未删除',
  CONSTRAINT login_name_UNIQUE
  UNIQUE (login_name)
)
  COMMENT '系统用户';

-- auto-generated definition
CREATE TABLE platform_user_role
(
  user_id VARCHAR(36) NOT NULL
  COMMENT '用户ID',
  role_id VARCHAR(36) NOT NULL
  COMMENT '角色ID',
  PRIMARY KEY (user_id, role_id)
)
  COMMENT '用户角色';