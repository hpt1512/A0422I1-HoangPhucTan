import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {

  constructor() { }

  inputNumber : any = '';

  ngOnInit(): void {
  }

  showInput(value : string) {
    this.inputNumber += value;
  }

  countResult(str : string) {
    if (str.includes("+")) {
      this.plus(str)
    }
    if (str.includes("-")) {
      this.minus(str)
    }
    if (str.includes("x")) {
      this.times(str)
    }
    if (str.includes("/")) {
      this.div(str)
    }
  }

  plus(str : string) {
    let str1 = str.slice(0, str.indexOf("+"));
    let str2 = str.slice(str.indexOf("+") + 1, str.length);
    
    this.inputNumber = parseInt(str1) + parseInt(str2);
  }

  minus(str : string) {
    let str1 = str.slice(0, str.indexOf("-"));
    let str2 = str.slice(str.indexOf("-") + 1, str.length);
    
    this.inputNumber = parseInt(str1) - parseInt(str2);
  }

  times(str : string) {
    let str1 = str.slice(0, str.indexOf("x"));
    let str2 = str.slice(str.indexOf("x") + 1, str.length);
    
    this.inputNumber = parseInt(str1) * parseInt(str2);
  }

  div(str : string) {
    let str1 = str.slice(0, str.indexOf("/"));
    let str2 = str.slice(str.indexOf("/") + 1, str.length);
    
    this.inputNumber = parseInt(str1) / parseInt(str2);
  }

  clearInput() {
    this.inputNumber = '';
  }

}
