import {Injectable} from '@angular/core';
import {LoHang} from "../../model/lo-hang";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Generals} from "../../model/generals";

@Injectable({
  providedIn: 'root'
})
export class LoHangService {
  danhSachLoHang: LoHang[] = [];

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>("http://localhost:3000/lo-hang/");
  }

  themMoiLoHang(loHang: LoHang): Observable<any> {
    return this.httpClient.post("http://localhost:3000/lo-hang/", loHang);
  }

  xoaLoHang(id: string): Observable<any> {
    return this.httpClient.delete("http://localhost:3000/lo-hang/" + id);
  }

  timKiemLoHang(nameProductSearch: string): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>("http://localhost:3000/lo-hang?sanPham.tenSanPham_like=" + nameProductSearch.trim());
  }

  timKiemLoHangByDate(ngayHetHan: string): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>("http://localhost:3000/lo-hang?ngayHetHan=" + ngayHetHan.trim());
  }

}
