import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  navList = [
    {
      name: "ANGULAR INTRODUTION",
      url: "https://angular.io/tutorial/tour-of-heroes"
    },
    {
      name: "ANGULAR CREATE PROJECT",
      url: "https://angular.io/tutorial/tour-of-heroes/toh-pt0"
    },
    {
      name: "ANGULAR DISPLAY SELECTION LIST",
      url: "https://angular.io/tutorial/tour-of-heroes/toh-pt2"
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
