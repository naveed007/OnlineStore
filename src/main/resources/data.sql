insert into customer (id, name, password) values ('naveedakhtar019@gmail.com','naveed', '1234');
insert into customer (id, name, password) values ('test@test.com','test', '1234');

insert into category(id, name, tax) values (1, 'A', 10);
insert into category(id, name, tax) values (2, 'B', 20);
insert into category(id, name, tax) values (3, 'C', 0);

insert into product(id, name, rate, cat_id) values (1, 'shirt', 450, 1);
insert into product(id, name, rate, cat_id) values (2, 'watch', 200, 2);
insert into product(id, name, rate, cat_id) values (3, 'apple', 100, 3);

insert into cust_order(cust_id, prod_id, qty, is_billed) values ('naveedakhtar019@gmail.com', 1, 2, 'N');