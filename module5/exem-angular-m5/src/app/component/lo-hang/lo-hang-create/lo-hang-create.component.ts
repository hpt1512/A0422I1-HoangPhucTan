import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {Position} from "../../../model/position";
import {SanPham} from "../../../model/san-pham";
import {LoHangService} from "../../../service/lo-hang/lo-hang.service";
import {SanPhamService} from "../../../service/san-pham/san-pham.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import validate = WebAssembly.validate;

@Component({
  selector: 'app-lo-hang-create',
  templateUrl: './lo-hang-create.component.html',
  styleUrls: ['./lo-hang-create.component.css']
})
export class LoHangCreateComponent implements OnInit {
  loHangForm: FormGroup;
  danhSachSanPham: SanPham[] = [];
  defaultItem: SanPham;
  constructor(private loHangService: LoHangService,
              private sanPhamService: SanPhamService,
              private router: Router,
              private toast: ToastrService) { }

  ngOnInit(): void {
    this.loHangForm = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]),
      sanPham: new FormControl('', [Validators.required]),
      soLuong: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('^[0-9()]+$')]),
      ngayNhapHang: new FormControl('', [Validators.required]),
      ngaySanXuat: new FormControl('', [Validators.required]),
      ngayHetHan: new FormControl('', [Validators.required]),
    }, [this.validateDate]);
    this.sanPhamService.findAll().subscribe(next => {
      this.danhSachSanPham = next;
      this.defaultItem = this.danhSachSanPham[0];
    })
  }

  validateDate(form: any) {
    let ngayNhapHang = new Date(form.controls.ngayNhapHang.value);
    let ngaySanXuat = new Date(form.controls.ngaySanXuat.value);
    let ngayHetHan = new Date(form.controls.ngayHetHan.value);

    if (ngaySanXuat.getTime() > ngayHetHan.getTime() || ngaySanXuat.getTime() > ngayNhapHang.getTime()
      || ngayNhapHang.getTime() > ngayHetHan.getTime()) {
      return {dateValid: true};
    } else {
      return null;
    }
  }

  createNewLoHang() {
    if (this.loHangForm.valid) {
      this.loHangService.themMoiLoHang(this.loHangForm.value).subscribe(next => {
        this.router.navigateByUrl('lo-hang/list');
        this.toast.success("Thêm mới thành công");
      })
    }
   else {
     this.toast.error("Thêm mới thất bại, vui lòng kiểm tra dữ liệu nhập vào")
    }
  }

  compareFn(t1: SanPham, t2: SanPham): boolean {
    return t1 && t2 ? t1.tenSanPham === t2.tenSanPham : t1 === t2;
  }
}
