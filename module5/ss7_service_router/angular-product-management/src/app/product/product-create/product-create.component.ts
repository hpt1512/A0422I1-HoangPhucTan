import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Route, Router} from "@angular/router";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl("", [Validators.min(0), Validators.required]),
    description: new FormControl(),
    category: new FormControl(),
    saleDate: new FormControl("", [Validators.required ,this.validateSaleDate]),
  });

  validateSaleDate(control: AbstractControl) {
    const saleDate = control.value;
    let date = new Date();
    let newSaleDate = new Date(saleDate);
    if (newSaleDate.getTime() >= date.getTime()) {
      return null;
    } else {
      return {saleDateValid: true};
    }
  }

  categories: Category[] = [];
  defaultItem: Category;
  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router,
              private toast: ToastrService) { }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(next => {
      this.categories = next;
      this.defaultItem = this.categories[0];
    });

    let date = new Date();
    console.log(date.getTime())

    let date2 = new Date('2023-03-14');
    console.log(date2.getTime())
  }

  submit() {
    const product = this.productForm.value;
    if (this.productForm.valid) {
      this.productService.saveProduct(product).subscribe(next => {
        this.productForm.reset();
        this.router.navigateByUrl('/product/list');
        this.toast.success("Thêm mới thành công");
      });
    }
  }

  compareFn(t1: Category, t2: Category): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
}
