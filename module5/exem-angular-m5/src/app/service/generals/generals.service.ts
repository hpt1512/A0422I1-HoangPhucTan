import { Injectable } from '@angular/core';
import {Generals} from "../../model/generals";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GeneralsService {
  generals: Generals[] = [];
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Generals[]> {
    return this.httpClient.get<Generals[]>("http://localhost:3000/generals/");
  }

  findById(id: string): Observable<Generals> {
    return this.httpClient.get<Generals>("http://localhost:3000/generals/" + id);
  }

  addGenerals(generals: Generals): Observable<any> {
    return this.httpClient.post("http://localhost:3000/generals/", generals);
  }

  updateGenerals(id: string, generals: Generals): Observable<any> {
    return this.httpClient.put("http://localhost:3000/generals/" + id, generals);
  }

  deleteGenerals(id: string): Observable<any> {
    return this.httpClient.delete("http://localhost:3000/generals/" + id);
  }
  searchGenerals(nameSearch: string): Observable<Generals[]> {
    return this.httpClient.get<Generals[]>("http://localhost:3000/generals?name_like=" + nameSearch.trim());
  }
}
