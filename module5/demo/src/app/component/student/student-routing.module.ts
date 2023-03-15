import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentCreateComponent} from './student-create/student-create.component';
import {StudentComponent} from './student.component';

const routes: Routes = [
  {
    path: 'student', component: StudentComponent, children: [
      {path: '', component: StudentListComponent},
      {path: 'detail/:id', component: StudentDetailComponent},
      {path: 'create', component: StudentCreateComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule {
}
