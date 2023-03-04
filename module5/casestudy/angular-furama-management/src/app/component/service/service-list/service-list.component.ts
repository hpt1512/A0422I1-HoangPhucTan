import { Component, OnInit } from '@angular/core';
import {FacilityService} from '../../../service/facility/facility.service';
import {Facility} from '../../../model/facility';
import {Router} from '@angular/router';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  facilities: Facility[] = [];
  delId: number;
  constructor(private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.facilities = this.facilityService.getAll();
  }

  showEditPage(id: number | undefined) {
    this.router.navigate(['service/edit', id]);
  }

  infoDelete(id: number, name: string) {
    this.delId = id;
    document.getElementById("delName").innerText = name;
  }

  deleteFacility(id: number | undefined) {
    this.facilityService.deleteFacility(id);
    console.log(this.facilityService.getAll());
    this.getAll();
  }
}
