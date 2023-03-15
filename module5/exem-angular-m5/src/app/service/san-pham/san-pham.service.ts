import { Injectable } from '@angular/core';
import {SanPham} from "../../model/san-pham";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SanPhamService {
  danhSachSanPham: SanPham[] = [];
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>("http://localhost:3000/san-pham/")
  }

}
