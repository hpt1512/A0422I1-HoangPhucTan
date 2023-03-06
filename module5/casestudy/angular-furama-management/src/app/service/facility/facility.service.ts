import { Injectable } from '@angular/core';
import {Facility} from '../../model/facility';
import {RentTypeService} from '../rent-type/rent-type.service';
import {ServiceTypeService} from "../service-type/service-type.service";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  facilities: Facility[] = [
    {
      id: 1,
      name: 'Villa hướng biển',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(1),
      serviceType: this.serviceTypeService.getById(1),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 2,
      name: 'Room 205',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(1),
      serviceType: this.serviceTypeService.getById(3),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 3,
      name: 'House VIP',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(2),
      serviceType: this.serviceTypeService.getById(2),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 4,
      name: 'Studio hướng biển',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(1),
      serviceType: this.serviceTypeService.getById(1),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 5,
      name: 'Studio hướng biển',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(1),
      serviceType: this.serviceTypeService.getById(1),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 6,
      name: 'Studio hướng biển',
      image: 'service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: this.rentTypeService.getById(1),
      serviceType: this.serviceTypeService.getById(1),
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
  ];
  constructor(private rentTypeService: RentTypeService,
              private serviceTypeService: ServiceTypeService) { }

  getAll() {
    return this.facilities;
  }

  getById(id: number): Facility {
    return this.facilities.filter(element => element.id === id)[0];
  }

  createNewFacility(facility: Facility) {
    this.facilities.push(facility);
  }

  updateFacility(id: number, facility: Facility) {
    for (let i = 0; i < this.facilities.length; i++) {
      if (this.facilities[i].id === id) {
        this.facilities[i] = facility;
      }
    }
  }

  deleteFacility(id: number) {
    this.facilities = this.facilities.filter(element => {
      return element.id !== id;
    });
  }
}
