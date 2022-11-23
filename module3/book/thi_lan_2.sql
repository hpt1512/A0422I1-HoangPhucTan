create database motel_room;
use motel_room;

create table pay_type (
	id int auto_increment,
    `name` varchar(45) not null,
    primary key(id)
);

create table room (
	id int auto_increment,
    username varchar(50) not null,
    phone_number varchar(20) not null,
    date_start date not null,
    id_pay int not null,
    note nvarchar(200),
    primary key(id)
);

-- set khoá ngoại bảng room
alter table room 
	add constraint fk_room_pay foreign key (id_pay) references pay_type(id)
		on update
			cascade
        on delete
			cascade;
            
insert into pay_type (name)
values ('Theo tháng'),
	('Theo quý'),
	('Theo năm');
    
insert into room (username, phone_number, date_start, id_pay, note)
values ('Hoang Phuc Tan', '0123456789', '2022-12-12', 1, 'ghi chu 1'),
    ('Hoang Phuc A', '0147852963', '2022-12-15', 2, 'ghi chu 2');
    
insert into room (username, phone_number, date_start, id_pay, note)
values ('Hoang Ngoc Minh', '0258753169', '2022-12-16', 3, 'ghi chu 3');


select * from room where id like concat('%', ?, '%') and username like concat('%', ?, '%') 
and phone_number like concat('%', ?, '%');
    