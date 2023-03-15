import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {GeneralsService} from "../../../service/generals/generals.service";
import {Router} from "@angular/router";
import {PositionService} from "../../../service/position/position.service";
import {Position} from "../../../model/position";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-generals-create',
  templateUrl: './generals-create.component.html',
  styleUrls: ['./generals-create.component.css']
})
export class GeneralsCreateComponent implements OnInit {
  generalsForm: FormGroup;
  positions: Position[] = [];
  defaultItem: Position;
  constructor(private generalsService: GeneralsService,
              private positionService: PositionService,
              private router: Router,
              private toast: ToastrService) { }

  ngOnInit(): void {
    this.generalsForm = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern('^NV-[0-9]{4}$')]),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required, Validators.min(0), Validators.pattern('')]),
      meetingDate: new FormControl('', [Validators.required, this.validateMeetingDate]),
      position: new FormControl('', [Validators.required]),
    });
    this.positionService.findAll().subscribe(next => {
      this.positions = next;
      this.defaultItem = this.positions[0];
    });
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

  createNewGenerals() {
    if (this.generalsForm.valid) {
      this.generalsService.addGenerals(this.generalsForm.value).subscribe(next => {
        this.router.navigateByUrl('generals/list')
        this.toast.success("Create successfully")
      });
    } else {
      this.toast.error("Create failed")
    }
  }

  compareFn(t1: Position, t2: Position): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
}
