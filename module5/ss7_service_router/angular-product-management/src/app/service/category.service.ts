import {Injectable} from '@angular/core';
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [];

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>("http://localhost:3000/categories");
  }

  addCategory(category: Category): Observable<any> {
    return this.httpClient.post("http://localhost:3000/categories", category);
  }

  findById(id: number): Observable<Category> {
    return this.httpClient.get<Category>("http://localhost:3000/categories/" + id);
  }
}
