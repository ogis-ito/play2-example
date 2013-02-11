# Order schema

# -- !Ups

insert into T_CUSTOMER (NAME, ADDRESS) values ('鈴木 一郎', '東京都港区');
insert into T_CUSTOMER (NAME, ADDRESS) values ('山田 花子', '東京都渋谷区');

insert into T_PRODUCT (NAME, PRICE) values ('UMLユーザーガイド', 6400);
insert into T_PRODUCT (NAME, PRICE) values ('UML モデリングのエッセンス', 2400);
insert into T_PRODUCT (NAME, PRICE) values ('リアルタイムUML', 3800);
insert into T_PRODUCT (NAME, PRICE) values ('かんたんUML', 1980);
insert into T_PRODUCT (NAME, PRICE) values ('かんたん！エンタープライズ・アーキテクチャ', 1890);
insert into T_PRODUCT (NAME, PRICE) values ('オブジェクト開発の真髄', 4200);
insert into T_PRODUCT (NAME, PRICE) values ('その場で使えるしっかり学べるUML2.0', 2800);
insert into T_PRODUCT (NAME, PRICE) values ('エンタープライズ統一プロセス', 4500);
insert into T_PRODUCT (NAME, PRICE) values ('実践！SOAモデリング', 2380);
insert into T_PRODUCT (NAME, PRICE) values ('オブジェクトデザイン', 3800);
insert into T_PRODUCT (NAME, PRICE) values ('ThoughtWorksアンソロジー', 2600);
insert into T_PRODUCT (NAME, PRICE) values ('実践ソフトウェア要求ハンドブック', 2800);
insert into T_PRODUCT (NAME, PRICE) values ('百年アーキテクチャ', 1500);
insert into T_PRODUCT (NAME, PRICE) values ('プログラミングScala', 3800);
insert into T_PRODUCT (NAME, PRICE) values ('実践SysML', 3200);

# -- !Downs

delete from T_ORDER_DETAIL;
delete from T_ORDER;
delete from T_PRODUCT;
delete from T_CUSTOMER;
