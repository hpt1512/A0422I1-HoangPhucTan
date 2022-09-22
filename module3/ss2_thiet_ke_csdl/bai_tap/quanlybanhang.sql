create database quanlybanhang;
use quanlybanhang;

create table customer (
	c_id int auto_increment,
    c_name varchar(45),
    c_age int,
    primary key(c_id)
);

create table product (
	p_id int auto_increment,
    p_name varchar(45),
    p_price int,
    primary key(p_id)
);

create table `order` (
	o_id int auto_increment,
    c_id int,
    o_date date,
    o_total_price int,
    primary key(o_id)
);
-- sét khoá ngoại 
alter table `order` 
	add constraint fk_customer_order foreign key (c_id) references customer(c_id)
		on update
			cascade
        on delete
			cascade;

create table order_detail (
	o_id int,
    p_id int,
    od_qty varchar(45),
    primary key(o_id, p_id)
);
-- sét khoá ngoại 
alter table order_detail 
	add constraint fk_order_order_detail foreign key (o_id) references `order`(o_id)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_product_order_detail foreign key (p_id) references product(p_id)
		on update
			cascade
        on delete
			cascade;