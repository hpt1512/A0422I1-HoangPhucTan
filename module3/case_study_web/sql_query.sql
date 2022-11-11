SELECT * FROM nhan_vien;

insert into nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
	values 	(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);


update nhan_vien set ho_ten = 'Nguyễn Văn An 2', ngay_sinh = '1970-11-05', so_cmnd = '456231786222', luong = 20000000, so_dien_thoai = '0889152558', 
	email = 'annguyen@gmail.com2', dia_chi = '295 Nguyễn Tất Thành, Đà Nẵng 2' , ma_vi_tri = 2, ma_trinh_do = 3, ma_bo_phan = 1
where ma_nhan_vien = 1;


select * from nhan_vien where ma_nhan_vien = ?;
select * from nhan_vien where ho_ten like concat('%', ?, '%');

SELECT * FROM vi_tri;
SELECT * FROM trinh_do;
SELECT * FROM bo_phan;
SELECT * FROM kieu_thue;
SELECT * FROM loai_dich_vu;

SELECT * FROM dich_vu;
delete from dich_vu where ma_dich_vu = 1;
update dich_vu set ten_dich_vu = ?, dien_tich = ?, chi_phi_thue = ?, so_nguoi_toi_da = ?, ma_kieu_thue = ?, 
	ma_loai_dich_vu = ?, tieu_chuan_phong = ? , mo_ta_tien_nghi_khac = ?, dien_tich_ho_boi = ?, so_tang = ?
where ma_dich_vu = ?;

insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
	values 	(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
    
select * from dich_vu where ten_dich_vu like concat('%', ?, '%') and ma_kieu_thue like concat('%', ?, '%') 
and ma_loai_dich_vu like concat('%', ?, '%');

