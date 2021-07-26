import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../../model/customer/customer-type';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
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
  constructor(private customerService: CustomerService,
              private router: Router) {

  }
  ngOnInit(): void {
    this.getCustomerType();
  }
  createCustomer(){
    const customer = this.customerForm.value;
    this.customerService.saveCustomer(customer).subscribe(() => {
      // this.customerForm.reset();
      this.router.navigate(['customer/list']);
    }, e => {
      console.log(e);
    });
  }
  getCustomerType(){
    this.customerService.getCustomerType().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }
}
