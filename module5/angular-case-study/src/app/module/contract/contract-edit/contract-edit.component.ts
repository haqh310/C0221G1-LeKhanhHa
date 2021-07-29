import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../../model/customer/customer';
import {Employee} from '../../../model/employee/employee';
import {Service} from '../../../model/service/service';
import {ContractService} from '../../../service/contract-service/contract.service';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {EmployeeService} from '../../../service/employee-service/employee.service';
import {ServiceService} from '../../../service/service-service/service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Contract} from '../../../model/contract/contract';

@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.css']
})
export class ContractEditComponent implements OnInit {
  contractForm: FormGroup;
  customers: Customer[];
  employees: Employee[];
  services: Service[];
  id:number;
  contract !: Contract;
  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private employeeService: EmployeeService,
              private serviceService: ServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
  this.id = +paramMap.get('id'); });
  this.getContract();
  }

  ngOnInit(): void {
    this.getList();
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
    });
  }

  getContract(){
    this.createForm();
    this.contractService.findById(this.id).subscribe(contract =>{
      this.contractForm.setValue({
        customer: contract.customer,
        employee: contract.employee,
        service: contract.service,
        contractStartDate: contract.contractStartDate,
        contractEndDate: contract.contractEndDate,
        contractDeposit: contract.contractDeposit
      });
    });
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
  editContract(){
    const contract = this.contractForm.value;
    this.contractService.updateContract(this.id, contract).subscribe(() => {
      this.router.navigate(['contract/list']);
    }, e => {
      console.log(e);
    });
  }
}
