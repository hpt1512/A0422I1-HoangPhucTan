import {Component, Input, OnInit} from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Input()
  max = 10;
  ratingUnits: IRatingUnit[] = [];
  resultRating = 0;
  colorRating = '#606060';
  colorRatingPicked = '#EB49AF';
  constructor() {
    for (let i = 1; i <= this.max; i++) {
      this.ratingUnits.push({value: i, active: false});
    }
  }

  ngOnInit(): void {
  }
  resetRating() {
    this.resultRating = 0;
    this.ratingUnits.forEach((item) => {
        item.active = false;
    });
  }
  doRating(ratingItem: IRatingUnit) {
    this.resetRating();
    this.resultRating = Number(ratingItem.value);
    this.ratingUnits.forEach((item) => {
      if (item.value <= ratingItem.value) {
        item.active = true;
      }
    });
    console.log(this.resultRating);
  }
}
