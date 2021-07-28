import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../service/employee-service/employee.service';
import {Employee} from '../../../model/employee/employee';
import {ConfirmDialogService} from '../../../modal-delete/confirm/confirm-dialog.service';
import {OrderPipe} from 'ngx-order-pipe';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  p = 0;
  name: string;
  id: number;
  order: string = 'employeeName';
  reverse: boolean = false;
  constructor(private employeeService: EmployeeService,
              private confirmDialogService: ConfirmDialogService,
              private orderPipe: OrderPipe) {
  }

  ngOnInit(): void {
    this.getListEmployee();
    this.orderPipe.transform(this.employees, 'employeeName');
  }

  getListEmployee() {
    this.employeeService.getAll().subscribe(employees => {
        this.employees = employees;
      },
      error => {
        console.log(error);
      });
  }

  Search() {
    if (this.name === '') {
      this.ngOnInit();
    } else {
      this.employees = this.employees.filter(employee => {
        return employee.employeeName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
    this.p = 0;
  }

  openConfirmationDialog(employeeId: number, employeeName: string) {
    this.confirmDialogService.confirm('employee name: ' + employeeName)
      .then((confirmed) => {
        if (confirmed) {
          this.employeeService.deleteEmployee(employeeId).subscribe(() => {
            console.log('OK');
            this.ngOnInit();
          }, e => {
            console.log(e);
          });
        }
      }).catch(() => console.log('error'));
  }

  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }

    this.order = value;
  }
}
