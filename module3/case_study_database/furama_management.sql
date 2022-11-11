-- PHẦN 1: TẠO CSDL
create database furama_management;
use furama_management;

create table vi_tri (
	ma_vi_tri int auto_increment,
    ten_vi_tri varchar(45) not null,
    primary key(ma_vi_tri)
);

create table trinh_do (
	ma_trinh_do int auto_increment,
    ten_trinh_do varchar(45) not null,
    primary key(ma_trinh_do)
);

create table bo_phan (
	ma_bo_phan int auto_increment,
    ten_bo_phan varchar(45) not null,
    primary key(ma_bo_phan)
);

create table nhan_vien (
	ma_nhan_vien int auto_increment,
    ho_ten varchar(45) not null,
    ngay_sinh date,
    so_cmnd varchar(45),
    luong double,
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    primary key(ma_nhan_vien)
);
-- set khoá ngoại bảng nhan_vien
alter table nhan_vien 
	add constraint fk_nhanvien_vitri foreign key (ma_vi_tri) references vi_tri(ma_vi_tri)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_nhanvien_trinhdo foreign key (ma_trinh_do) references trinh_do(ma_trinh_do)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_nhanvien_bophan foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
		on update
			cascade
        on delete
			cascade;

create table loai_khach (
	ma_loai_khach int auto_increment,
    ten_loai_khach varchar(45) not null,
    primary key(ma_loai_khach)
);

create table khach_hang (
	ma_khach_hang int auto_increment,
    ma_loai_khach int,
    ho_ten varchar(45) not null,
    ngay_sinh date,
    gioi_tinh bit(1),
    so_cmnd varchar(45),
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    primary key(ma_khach_hang)
);

-- set khoá ngoại bảng khach_hang
alter table khach_hang 
	add constraint fk_khachhang_loaikhach foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
		on update
			cascade
        on delete
			cascade;

create table kieu_thue (
	ma_kieu_thue int auto_increment,
    ten_kieu_thue varchar(45) not null,
    primary key(ma_kieu_thue)
);

create table loai_dich_vu (
	ma_loai_dich_vu int auto_increment,
    ten_loai_dich_vu varchar(45) not null,
    primary key(ma_loai_dich_vu)
);

create table dich_vu (
	ma_dich_vu int auto_increment,
    ten_dich_vu varchar(45) not null,
    dien_tich int,
    chi_phi_thue double,
    so_nguoi_toi_da int,
    ma_kieu_thue int,
    ma_loai_dich_vu int,
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    primary key(ma_dich_vu)
);
-- set khoá ngoại bảng dich_vu
alter table dich_vu 
	add constraint fk_dichvu_kieuthue foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_dichvu_loaidichvu foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
		on update
			cascade
        on delete
			cascade;

create table hop_dong (
	ma_hop_dong int auto_increment,
    ngay_lam_hop_dong datetime not null,
    ngay_ket_thuc datetime not null,
    tien_dat_coc double not null,
    ma_nhan_vien int,
    ma_khach_hang int,
    ma_dich_vu int,
    primary key(ma_hop_dong)
);
-- set khoá ngoại bảng hop_dong
alter table hop_dong 
	add constraint fk_hopdong_nhanvien foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_hopdong_khachhang foreign key (ma_khach_hang) references khach_hang(ma_khach_hang)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_hopdong_dichvu foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
		on update
			cascade
        on delete
			cascade;

create table dich_vu_di_kem (
	ma_dich_vu_di_kem int auto_increment,
	ten_dich_vu_di_kem varchar(45) not null,
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45),
    primary key(ma_dich_vu_di_kem)
);

create table hop_dong_chi_tiet (
	ma_hop_dong_chi_tiet int auto_increment,
    ma_hop_dong int,
    ma_dich_vu_di_kem int,
    so_luong int,
    primary key(ma_hop_dong_chi_tiet)
);
-- set khoá ngoại bảng hop_dong_chi_tiet
alter table hop_dong_chi_tiet 
	add constraint fk_hopdongchitiet_hopdong foreign key (ma_hop_dong) references hop_dong(ma_hop_dong)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_hopdongchitiet_dichvudikem foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
		on update
			cascade
        on delete
			cascade;
            
