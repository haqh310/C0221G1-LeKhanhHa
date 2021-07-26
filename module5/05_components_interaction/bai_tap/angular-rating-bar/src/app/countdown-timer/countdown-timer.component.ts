import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  @Input() seconds: number;
  @Output() countChanged: EventEmitter<number> = new EventEmitter();
  polling: any;
  number: number;
  flag = true;
  constructor() {
  }
  ngOnInit(): void {
  }

  startTime() {
    this.number = this.seconds;
    this.flag = false;
    this.polling = setInterval(() => {
      if (this.seconds === 0) {
        clearInterval(this.polling);
      }
      this.seconds--;
      this.countChanged.emit(this.seconds);
    }, 1000);
  }

  resetTime() {
    this.seconds = this.number;
    this.flag = true;
    clearInterval(this.polling);
  }

  pauseTime() {
    this.flag = true;
    clearInterval(this.polling);
  }
}
