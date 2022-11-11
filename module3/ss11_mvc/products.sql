create database product_management;
use product_management;

create table products (
	id int auto_increment,
    `name` varchar(45) not null,
    price int not null,
    `description` varchar(100) not null,
    producer varchar(45) not null,
    primary key(id)
);

insert into products (`name`, price, `description`, producer)
	values 	("Samsung", 1000000, "Mo ta Samsung", "SS Producer"),
			("Nokia", 2000000, "Mo ta Nokia", "NKA Producer"),
			("Lenovo", 3000000, "Mo ta Lenovo", "LNV Producer"),
			("Dell", 4000000, "Mo ta Dell", "D Producer"),
			("Asus", 5000000, "Mo ta Asus", "A Producer");
insert into products (`name`, price, `description`, producer)
	values 	("Iphone", 6000000, "Mo ta Iphone", "IP Producer");
            
select * from products;
select id, `name`, price, `description`, producer from products where id = 1;


DELIMITER $$
CREATE PROCEDURE find_product_by_name(IN product_name varchar(50))
BEGIN
    select * from products
    where name like concat('%', product_name, '%');
END$$
DELIMITER ;

call find_product_by_name('no');