-- PHẦN 2: TRUY VẤN SQL CƠ BẢN
-- 1. Thêm dữ liệu.
insert into vi_tri (ten_vi_tri)
	values 	('Quản lý'),
			('Nhân viên');
insert into trinh_do (ten_trinh_do)
	values 	('Trung cấp'),
			('Cao đẳng'),
			('Đại học'),
			('Sau đại học');
insert into bo_phan (ten_bo_phan)
	values 	("Sale & Marketing"),
			("Hành Chính"),
			("Phục Vụ"),
			("Quản Lý");
insert into nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
	values 	("Nguyễn Văn An", '1970-11-07', '456231786', 10000000, '0889152558', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
			("Lê Văn Bình", '1997-04-09', '654231234', 7000000, '0123456789', 'binhvl@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
            ("Hồ Thị Yến", '1995-12-12', '999231723', 14000000, '0213485697', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
            ("Võ Công Toản", '1980-04-04', '123231365', 17000000, '0213485697', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
            ("Nguyễn Bỉnh Phát", '1999-12-09', '454363232', 6000000, '0147852369', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
            ("Khúc Nguyễn An Nghi", '2000-11-08', '964542311', 7000000, '0987654321', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
            ("Nguyễn Hữu Hà", '1993-01-01', '534323231', 8000000, '0987654321', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
            ("Nguyễn Hữu Hà", '1993-01-01', '534323231', 8000000, '0987654321', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
            ("Nguyễn Hà Đông", '1989-09-03', '234414123', 9000000, '0987654321', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
            ("Tòng Hoang", '1982-09-03', '256781231', 6000000, '0987654321', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
            ("Nguyễn Công Đạo", '1994-01-08', '755434343', 8000000, '0987654321', 'nguyencongdao@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);

select * from nhan_vien;        

insert into loai_khach (ten_loai_khach)
	values 	('Diamond'),
			('Platinium'),
			('Gold'),
			('Silver'),
			('Member');

insert into khach_hang (ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi)
	values 	(5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431211', '0945423361', 'thihao70@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
			(3, 'Phạm Xuân Diệu', '1992-08-08', 1, '643431212', '0945423362', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
			(1, 'Trương Đình Nghệ', '1990-02-27', 1, '643431213', '0945423363', 'dinhnghe2702@gmail.com', 'K232 Ông Ích Khiêm, Vinh'),
			(1, 'Dương Văn Quan', '1981-07-08', 1, '643431214', '0945423364', 'vanquan@gmail.com', 'k453/12 Lê Lợi, Đà Nẵng'),
			(4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '643431215', '0945423365', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
			(4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '643431216', '0945423366', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
			(1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '643431217', '0945423367', 'mykim84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
			(3, 'Nguyễn Thị Hào', '1999-04-08', 0, '643431218', '0945423368', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
			(1, 'Trần Đại Danh', '1994-07-01', 1, '643431219', '0945423369', 'daidanh94@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
			(2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '643431210', '0945423310', 'tamdac@gmail.com', '22 Ngô Quyền, Đà Nẵng');

select * from khach_hang;
delete from khach_hang where ho_ten = 'Phuc Tan';
select * from khach_hang
where ho_ten like concat('%', 'di', '%');

-- update khach_hang set ma_loai_khach = 5, ho_ten = 'Phạm Xuân Diệu 2', ngay_sinh = '1992-08-09', gioi_tinh =1, so_cmnd = '123456789', so_dien_thoai = '0987654321', email = 'xuandieu92@gmail.com2', dia_chi = 'K77/22 Thái Phiên, Quảng Trị 222'
-- where ma_khach_hang = 2;
select * from khach_hang where ma_khach_hang =2;

insert into kieu_thue (ten_kieu_thue)
	values 	('year'),
			('month'),
			('day'),
			('hour');
            
insert into loai_dich_vu (ten_loai_dich_vu)
	values	('Villa'),
			('House'),
			('Room');

insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
	values 	('Villa Beach Front', 25000, 10000000, 10, 3, 1, 'VIP', 'Có hồ bơi', 500, 4),
			('House Princess 01', 14000, 5000000, 7, 2, 2, 'VIP', 'Có thêm bếp nướng', null, 3),
			('Room Twin 01', 5000, 1000000, 2, 4, 3, 'NORMAL', 'Có ti vi', null, null),
			('Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'NORMAL', 'Có hồ bơi', 300, 3),
			('House Princess 02', 10000, 4000000, 5, 3, 2, 'NORMAL', 'Có thêm bếp nướng', null, 2),
			('Room Twin 02', 3000, 900000, 2, 4, 3, 'NORMAL', 'Có ti vi', null, null);
    
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai)
	values  ('Karaoke', 10000, 'giờ', 'Tiện nghi, hiện đại'),
			('Thuê xe máy', 10000, 'chiếc', 'Hỏng 1 xe'),
			('Thuê xe đạp', 20000, 'chiếc', 'Tốt'),
			('Buffet buổi sáng', 15000, 'suất', 'Đầy đủ đồ ăn, tráng miệng'),
			('Buffet buổi trưa', 90000, 'suất', 'Đầy đủ đồ ăn, tráng miệng'),
			('Buffet buổi tối', 16000, 'suất', 'Đầy đủ đồ ăn, tráng miệng');

insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
	values  ('2020-12-08', '2020-12-08', 0, 3, 1, 3),
			('2020-07-14', '2020-07-21', 200000, 7, 3, 1),
			('2021-03-15', '2021-03-17', 50000, 3, 4, 2),
			('2021-01-14', '2021-01-18', 100000, 7, 5, 5),
			('2021-07-14', '2021-07-15', 0, 7, 2, 6),
			('2021-06-01', '2021-06-03', 0, 7, 7, 6),
			('2021-09-02', '2021-09-05', 100000, 7, 4, 4),
			('2021-06-17', '2021-06-18', 150000, 3, 4, 1),
			('2020-11-19', '2020-11-19', 0, 3, 4, 3),
			('2021-04-12', '2021-04-14', 0, 10, 3, 5),
			('2021-04-25', '2021-04-25', 0, 2, 2, 1),
			('2021-05-25', '2021-05-27', 0, 7, 10, 1);

select * from hop_dong;

insert into hop_dong_chi_tiet (ma_hop_dong, ma_dich_vu_di_kem, so_luong)
	values  (2, 4, 5),
            (2, 5, 8),
            (2, 6, 15),
            (3, 1, 1),
            (3, 2, 11),
            (1, 3, 1),
            (1, 2, 2),
            (12, 2, 2);
            
-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * 
from nhan_vien 
where (ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%") and length(ho_ten) <= 15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * 
from khach_hang
where (dia_chi like "%Đà Nẵng" or dia_chi like "%Quảng Trị") 
		and ((year(now()) - year(ngay_sinh) > 18) and (year(now()) - year(ngay_sinh) < 50)) ;

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, count(khach_hang.ma_khach_hang) as 'so_lan_dat_phong'
from khach_hang 
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach = 'Diamond'
group by(khach_hang.ma_khach_hang)
order by so_lan_dat_phong;

-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, 
		dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong)) as tong_tien
from khach_hang 
	left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
	left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
    left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
    left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by khach_hang.ma_khach_hang
;

-- 6. Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được 
-- khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, loai_dich_vu.ten_loai_dich_vu , khach_hang.ho_ten, hop_dong.ngay_lam_hop_dong
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
-- group by ma_dich_vu
where (year(hop_dong.ngay_lam_hop_dong) <= 2021 and month(hop_dong.ngay_lam_hop_dong) <= 3) or 
(year(hop_dong.ngay_lam_hop_dong) <= 2020);

-- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where EXISTS (
        SELECT
            1
        FROM
            hop_dong
        WHERE
            dich_vu.ma_dich_vu = ma_dich_vu
            and year(ngay_lam_hop_dong) = 2020
    )
    and 
    NOT EXISTS (
            SELECT
            1
        FROM
            hop_dong
        WHERE
            dich_vu.ma_dich_vu = ma_dich_vu
            and year(ngay_lam_hop_dong) = 2021
    )
group by dich_vu.ma_dich_vu
; 
-- 8. Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select * 
from khach_hang
group by ho_ten;

select  distinct * 
from khach_hang;

SELECT
    ho_ten
FROM
    khach_hang
UNION
SELECT
    ho_ten
FROM
    khach_hang;
    
-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu 
-- khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong) as 'Tháng', count(ma_hop_dong) as 'Số lần đặt'
from hop_dong 
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- 11. Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, khach_hang.ho_ten, loai_khach.ten_loai_khach, khach_hang.dia_chi
from dich_vu_di_kem 
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh' or khach_hang.dia_chi like '%Quảng Ngãi');

-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã 
-- từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, ten_dich_vu, sum(tien_dat_coc) tong_tien_coc, sum(so_luong) tong_so_luong_dvdk
from hop_dong
    left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
    left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
    left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where (ngay_lam_hop_dong between '2020-10-01' and '2020-12-30')
    and (ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30')
group by hop_dong.ma_hop_dong;

-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hop_dong.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(hop_dong_chi_tiet.ma_dich_vu_di_kem) so_lan_dung_dvdk
from dich_vu_di_kem
	join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
	join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
	join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having so_lan_dung_dvdk = 1;

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nhan_vien.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi, count(hop_dong.ma_nhan_vien) tong_so_hop_dong
from nhan_vien 
    join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
    join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
    join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(ngay_lam_hop_dong) BETWEEN 2020 and 2021
group by hop_dong.ma_nhan_vien
having tong_so_hop_dong <= 3;	

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien 
where ma_nhan_vien in 

(select tmp.ma_nhan_vien from
	(
		(select nhan_vien.ma_nhan_vien 
		from nhan_vien
			left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
		where (year(ngay_lam_hop_dong) not between 2019 and 2021)
			or ngay_lam_hop_dong is null)
	) tmp
); 

-- 17. Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang
set ma_loai_khach = 1
where ma_khach_hang in (select tmp.ma_khach_hang
from (
select khach_hang.ma_khach_hang,
(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong)) as tong_tien
from khach_hang 
	join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
    join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
    join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
    
    where year(hop_dong.ngay_lam_hop_dong) = 2021
group by khach_hang.ma_khach_hang
having tong_tien > 10000000

) tmp);



-- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
delete 
from khach_hang kh
where kh.ma_khach_hang in 
(
	select hd.ma_khach_hang 
	from hop_dong hd
	where  year(ngay_lam_hop_dong) < 2021
);

DELETE FROM
    khach_hang kh
WHERE
    NOT EXISTS (
        select
            1
        FROM
            hop_dong
        WHERE
            kh.ma_khach_hang = ma_khach_hang
            and YEAR(ngay_lam_hop_dong) >= 2021
    );

-- 19. Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem
set gia = gia * 2
where ma_dich_vu_di_kem in (
	select tmp.ma_dich_vu_di_kem
	from
		(
			select dvdk.ma_dich_vu_di_kem
			from dich_vu_di_kem as dvdk
				join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
				join hop_dong as hd on hd.ma_hop_dong = hdct.ma_hop_dong
				where year(hd.ngay_lam_hop_dong) = 2020
			group by dvdk.ma_dich_vu_di_kem
			having sum(hdct.so_luong) > 10
		) tmp
	);

-- 20. Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union all
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;

-- 21. Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as
	select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.dia_chi, hop_dong.ngay_lam_hop_dong
    from nhan_vien
    join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
    group by nhan_vien.ma_nhan_vien
    having nhan_vien.dia_chi like '%Hải Châu%' and
		 hop_dong.ngay_lam_hop_dong = '2019-12-12';

-- 22.Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả 
-- các nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien 
set dia_chi = 'Liên Chiểu'; 
    

    
