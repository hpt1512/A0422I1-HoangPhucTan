import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ServiceListComponent} from './component/service/service-list/service-list.component';
import {ServiceCreateComponent} from './component/service/service-create/service-create.component';
import {CustomerListComponent} from './component/customer/customer-list/customer-list.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {ServiceEditComponent} from './component/service/service-edit/service-edit.component';
import {ContractCreateComponent} from "./component/contract/contract-create/contract-create.component";


const routes: Routes = [
  {
    path: '',
    component: ServiceListComponent
  },
  {
    path: 'service/create',
    component: ServiceCreateComponent
  },
  {
    path: 'service/edit/:id',
    component: ServiceEditComponent
  },
  {
    path: 'customer/list',
    component: CustomerListComponent
  },
  {
    path: 'customer/create',
    component: CustomerCreateComponent
  },
  {
    path: 'contract/create',
    component: ContractCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
