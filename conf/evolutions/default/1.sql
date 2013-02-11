# Customer, Product schema

# -- !Ups

create table T_CUSTOMER (
  ID bigint not null auto_increment,
  NAME varchar(255) not null,
  ADDRESS varchar(255),
  primary key (ID)
);

create table T_PRODUCT (
  ID bigint not null auto_increment,
  NAME varchar(255) not null,
  PRICE integer not null,
  primary key (ID)
);

create table T_ORDER (
  ID bigint not null auto_increment,
  ORDER_DATE date not null,
  CUSTOMER_ID bigint not null,
  primary key (ID),
  foreign key (CUSTOMER_ID) references T_CUSTOMER (ID)
);

create table T_ORDER_DETAIL (
  ID bigint not null auto_increment,
  ORDER_ID bigint not null,
  PRODUCT_ID bigint not null,
  QUANTITY integer not null,
  primary key (ID),
  foreign key (ORDER_ID) references T_ORDER (ID),
  foreign key (PRODUCT_ID) references T_PRODUCT (ID)
);

create index IX_ORDER_DETAIL on T_ORDER_DETAIL (ORDER_ID);

# -- !Downs

drop index IX_ORDER_DETAIL;

drop table T_ORDER_DETAIL;
drop table T_ORDER;
drop table T_PRODUCT;
drop table T_CUSTOMER;
