import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  number = 0;
  time: string;
  title = 'angular-rating-bar';

  display(seconds: number) {
    this.time = seconds + 's';
  }
}
