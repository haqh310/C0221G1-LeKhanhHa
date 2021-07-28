import { Component, OnInit } from '@angular/core';
import {ContractService} from '../../../service/contract-service/contract.service';
import {Contract} from '../../../model/contract/contract';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts : Contract[];
  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.contractService.getListContract().subscribe(contracts => {
      this.contracts = contracts;
    });
  }
}
