import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../../model/customer/customer-type';
import {ValidateMessageService} from '../../../validate/validate-message.service';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup;
  customerTypes: CustomerType[] = [];
  constructor(private customerService: CustomerService,
              private router: Router,
              public validMsg: ValidateMessageService) {
    this.createForm();
  }

  ngOnInit(): void {
    this.getCustomerType();
  }

  createForm() {
    this.customerForm = new FormGroup({
      customerCode: new FormControl('', [Validators.required, Validators.pattern('^KH-[0-9]{4}$')]),
      customerName: new FormControl('', [Validators.required]),
      dateOfBirth: new FormControl('', [Validators.required, Validators.pattern('^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$'), this.validAge]),
      customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^([0-9]{9}|[0-9]{12})$')]),
      customerPhone: new FormControl('', [Validators.required, Validators.pattern('^(090|091)[0-9]{7}$')]),
      customerEmail: new FormControl('', [Validators.required, Validators.email]),
      customerAddress: new FormControl(''),
      customerType: new FormControl('', [Validators.required]),
    });
  }

  createCustomer() {
    const customer = this.customerForm.value;
    this.customerService.saveCustomer(customer).subscribe(() => {
      // this.customerForm.reset();
      this.router.navigate(['customer/list']);
    }, e => {
      console.log(e);
    });
  }

  getCustomerType() {
    this.customerService.getCustomerType().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }

  validAge(control: AbstractControl) {
    const date = control.value;
    const today = new Date();
    const birthDate = new Date(date);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    if (age < 18) {
      return {'validAge': true};
    } else {
      return null;
    }
  }

  checkValid(attribute : string, error: string){
    return (this.customerForm.get(attribute).hasError(error) && (this.customerForm.get(attribute).touched || this.customerForm.get(attribute).dirty));
  }
}
