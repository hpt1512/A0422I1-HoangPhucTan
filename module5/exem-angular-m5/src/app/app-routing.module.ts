import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GeneralsListComponent} from "./component/generals/generals-list/generals-list.component";
import {GeneralsCreateComponent} from "./component/generals/generals-create/generals-create.component";
import {GeneralsUpdateComponent} from "./component/generals/generals-update/generals-update.component";
import {LoHangListComponent} from "./component/lo-hang/lo-hang-list/lo-hang-list.component";
import {LoHangCreateComponent} from "./component/lo-hang/lo-hang-create/lo-hang-create.component";


const routes: Routes = [
  {
    path: "generals/list",
    component: GeneralsListComponent
  },
  {
    path: "generals/create",
    component: GeneralsCreateComponent
  },
  {
    path: "generals/edit/:id",
    component: GeneralsUpdateComponent
  },
  {
    path: "lo-hang/list",
    component: LoHangListComponent
  },
  {
    path: "lo-hang/create",
    component: LoHangCreateComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
