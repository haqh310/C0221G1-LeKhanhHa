import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../../../service/contract-service/contract.service';
import {Router} from '@angular/router';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {EmployeeService} from '../../../service/employee-service/employee.service';
import {ServiceService} from '../../../service/service-service/service.service';
import {Customer} from '../../../model/customer/customer';
import {Employee} from '../../../model/employee/employee';
import {Service} from '../../../model/service/service';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  contractForm: FormGroup;
  customers: Customer[];
  employees: Employee[];
  services: Service[];
  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private employeeService: EmployeeService,
              private serviceService: ServiceService,
              private router: Router) { }

  ngOnInit(): void {
    this.getList();
    this.createForm();
  }
  getList(){
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
    this.employeeService.getAll().subscribe(employees => {
      this.employees = employees;
    });
    this.serviceService.getAll().subscribe(services => {
      this.services = services;
    });
  }
  createForm(){
    this.contractForm = new FormGroup({
      customer: new FormControl('', [Validators.required]),
      employee: new FormControl('', [Validators.required]),
      service: new FormControl('', [Validators.required]),
      contractStartDate: new FormControl('', [Validators.required]),
    contractEndDate: new FormControl('', [Validators.required]),
      contractDeposit: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
    }, this.validDate);
  }
  createContract(){
    const contract = this.contractForm.value;
    console.log(contract);
    this.contractService.saveContract(contract).subscribe(() => {
      this.router.navigate(['contract/list']);
    });
  }

  validDate(control : AbstractControl){
    const v = control.value;
    const start = new Date(v.contractStartDate);
    const end = new Date(v.contractEndDate);
    if(end.getTime() - start.getTime() <=0 ){
      return {'validDate': true};
    }
    return null;
  }
}
