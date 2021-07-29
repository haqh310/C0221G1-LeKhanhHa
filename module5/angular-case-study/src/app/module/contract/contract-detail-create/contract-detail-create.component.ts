import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../../../service/contract-service/contract.service';
import {Contract} from '../../../model/contract/contract';
import {AttachService} from '../../../model/contract/attach-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-detail-create',
  templateUrl: './contract-detail-create.component.html',
  styleUrls: ['./contract-detail-create.component.css']
})
export class ContractDetailCreateComponent implements OnInit {
  contractDetailForm: FormGroup;
  contracts: Contract[];
  attachService: AttachService[];
  constructor(private contractService: ContractService,
              private router: Router) { }

  ngOnInit(): void {
  this.getList();
  this.createForm();
  }
  getList(){
    this.contractService.getAttachService().subscribe(attachServices => {
      console.log(attachServices);
      this.attachService = attachServices;
    });
    this.contractService.getListContract().subscribe(contracts => {
      console.log(contracts);
      this.contracts = contracts;
    });
  }
  createForm(){
    this.contractDetailForm = new FormGroup({
      contractId: new FormControl('', [Validators.required]) ,
      quantity: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
      attachService: new FormControl('', [Validators.required])
    });
  }
  createContractDetail(){
    const contractDetail = this.contractDetailForm.value;
    this.contractService.saveContractDetail(contractDetail).subscribe(() => {
      this.router.navigate(['contract/list']);
      alert("Create new contract detail successfully!!!");
    });
  }

}
