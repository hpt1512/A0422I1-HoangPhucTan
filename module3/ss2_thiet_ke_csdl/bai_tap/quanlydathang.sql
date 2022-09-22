create database QuanLyVatTu;
use QuanLyVatTu;

create table vat_tu (
	ma_vt int auto_increment,
    ten_vt varchar(45) not null,
    primary key(ma_vt)
);

create table phieu_nhap (
	so_pn int auto_increment,
    ngay_nhap date,
    primary key(so_pn)
);

create table phieu_xuat (
	so_px int auto_increment,
    ngay_xuat date,
    primary key(so_px)
);

create table vattu_phieunhap (
	ma_vt int,
    so_pn int,
    primary key(ma_vt, so_pn)
);
-- sét khoá ngoại 
alter table vattu_phieunhap 
	add constraint fk_vattu_vattu_phieunhap foreign key (ma_vt) references vat_tu(ma_vt)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_phieunhap_vattu_phieunhap foreign key (so_pn) references phieu_nhap(so_pn)
		on update
			cascade
        on delete
			cascade;

create table vattu_phieuxuat (
	ma_vt int,
    so_px int,
    primary key(ma_vt, so_px)
);
-- sét khoá ngoại 
alter table vattu_phieuxuat 
	add constraint fk_vattu_vattu_phieuxuat foreign key (ma_vt) references vat_tu(ma_vt)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_phieuxuat_vattu_phieuxuat foreign key (so_px) references phieu_xuat(so_px)
		on update
			cascade
        on delete
			cascade;
            
create table nha_cc (
	ma_ncc int auto_increment,
    ten_ncc varchar(45) not null,
    dia_chi varchar(100),
    sdt varchar(11),
    primary key(ma_ncc)
);

create table don_dh (
	so_dh int auto_increment,
    ngay_dh date,
    ma_ncc int,
    primary key(so_dh)
);
-- sét khoá ngoại 
alter table don_dh 
	add constraint fk_dondh_nhacc foreign key (ma_ncc) references nha_cc(ma_ncc)
		on update
			cascade
        on delete
			cascade;

create table vattu_donhang (
	ma_vt int,
    so_dh int,
    primary key(ma_vt, so_dh)
);
-- sét khoá ngoại 
alter table vattu_donhang 
	add constraint fk_vattu_vattu_donhang foreign key (ma_vt) references vat_tu(ma_vt)
		on update
			cascade
        on delete
			cascade,
	add constraint fk_donhang_vattu_donhang foreign key (so_dh) references don_dh(so_dh)
		on update
			cascade
        on delete
			cascade;

