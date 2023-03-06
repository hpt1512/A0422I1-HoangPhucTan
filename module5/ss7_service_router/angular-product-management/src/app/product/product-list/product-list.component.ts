import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

  showFormEdit(id: number) {
    this.router.navigate(['product/edit', id]);
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id);
    this.getAll()
  }
}
