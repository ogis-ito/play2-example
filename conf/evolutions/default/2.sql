# Order schema

# -- !Ups

create table T_ORDER (
  ID bigint not null auto_increment primary key,
  ORDER_DATE date not null,
  CUSTOMER_ID bigint not null
);

create table T_ORDER_DETAIL (
  ID bigint not null auto_increment primary key,
  ORDER_ID bigint not null,
  PRODUCT_ID bigint not null,
  QUANTITY integer not null
);

# -- !Downs

drop table T_ORDER_DETAIL;
drop table T_ORDER;
