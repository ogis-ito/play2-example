# Order schema

# -- !Ups

insert into T_CUSTOMER (ID, NAME, ADDRESS) values (101, '鈴木 一郎', '東京都港区');
insert into T_CUSTOMER (ID, NAME, ADDRESS) values (102, '山田 花子', '東京都渋谷区');

insert into T_PRODUCT (ID, NAME, PRICE) values (201, 'UMLユーザーガイド', 6400);
insert into T_PRODUCT (ID, NAME, PRICE) values (202, 'UML モデリングのエッセンス', 2400);
insert into T_PRODUCT (ID, NAME, PRICE) values (203, 'リアルタイムUML', 3800);
insert into T_PRODUCT (ID, NAME, PRICE) values (204, 'かんたんUML', 1980);
insert into T_PRODUCT (ID, NAME, PRICE) values (205, 'かんたん！エンタープライズ・アーキテクチャ', 1890);
insert into T_PRODUCT (ID, NAME, PRICE) values (206, 'オブジェクト開発の真髄', 4200);
insert into T_PRODUCT (ID, NAME, PRICE) values (207, 'その場で使えるしっかり学べるUML2.0', 2800);
insert into T_PRODUCT (ID, NAME, PRICE) values (208, 'エンタープライズ統一プロセス', 4500);
insert into T_PRODUCT (ID, NAME, PRICE) values (209, '実践！SOAモデリング', 2380);
insert into T_PRODUCT (ID, NAME, PRICE) values (210, 'オブジェクトデザイン', 3800);
insert into T_PRODUCT (ID, NAME, PRICE) values (211, 'ThoughtWorksアンソロジー', 2600);
insert into T_PRODUCT (ID, NAME, PRICE) values (212, '実践ソフトウェア要求ハンドブック', 2800);
insert into T_PRODUCT (ID, NAME, PRICE) values (213, '百年アーキテクチャ', 1500);
insert into T_PRODUCT (ID, NAME, PRICE) values (214, 'プログラミングScala', 3800);
insert into T_PRODUCT (ID, NAME, PRICE) values (215, '実践SysML', 3200);

insert into T_ORDER (ID, ORDER_DATE, CUSTOMER_ID) values (310, '2000-01-12', 101);
insert into T_ORDER_DETAIL (ID, ORDER_ID, PRODUCT_ID, QUANTITY) values (311, 310, 201, 2);
insert into T_ORDER_DETAIL (ID, ORDER_ID, PRODUCT_ID, QUANTITY) values (312, 310, 202, 3);

insert into T_ORDER (ID, ORDER_DATE, CUSTOMER_ID) values (320, '2000-02-23', 102);
insert into T_ORDER_DETAIL (ID, ORDER_ID, PRODUCT_ID, QUANTITY) values (321, 320, 203, 1);

# -- !Downs

delete from T_ORDER_DETAIL;
delete from T_ORDER;
delete from T_PRODUCT;
delete from T_CUSTOMER;
