import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Division} from '../../../model/employee/division';
import {EducationDegree} from '../../../model/employee/education-degree';
import {Position} from '../../../model/employee/position';
import {EmployeeService} from '../../../service/employee-service/employee.service';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employeeForm: FormGroup = new FormGroup({
    employeeName: new FormControl('', [Validators.required]),
    // tslint:disable-next-line:max-line-length
    employeeBirthday: new FormControl('', [Validators.required, Validators.pattern('^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$')]),
    employeeIdCard: new FormControl('', [Validators.required, Validators.pattern('^([0-9]{9}|[0-9]{12})$')]),
    employeeSalary: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
    employeePhone: new FormControl('', [Validators.required, Validators.pattern('^(090|091)[0-9]{7}$')]),
    employeeEmail: new FormControl('', [Validators.required, Validators.email]),
    employeeAddress: new FormControl(''),
    division: new FormControl('', [Validators.required]),
    position: new FormControl('', [Validators.required]),
    educationDegree: new FormControl('', [Validators.required]),
  });
  divisions: Division[] = [];
  positions: Position[] = [];
  eductionDegrees: EducationDegree[] = [];
  constructor(private employeeService: EmployeeService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.getList();
  }
  getList(){
    this.employeeService.getListDivision().subscribe(divisions => {
      this.divisions = divisions;
    });
    this.employeeService.getListPosition().subscribe(positions => {
      this.positions = positions;
    });
    this.employeeService.getListEducationDegree().subscribe(eductionDegrees => {
      this.eductionDegrees = eductionDegrees;
    });
  }

  createEmployee() {
    const employee = this.employeeForm.value;
    console.log(employee);
    this.employeeService.saveEmployee(employee).subscribe(() => {
       this.router.navigate(['employee/list']);
     });
  }
}
