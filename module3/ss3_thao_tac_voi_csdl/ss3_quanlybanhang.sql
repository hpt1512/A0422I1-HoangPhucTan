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

-- Insert values
insert into Customer 
	values 	(1, "Minh Quan", 10),
			(2, "Ngoc Oanh", 20),
			(3, "Hong Ha", 50);

insert into  `order`
	values 	(5, 1, '2020-01-01', null);
    
    INSERT INTO `quanlybanhang`.`order` (`o_id`, `c_id`, `o_date`) VALUES ('4', '1', '2020-01-01');
select * from `order`;

insert into product 
	values 	(1, "May Giat", 3),
			(2, "Tu Lanh", 5),
			(3, "Dieu Hoa", 7),
			(4, "Quat", 1),
			(5, "Bep Dien", 2);

insert into order_detail 
	values 	(1, 1, 3),
			(1, 3, 7),
			(1, 4, 2),
			(2, 1, 1),
			(3, 1, 8),
			(2, 5, 4),
			(2, 3, 3);
			