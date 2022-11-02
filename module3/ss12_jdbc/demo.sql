CREATE DATABASE `demo`;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE show_list_users()
BEGIN
    SELECT * FROM users;
END$$
DELIMITER ;

call show_list_users();

DELIMITER $$
CREATE PROCEDURE delete_user_by_id(IN user_id INT)
BEGIN
    DELETE FROM users WHERE id = user_id;
END$$
DELIMITER ;

call delete_user_by_id(6);

DELIMITER $$
CREATE PROCEDURE update_user_by_id(
IN user_id INT,
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    update users 
    set name = user_name, email = user_email, country = user_country 
    where id = user_id;
END$$
DELIMITER ;

call update_user_by_id (5, 'Kante3', 'kante3@gmail.com', 'France');

select * from users;

