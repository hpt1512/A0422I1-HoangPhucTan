import {Component, OnInit} from '@angular/core';
import {Student} from '../../model/student';
import {StudentService} from '../../service/student.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  student: Student = {id: 0, name: "", point: 0}

  constructor(private studentService: StudentService,
              private router: Router) {
    this.studentService.getAll().subscribe(next => {
      console.log(next);
      this.students = next;
    }, error => {

    }, () => {

    });
  }

  ngOnInit(): void {
  }

  info(id: number|undefined) {
    this.router.navigate(["/detail", id])
  }
}
