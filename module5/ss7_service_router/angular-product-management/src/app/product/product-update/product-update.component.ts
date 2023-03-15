import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  categories: Category[] = [];
  productForm: FormGroup;
  product: Product;
  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      if (id != null) {
        this.productService.getById(parseInt(id)).subscribe(next => {
          this.product = next;
          this.productForm = new FormGroup ({
            id: new FormControl(this.product.id),
            name: new FormControl(this.product.name),
            price: new FormControl(this.product.price),
            description: new FormControl(this.product.description),
            category: new FormControl(this.product.category),
          })
        });
      }
    }, error => {

    }, () => {

    });


  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(next => {
      this.categories = next;
    })
  }

  updateProduct() {
    this.productService.updateProduct(this.product.id, this.productForm.value).subscribe(next => {
      this.router.navigateByUrl('product/list');
    });
  }

  compareFn(t1: Category, t2: Category): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
}
