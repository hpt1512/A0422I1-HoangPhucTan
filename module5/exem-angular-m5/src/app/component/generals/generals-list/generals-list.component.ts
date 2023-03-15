import { Component, OnInit } from '@angular/core';
import {Generals} from "../../../model/generals";
import {GeneralsService} from "../../../service/generals/generals.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {element} from "protractor";

@Component({
  selector: 'app-generals-list',
  templateUrl: './generals-list.component.html',
  styleUrls: ['./generals-list.component.css']
})
export class GeneralsListComponent implements OnInit {
  generals: Generals[] = [];
  delId: string;
  formSearch: FormGroup;
  constructor(private generalsService: GeneralsService,
              private router: Router) { }

  ngOnInit(): void {
    this.findAll();
    this.formSearch = new FormGroup({
      nameSearch: new FormControl()
    })
  }

  findAll() {
    this.generalsService.findAll().subscribe(next => {
      this.generals = next;
    })
  }

  infoDelete(id: string, name: string) {
    this.delId = id;
    document.getElementById("delName").innerText = name;
  }

  deleteGenerals(delId: string) {
    this.generalsService.deleteGenerals(delId).subscribe(next => {
      this.findAll();
    });
  }

  showEditPage(id: string) {
    this.router.navigate(['generals/edit', id])
  }

  searchGenerals() {
    this.generalsService.searchGenerals(this.formSearch.value.nameSearch).subscribe(next => {
      this.generals = next;
    })
  }
}
