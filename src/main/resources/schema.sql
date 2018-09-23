create table customer (
id varchar(255) not null unique,
name varchar(255) not null ,
password varchar(255) not null ,
primary key(id)
);

create table category (
id integer not null unique,
name varchar(255) not null ,
tax decimal not null ,
primary key(id)
);

create table product (
id integer not null unique,
name varchar(255) not null ,
rate decimal not null ,
cat_id integer , foreign key (cat_id)  REFERENCES category(id),
primary key(id)
);

create table cust_order (
cust_id varchar(255) , foreign key (cust_id) REFERENCES customer(id),
prod_id integer , foreign key (prod_id) REFERENCES product (id),
qty integer not null,
is_billed char(1) not NULL default 'N'
);