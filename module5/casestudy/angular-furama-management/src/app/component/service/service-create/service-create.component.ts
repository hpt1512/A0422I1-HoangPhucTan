import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentTypeService} from '../../../service/rent-type/rent-type.service';
import {ServiceTypeService} from '../../../service/service-type/service-type.service';
import {FacilityService} from '../../../service/facility/facility.service';
import {Router} from '@angular/router';
import {ServiceListComponent} from "../service-list/service-list.component";
import {ToastrService} from "ngx-toastr";

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
              private router: Router,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.serviceForm = new FormGroup({
        id: new FormControl('', [Validators.required]),
        name: new FormControl('', [Validators.required, Validators.pattern('^[^0-9()]+$')]), // Ko dc co so
        image: new FormControl('', [Validators.required]),
        area: new FormControl('', [Validators.required, Validators.min(0)]),
        cost: new FormControl('', [Validators.required, Validators.min(0)]),
        peopleMax: new FormControl('', [Validators.required, Validators.min(0)]),
        rentType: new FormControl('', [Validators.required]),
        serviceType: new FormControl('', [Validators.required]),
        standardRoom: new FormControl('', [Validators.required, Validators.pattern('^0[0-9\\-\\+]{9}$')]), // SDT
        descriptionOtherConvenience: new FormControl('', [Validators.required]),
        poolArea: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('^[0-9()]+$')]), // So nguyen
        floor: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('^[0-9()]+$')]),
      }
    );
  }

  createNewFacility() {
    this.serviceForm.value.image = this.serviceForm.controls.image.value.substr(12);
    console.log(this.serviceForm.value);
    if (this.serviceForm.valid) {
      this.facilityService.createNewFacility(this.serviceForm.value);
      this.offFormCreate();
      this.toast.success("Thêm mới dịch vụ thành công");
    } else {
      this.toast.error("Dữ liệu không hợp lệ, vui lòng kiểm tra lại")
    }
    console.log(this.facilityService.getAll());
  }

  offFormCreate() {
    this.ngOnInit()
    ServiceListComponent.offFormCreate();
  }
}
