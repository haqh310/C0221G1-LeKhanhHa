import {Component, Input, OnInit} from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
@Input() value: number;
@Input() active: string;
  rating: IRatingUnit;
  constructor() {
  }

  ngOnInit(): void {
    this.rating  = {
      value : this.value,
      active : this.active
    };
  }

  change(n: number) {
    this.rating.value = n;
  }
}
