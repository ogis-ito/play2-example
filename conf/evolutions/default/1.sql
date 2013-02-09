# Customer, Product schema

# -- !Ups

create table T_CUSTOMER (
  ID bigint primary key not null auto_increment,
  NAME varchar(255) not null,
  ADDRESS varchar(255)
);

create table T_PRODUCT (
  ID bigint primary key not null auto_increment,
  NAME varchar(255) not null,
  PRICE integer not null
);

# -- !Downs

drop table T_PRODUCT;
drop table T_CUSTOMER;
