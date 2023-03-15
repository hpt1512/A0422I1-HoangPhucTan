import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentCreateComponent} from './student-create/student-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { StudentComponent } from './student.component';
import {StudentService} from '../service/student.service';


@NgModule({
  declarations: [
    StudentDetailComponent,
    StudentListComponent,
    StudentCreateComponent,
    StudentComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    StudentRoutingModule
  ],
  providers: [
    StudentService
  ]
})
export class StudentModule { }
