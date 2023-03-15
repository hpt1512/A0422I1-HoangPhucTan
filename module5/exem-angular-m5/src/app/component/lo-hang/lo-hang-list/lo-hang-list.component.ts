import { Component, OnInit } from '@angular/core';
import {LoHang} from "../../../model/lo-hang";
import {LoHangService} from "../../../service/lo-hang/lo-hang.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-lo-hang-list',
  templateUrl: './lo-hang-list.component.html',
  styleUrls: ['./lo-hang-list.component.css']
})
export class LoHangListComponent implements OnInit {
  danhSachLoHang: LoHang[] = [];
  delId: string;
  formSearch: FormGroup;
  formSearchDate: FormGroup;
  constructor(private loHangService: LoHangService) { }

  ngOnInit(): void {
    this.findAll()
    console.log(this.danhSachLoHang)
    this.formSearch = new FormGroup({
      nameProductSearch: new FormControl()
    });
    this.formSearchDate = new FormGroup({
      ngayHetHanSearch: new FormControl()
    })
  }

  findAll() {
    this.loHangService.findAll().subscribe(next => {
      this.danhSachLoHang = next;
    })
  }

  infoDelete(id: any, name: any) {
    this.delId = id;
    document.getElementById("delName").innerText = name;
  }

  deleteLoHang(delId: any) {
    this.loHangService.xoaLoHang(delId).subscribe(next => {
      this.findAll();
    });
  }

  searchLoHang() {
    this.loHangService.timKiemLoHang(this.formSearch.value.nameProductSearch).subscribe(next => {
      this.danhSachLoHang = next;
    })
  }

  searchLoHangByDate() {
    this.loHangService.timKiemLoHangByDate(this.formSearchDate.value.ngayHetHanSearch).subscribe(next => {
      this.danhSachLoHang = next;
    })
  }
}
