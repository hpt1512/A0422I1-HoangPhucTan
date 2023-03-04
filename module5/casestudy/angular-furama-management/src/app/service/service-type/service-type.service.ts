import { Injectable } from '@angular/core';
import {ServiceType} from '../../model/service-type';

@Injectable({
  providedIn: 'root'
})
export class ServiceTypeService {

  serviceTypes: ServiceType[] = [
    {
      id: 1,
      name: 'Villa',
    },
    {
      id: 2,
      name: 'House',
    },
    {
      id: 3,
      name: 'Room',
    },
  ];
  constructor() { }

  getAll() {
    return this.serviceTypes;
  }

  getById(id: number): ServiceType {
    return this.serviceTypes.filter(element => element.id === id)[0];
  }
}
