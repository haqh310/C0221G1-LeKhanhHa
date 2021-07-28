import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomerService} from '../../../service/customer-service/customer.service';
import {ConfirmDialogService} from '../../../modal-delete/confirm/confirm-dialog.service';
import {MatDialog} from '@angular/material/dialog';
import {DialogExampleComponent} from '../../../dialog-example/dialog-example.component';

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
              private confirmDialogService: ConfirmDialogService,
              private dialog: MatDialog) {
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
    // if (this.name === '') {
    //   this.ngOnInit();
    // } else {
    //   this.customers = this.customers.filter(customer => {
    //     return customer.customerName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
    //   });
    // }
    this.customerService.searchByName(this.name).subscribe(customers => {
      this.customers = customers;
    });
    this.p = 0;
  }

  openConfirmationDialog(customerId: number, customerName: string) {
    this.confirmDialogService.confirm('customer name: ' + customerName)
      .then((confirmed) => {
        if (confirmed) {
          this.customerService.deleteCustomer(customerId).subscribe(() => {
            console.log('OK');
            this.ngOnInit();
          }, e => {
            console.log(e);
          });
        }
      }).catch(() => console.log('error'));
  }


  removeCustomer(id: number, customerName: string) {

    const confirmDialog = this.dialog.open(DialogExampleComponent, {
      data: {
        title: 'Accept delete Customer',
        message: 'Are you sure, you want to remove an customer: ' + customerName
      }
    });

    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.customerService.deleteCustomer(id).subscribe(() => {
          console.log('OK');
          this.ngOnInit();
        });
      }
    });
  }
}
