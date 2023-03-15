import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>("http://localhost:3000/products/");
  }

  getById(id: number): Observable<Product> {
    return this.httpClient.get<Product>("http://localhost:3000/products/" + id);
  }

  saveProduct(product: Product): Observable<any> {
    return this.httpClient.post("http://localhost:3000/products", product);
  }

  updateProduct(id: number, product: Product): Observable<any> {
    return this.httpClient.patch("http://localhost:3000/products/" + id, product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.httpClient.delete("http://localhost:3000/products/" + id);
  }
}
