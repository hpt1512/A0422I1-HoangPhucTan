import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from './component/student/student-list/student-list.component';
import {StudentDetailComponent} from './component/student/student-detail/student-detail.component';
import {StudentCreateComponent} from './component/student/student-create/student-create.component';

const routes: Routes = [
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
