import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FacilityService} from '../../../service/facility/facility.service';
import {Facility} from '../../../model/facility';
import {RentType} from '../../../model/rent-type';
import {ServiceType} from '../../../model/service-type';
import {RentTypeService} from '../../../service/rent-type/rent-type.service';
import {ServiceTypeService} from '../../../service/service-type/service-type.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  serviceForm: FormGroup;
  facility: Facility;
  rentTypes: RentType[] = [];
  serviceTypes: ServiceType[] = [];
  constructor(private activatedRoute: ActivatedRoute,
              private facilityService: FacilityService,
              private rentTypeService: RentTypeService,
              private serviceTypeService: ServiceTypeService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      if (id != null) {
        this.facility = this.facilityService.getById(parseInt(id));
      }
    }, error => {

    }, () => {

    });
    this.serviceForm = new FormGroup({
      id: new FormControl(this.facility.id, [Validators.required]),
      name: new FormControl(this.facility.name, [Validators.required, Validators.pattern('^[^0-9()]+$')]),
      image: new FormControl(this.facility.image.substr(12), [Validators.required]),
      area: new FormControl(this.facility.area, [Validators.required, Validators.min(0)]),
      cost: new FormControl(this.facility.cost, [Validators.required, Validators.min(0)]),
      peopleMax: new FormControl(this.facility.peopleMax, [Validators.required, Validators.min(0)]),
      rentType: new FormControl(this.facility.rentType, [Validators.required]),
      serviceType: new FormControl(this.facility.serviceType, [Validators.required]),
      standardRoom: new FormControl(this.facility.standardRoom, [Validators.required]),
      descriptionOtherConvenience: new FormControl(this.facility.descriptionOtherConvenience, [Validators.required]),
      poolArea: new FormControl(this.facility.poolArea, [Validators.required, Validators.min(0), Validators.pattern('[0-9]')]),
      floor: new FormControl(this.facility.floor, [Validators.required, Validators.min(0), Validators.pattern('[0-9]')]),
    });
    this.rentTypes = this.rentTypeService.getAll();
    this.serviceTypes = this.serviceTypeService.getAll();
  }

  ngOnInit(): void {
  }

  updateFacility() {
    this.serviceForm.value.image = this.serviceForm.controls.image.value.substr(12);
    if (this.serviceForm.valid) {
      this.facilityService.updateFacility(this.facility.id, this.serviceForm.value);
      this.router.navigateByUrl('');
    }
    console.log(this.facilityService.getAll());
  }
}
