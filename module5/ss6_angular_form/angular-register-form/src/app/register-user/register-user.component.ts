import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  messSuccess = '';
  userForm: FormGroup;
  constructor() {
    this.userForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      passwordConfirm: new FormControl(''),
      country: new FormControl('', Validators.required),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', Validators.required),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^0[0-9]{9}')]),
    }, [this.confirmPassword]);
  }

  ngOnInit(): void {
  }

  confirmPassword(form: any) {
    const pass = form.controls.password.value;
    const passConfirm = form.controls.passwordConfirm.value;
    if (pass === passConfirm) {
      return null;
    } else {
      return {passwordNotMatch: true};
    }
  }

  registerUser() {
    if (this.userForm.valid) {
      this.messSuccess = 'Đăng ký thành công';
    }
    console.log(this.userForm);
  }
}
