import { Component, OnInit } from '@angular/core';
import {CustomerType} from '../../../model/customer/customer-type';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerForm = new FormGroup({
    customerCode: new FormControl('', [Validators.required, Validators.pattern('^KH-[0-9]{4}$')]),
    customerName: new FormControl('', [Validators.required]),
    dateOfBirth: new FormControl('', [Validators.required, Validators.pattern('^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$')]),
    customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^([0-9]{9}|[0-9]{12})$')]),
    customerPhone: new FormControl('', [Validators.required, Validators.pattern('^(090|091)[0-9]{7}$')]),
    customerEmail: new FormControl('', [Validators.required, Validators.email]),
    customerAddress: new FormControl(''),
    customerType: new FormControl('', [Validators.required]),
  });
  customerTypes: CustomerType[] = [];
  id: number;
  selectedValue: CustomerType;
  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    });
  }
  ngOnInit(): void {
    this.getCustomerType();
  }
  getCustomerType(){
    this.customerService.getCustomerType().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }
  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.selectedValue = customer.customerType;
      this.customerForm.setValue({
        customerCode: customer.customerCode,
        customerName: customer.customerName,
        dateOfBirth: customer.dateOfBirth,
        customerIdCard: customer.customerIdCard,
        customerPhone: customer.customerPhone,
        customerEmail: customer.customerEmail,
        customerAddress: customer.customerAddress,
        customerType: customer.customerType
      });
    });
  }
  editCustomer(){
    const customer = this.customerForm.value;
    this.customerService.updateCustomer(this.id, customer).subscribe(() => {
      this.router.navigate(['customer/list']);
    }, e => {
      console.log(e);
    });
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
