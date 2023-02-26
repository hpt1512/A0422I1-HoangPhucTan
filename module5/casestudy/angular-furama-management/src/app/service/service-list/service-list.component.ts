import { Component, OnInit } from '@angular/core';
import {Facility} from '../../facility';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  facilities: Facility[] = [
    {
      id: 1,
      name: 'Villa A1 hướng biển',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'Villa'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 2,
      name: 'Room 205',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'Room'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 3,
      name: 'House VIP',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'House'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 4,
      name: 'Studio hướng biển',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'Villa'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 5,
      name: 'Studio hướng biển',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'Villa'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
    {
      id: 6,
      name: 'Studio hướng biển',
      image: '../assets/img/service/service1.png',
      area: 100,
      cost: 100,
      peopleMax: 5,
      rentType: {id: 1, name: 'Month', cost: 200},
      serviceType: {id: 1, name: 'Villa'},
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Bếp nướng',
      poolArea: 20,
      floor: 2
    },
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
