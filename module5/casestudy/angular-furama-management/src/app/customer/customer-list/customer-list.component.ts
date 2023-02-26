import { Component, OnInit } from '@angular/core';
import {Customer} from '../../customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [
    {
      id: 1,
      customerType: {id: 1, name: 'Diamond'},
      name: 'Hoàng Phúc Tân',
      birthday: '2000-12-15',
      gender: true,
      idCard: '044200001835',
      phoneNumber: '0889152558',
      email: 'hoangphuctanpt@gmail.com',
      address: '60/1 Lê Thị Tính'
    },
    {
      id: 1,
      customerType: {id: 2, name: 'Gold'},
      name: 'Hoàng Anh Trường',
      birthday: '2000-09-22',
      gender: true,
      idCard: '086394713746',
      phoneNumber: '0123456789',
      email: 'anhtruong@gmail.com',
      address: '100 Cù Chính Lan'
    },
    {
      id: 1,
      customerType: {id: 3, name: 'Silva'},
      name: 'Nguyễn Phương Linh',
      birthday: '2003-12-15',
      gender: false,
      idCard: '012345678909876',
      phoneNumber: '0912345678',
      email: 'phươnglinh@gmail.com',
      address: '200 Nguyển Phươc Nguyên'
    },
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
