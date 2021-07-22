import { Component, OnInit } from '@angular/core';
export interface Number {
  number1 : number;
  number2 : number;
  result : string;
}
@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
 number :Number ={
   number1 : 0,
   number2 :0,
   result : '0'
};
  constructor() { }

  ngOnInit(): void {
  }

  result(s: string) {
    switch (s) {
      case '+' :
        this.number.result = this.number.number1 + this.number.number2+"";
        break;
      case '-' :
        this.number.result = this.number.number1 - this.number.number2+"";
        break;
      case '*' :
        this.number.result = this.number.number1 * this.number.number2+"";
        break;
      case '/' :
        if(this.number.number2 == 0){
          this.number.result = "Number 2 can't equal 0";
        }else {
          this.number.result = this.number.number1 / this.number.number2+"";
        }
        break;
    }
  }
}
