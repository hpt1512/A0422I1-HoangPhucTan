-- PHẦN 1: TẠO CSDL

create database furama_management;
use furama_management;

create table vi_tri (
	ma_vi_tri int,
    ten_vi_tri varchar(45) not null,
    primary key(ma_vi_tri)
);

create table trinh_do (
	ma_trinh_do int,
    ten_trinh_do varchar(45) not null,
    primary key(ma_trinh_do)
);

create table bo_phan (
	ma_bo_phan int,
    ten_bo_phan varchar(45) not null,
    primary key(ma_bo_phan)
);

create table nhan_vien (
	ma_nhan_vien int,
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
	ma_loai_khach int,
    ten_loai_khach varchar(45) not null,
    primary key(ma_loai_khach)
);

create table khach_hang (
	ma_khach_hang int,
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
	ma_kieu_thue int,
    ten_kieu_thue varchar(45) not null,
    primary key(ma_kieu_thue)
);

create table loai_dich_vu (
	ma_loai_dich_vu int,
    ten_loai_dich_vu varchar(45) not null,
    primary key(ma_loai_dich_vu)
);

create table dich_vu (
	ma_dich_vu int,
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
	ma_hop_dong int,
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
	ma_dich_vu_di_kem int,
	ten_dich_vu_di_kem varchar(45) not null,
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45),
    primary key(ma_dich_vu_di_kem)
);

create table hop_dong_chi_tiet (
	ma_hop_dong_chi_tiet int,
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
-- PHẦN 2: THÊM DỮ LIỆU

insert into bo_phan 
	values 	(1, "Tiền Sảnh"),
			(2, "Nhà Hàng"),
			(3, "Buồng Phòng"),
			(4, "Vui Chơi Giải Trí"),
			(5, "Kỹ Thuật"),
			(6, "IT"),
			(7, "An Ninh"),
			(8, "Kế Toán"),
			(9, "Sale & Marketing");
select * from bo_phan;

-- PHẦN 3: TRUY VẤN SQL CƠ BẢN


