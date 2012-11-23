# Customers, Product schema

# -- !Ups

create sequence CUSTOMER_ID_SEQ;
create sequence PRODUCT_ID_SEQ;

create table CUSTOMER (
  ID integer not null default nextval('CUSTOMER_ID_SEQ'),
  NAME varchar(255) not null,
  ADDRESS varchar(255)
);

create table PRODUCT (
  ID integer not null default nextval('PRODUCT_ID_SEQ'),
  NAME varchar(255) not null,
  PRICE integer not null
);

# -- !Downs

drop table PRODUCT;
drop table CUSTOMER;

drop sequence PRODUCT_ID_SEQ;
drop sequence CUSTOMER_ID_SEQ;
