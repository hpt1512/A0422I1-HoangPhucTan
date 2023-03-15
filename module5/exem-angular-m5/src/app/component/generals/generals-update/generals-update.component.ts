import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {GeneralsService} from "../../../service/generals/generals.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Generals} from "../../../model/generals";
import {Position} from "../../../model/position";
import {PositionService} from "../../../service/position/position.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-generals-update',
  templateUrl: './generals-update.component.html',
  styleUrls: ['./generals-update.component.css']
})
export class GeneralsUpdateComponent implements OnInit {
  generalsForm: FormGroup;
  generals: Generals;
  positions: Position[] = [];

  constructor(private generalsService: GeneralsService,
              private activatedRoute: ActivatedRoute,
              private positionService: PositionService,
              private router: Router,
              private toast: ToastrService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      if (id != null) {
        this.generalsService.findById(id).subscribe(next => {
          this.generals = next;
          this.generalsForm = new FormGroup({
            id: new FormControl(this.generals.id, [Validators.required, Validators.pattern('')]),
            name: new FormControl(this.generals.name, [Validators.required]),
            price: new FormControl(this.generals.price, [Validators.required, Validators.min(0), Validators.pattern('')]),
            meetingDate: new FormControl(this.generals.meetingDate, [Validators.required, this.validateMeetingDate]),
            position: new FormControl(this.generals.position, [Validators.required]),
          });
        })
      }
    }, error => {

    },() => {

    })
  }
  validateMeetingDate(control: AbstractControl) {
    const meetingDate = control.value;
    let date = new Date();
    let newMeetingDate = new Date(meetingDate);
    if (newMeetingDate.getTime() >= date.getTime()) {
      return null;
    } else {
      return {meetingDateValid: true};
    }
  }

  ngOnInit(): void {
    this.positionService.findAll().subscribe(next => {
      this.positions = next;
    })
  }

  compareFn(t1: Position, t2: Position): boolean {
    return t1 && t2 ? t1.name === t2.name : t1 === t2;
  }

  updateGenerals() {
    if (this.generalsForm.valid) {
      this.generalsService.updateGenerals(this.generals.id, this.generalsForm.value).subscribe(next => {
        this.router.navigateByUrl('generals/list');
        this.toast.success("Update successfully");
      });
    } else {
      this.toast.error("Update Failed");
    }
  }
}
