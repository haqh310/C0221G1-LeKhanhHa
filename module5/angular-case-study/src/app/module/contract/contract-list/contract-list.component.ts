import { Component, OnInit } from '@angular/core';
import {ContractService} from '../../../service/contract-service/contract.service';
import {Contract} from '../../../model/contract/contract';
import {ContractDetail} from '../../../model/contract/contract-detail';
import {DialogExampleComponent} from '../../../dialog-example/dialog-example.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts : Contract[];
  contractDetails: ContractDetail[];
  name: string;
  p= 0;
  constructor(private contractService: ContractService,
              private dialog : MatDialog) { }

  ngOnInit(): void {
    this.getAll();
    this.getListDetail();
  }
  getAll(){
    this.contractService.getListContract().subscribe(contracts => {
      this.contracts = contracts;
    });
  }
  getListDetail(){
    this.contractService.getListContractDetail().subscribe( contractDetails => {
      this.contractDetails = contractDetails;
    })
  }

  Search() {
    this.contractService.searchByName(this.name).subscribe(contracts => {
      this.contracts = contracts;
    });
    this.p = 0;
  }
  removeCustomer(id: number, customerName: string) {

    const confirmDialog = this.dialog.open(DialogExampleComponent, {
      data: {
        title: 'Accept delete Contract',
        message: 'Are you sure, you want to remove an contract is customer name: ' + customerName
      }
    });

    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.contractService.deleteContract(id).subscribe(() => {
          console.log('OK');
          this.ngOnInit();
        });
      }
    });
  }
}
