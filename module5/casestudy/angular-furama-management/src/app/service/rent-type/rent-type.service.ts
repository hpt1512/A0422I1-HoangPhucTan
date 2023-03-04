import { Injectable } from '@angular/core';
import {RentType} from '../../model/rent-type';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {
  rentTypes: RentType[] = [
    {
      id: 1,
      name: 'Năm',
      cost: 2000000
    },
    {
      id: 2,
      name: 'Tháng',
      cost: 500000
    },
    {
      id: 3,
      name: 'Ngày',
      cost: 200000
    },
    {
      id: 4,
      name: 'Giờ',
      cost: 100000
    },
  ];
  constructor() { }

  getAll() {
    return this.rentTypes;
  }

  getById(id: number): RentType {
    return this.rentTypes.filter(element => element.id === id)[0];
  }
}
