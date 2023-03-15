import {Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from '../../model/student';
import {ActivatedRoute} from '@angular/router';
import {StudentService} from '../../service/student.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit, OnChanges, DoCheck {
  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      if (id != null) {
        this.studentService.findById(parseInt(id)).subscribe(next => {
          this.student = next;
        }, error => {
          alert("LỖi")
        });
      }
    }, error => {

    }, () => {

    });
  }

  student: Student = {id: 3, name: 'haiTT', point: 0};
  color = 'red';

  ngOnInit(): void {
    console.log('hello every body');
  }

  ngDoCheck(): void {
    console.log('do check');
  }

  changeNameStudent(name: string) {
    this.student.name = name;
    this.ngOnInit();
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
  }
}
