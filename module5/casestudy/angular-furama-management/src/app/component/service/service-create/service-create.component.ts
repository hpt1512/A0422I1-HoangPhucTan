import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentTypeService} from '../../../service/rent-type/rent-type.service';
import {ServiceTypeService} from '../../../service/service-type/service-type.service';
import {FacilityService} from '../../../service/facility/facility.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  serviceForm: FormGroup;
  rentTypes = this.rentTypeService.getAll();
  serviceTypes = this.serviceTypeService.getAll();

  constructor(private rentTypeService: RentTypeService,
              private serviceTypeService: ServiceTypeService,
              private facilityService: FacilityService,
              private router: Router) {
    this.serviceForm = new FormGroup({
        id: new FormControl('', [Validators.required]),
        name: new FormControl('', [Validators.required, Validators.pattern('^[^0-9()]+$')]),
        image: new FormControl('', [Validators.required]),
        area: new FormControl('', [Validators.required, Validators.min(0)]),
        cost: new FormControl('', [Validators.required, Validators.min(0)]),
        peopleMax: new FormControl('', [Validators.required, Validators.min(0)]),
        rentType: new FormControl('', [Validators.required]),
        serviceType: new FormControl('', [Validators.required]),
        standardRoom: new FormControl('', [Validators.required]),
        descriptionOtherConvenience: new FormControl('', [Validators.required]),
        poolArea: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('[0-9]')]),
        floor: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('[0-9]')]),
      }
    );
  }

  ngOnInit(): void {
  }

  createNewFacility() {
    this.serviceForm.value.image = this.serviceForm.controls.image.value.substr(12);
    console.log(this.serviceForm.value);
    if (this.serviceForm.valid) {
      this.facilityService.createNewFacility(this.serviceForm.value);
      this.router.navigateByUrl('');
    }
    console.log(this.facilityService.getAll());
  }
}
