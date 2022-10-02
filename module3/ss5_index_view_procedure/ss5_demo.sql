create database demo;
use demo;

create table products (
	id int,
    product_code varchar(10)  not null,
    product_name varchar(45) not null,
    product_price int not null,
    product_amount int not null,
    product_description varchar(100),
    product_status varchar(10),
    primary key(id)
);

insert into products 
	values (1, 'IP11', 'Iphone 11', 100000, 2, null, '99%');
insert into products 
	values (2, 'IP11PRM', 'Iphone 11 Pro Max', 12000000, 5, null, '99%');
insert into products 
	values (3, 'SS10', 'Samsung Note 10', 11000000, 3, null, '100%');
insert into products 
	values (4, 'IP12', 'Iphone 12', 15000000, 2, null, '99%');
insert into products 
	values (5, 'IPXSM', 'Iphone XS Max', 9000000, 6, null, '99%');
    
select * from products;

-- 1, Tạo index
create index i_productCode on products(product_code);
create index i_productNamePrice on products(product_name, product_price);
explain select * from products where product_code = 'IP12';
-- alter table products drop index i_productCode;

-- 2. Tạo view
create view w_productInfo as
	select product_code, product_name, product_price, product_status
    from products;
select * from w_productInfo;
-- drop view w_productInfo;
update w_productInfo set product_name = 'Iphone 11 Black'
where product_code = 'IP11';

-- 3. Tạo procedure
-- -- Lấy thông tin sản phẩm
delimiter //
create procedure get_all_product()
begin 
select * from products;
end //
delimiter ;

call get_all_product();

-- -- Thêm 1 sản phẩm mới
delimiter //
create procedure add_new_product(new_id int, new_code varchar(10), new_name varchar(45), 
		new_price int, new_amount int, new_description varchar(100), new_status varchar(10))
begin 
insert into products value (new_id, new_code, new_name, new_price, new_amount, new_description, new_status);
end //
delimiter ;

call add_new_product(6, 'IP12PRM', 'Iphone 12 Pro Max', 16000000, 5, null, '99%');

-- -- Sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product(in id_udt int, new_name varchar(45))
begin 
update products set product_name = new_name where id = id_udt;
end //
delimiter ;

call update_product(6, 'Iphone 12 Pro Max Gold');

-- -- Xoá sản phẩm theo id
delimiter //
create procedure delete_product(in id_del int)
begin 
delete from products where id = id_del;
end //
delimiter ;

call delete_product(6);





