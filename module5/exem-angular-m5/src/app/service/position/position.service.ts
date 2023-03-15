import { Injectable } from '@angular/core';
import {Position} from "../../model/position";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  positions: Position[] = []
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Position[]> {
    return this.httpClient.get<Position[]>("http://localhost:3000/position/");
  }

  findById(id: number): Observable<Position> {
    return this.httpClient.get<Position>("http://localhost:3000/position/" + id);
  }
}
