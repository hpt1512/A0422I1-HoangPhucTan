import {SanPham} from "./san-pham";

export interface LoHang {
  id: string;
  sanPham: SanPham;
  soLuong: number;
  ngayNhapHang: string;
  ngaySanXuat: string;
  ngayHetHan: string;
}
