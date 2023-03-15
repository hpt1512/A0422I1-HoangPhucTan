import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../../model/student';
import {AbstractControl, FormControl, FormGroup, NgForm, ValidatorFn, Validators} from '@angular/forms';
import {StudentService} from '../../service/student.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  @Output() studentSubmit = new EventEmitter();
  student?: Student;

  studentForm: FormGroup;

  constructor(private toast: ToastrService,private studentService: StudentService, private router: Router) {
    this.studentForm = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.min(1), Validators.max(2147483647)]),
      name: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(255)]),
      dateOfBirth: new FormControl(),
      point: new FormControl('', [this.validatePoint])
    }, [this.confirmPasss]);
  }

  confirmPasss(form: any)  {
    let name = form.controls.name.value;
    if (name === 'HaiTT') {
      return null;
    } else {
      return {'invalidName': true};
    }
  }

  validatePoint(control: AbstractControl) {
    // let id = this.studentForm.controls.id.value;
    let point = control.value;
    if (point < 0) {
      return {'invalidPoint': true};
    }
    return null;
  }

  ngOnInit(): void {
  }

  addStudent(value: string, value2: string, value3: string, value4: string) {
    let student = {id: parseInt(value), name: value2, dateOfBirth: value3, point: parseInt(value4)};
    console.log(student);
    this.studentSubmit.emit(student);
  }

  addStudentWithTemplate(templateForm: NgForm) {
    console.log(templateForm);
    this.studentSubmit.emit(templateForm.value);
  }

  addStudentWithReactive() {
   this.studentService.addStudent(this.studentForm.value).subscribe(next => {
     this.toast.success("Thêm mới thành công")
     this.router.navigateByUrl("")
   });
  }
}
