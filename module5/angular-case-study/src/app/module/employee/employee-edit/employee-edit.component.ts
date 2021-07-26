import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Division} from '../../../model/employee/division';
import {Position} from '../../../model/employee/position';
import {EducationDegree} from '../../../model/employee/education-degree';
import {EmployeeService} from '../../../service/employee-service/employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Employee} from '../../../model/employee/employee';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employeeForm: FormGroup;
  id: number;
  divisions: Division[] = [];
  positions: Position[] = [];
  eductionDegrees: EducationDegree[] = [];

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.createForm();
    this.getList();
    this.getEmployee(this.id);
  }

  createForm() {
    this.employeeForm = new FormGroup({
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
  }

  getList() {
    this.employeeService.getListDivision().subscribe(divisions => {
      this.divisions = divisions;
    });
    this.employeeService.getListPosition().subscribe(positions => {
      this.positions = positions;
    });
    this.employeeService.getListEducationDegree().subscribe(educations => {
      this.eductionDegrees = educations;
    });
  }

  getEmployee(id: number) {
    this.employeeService.findById(id).subscribe(employee => {
      this.employeeForm.setValue({
        employeeName: employee.employeeName,
        employeeBirthday: employee.employeeBirthday,
        employeeIdCard: employee.employeeIdCard,
        employeeSalary: employee.employeeSalary,
        employeePhone: employee.employeePhone,
        employeeEmail: employee.employeeEmail,
        employeeAddress: employee.employeeAddress,
        division: employee.division,
        position: employee.position,
        educationDegree: employee.educationDegree
      });
    });
  }

  editEmployee() {
    const employee = this.employeeForm.value;
    this.employeeService.updateEmployee(this.id, employee).subscribe(() => {
      this.router.navigate(['employee/list']);
    }, e => {
      console.log(e);
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
