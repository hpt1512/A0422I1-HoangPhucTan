import { Injectable } from '@angular/core';
import {Student} from '../model/student';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private students: Student[] = [];
  constructor(private httpClient: HttpClient) {
    this.students.push({id: 0, point: 9, name:"HaiTT",dateOfBirth:"1998/01/01"});
    this.students.push({id: 2, point: 11, name:"TrungDP",dateOfBirth:"1998/01/01"});
    this.students.push({id: 4, point: 5, name:"TrungDC",dateOfBirth:"1998/01/01"});
  }

  getAll(): Observable<Student[]> {
    return this.httpClient.get<Student[]>("http://localhost:3000/students/");
  }

  addStudent(event: any): Observable<any> {
    return this.httpClient.post("http://localhost:3000/students", event);
  }

  findById(id: number): Observable<Student> {
    return this.httpClient.get<Student>("http://localhost:3000/students/"+id);
  }
}
