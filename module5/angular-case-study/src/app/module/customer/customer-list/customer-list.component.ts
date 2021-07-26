import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {ConfirmDialogService} from '../../../modal-delete/confirm/confirm-dialog.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  p = 0;
  name: string;
  constructor(private customerService: CustomerService,
              private confirmDialogService: ConfirmDialogService) {
  }

  ngOnInit(): void {
    this.getListCustomer();
  }

  getListCustomer() {
    this.customerService.getAll().subscribe(response => {
        this.customers = response;
      },
      error => {
        console.log(error);
      });
  }

  Search() {
    if (this.name === ''){
      this.ngOnInit();
    }else {
      this.customers = this.customers.filter(customer => {
        return customer.customerName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
    this.p = 0;
  }

  openConfirmationDialog(customerId: number, customerName: string) {
    this.confirmDialogService.confirm('customer name: ' + customerName)
      .then((confirmed) => {
        if (confirmed){
          this.customerService.deleteCustomer(customerId).subscribe(() => {
            console.log('OK');
            this.ngOnInit();
          }, e => {
            console.log(e);
          });
        }
      }).catch(() => console.log('error'));
  }

}
