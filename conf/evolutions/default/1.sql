# Customers, Product schema

# -- !Ups

create table CUSTOMER (
  ID bigint primary key not null auto_increment,
  NAME varchar(255) not null,
  ADDRESS varchar(255)
);

create table PRODUCT (
  ID bigint primary key not null auto_increment,
  NAME varchar(255) not null,
  PRICE integer not null
);

# -- !Downs

drop table PRODUCT;
drop table CUSTOMER;
