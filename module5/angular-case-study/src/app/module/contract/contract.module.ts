import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ContractCreateComponent } from './contract-create/contract-create.component';
import { ContractDetailCreateComponent } from './contract-detail-create/contract-detail-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { ContractEditComponent } from './contract-edit/contract-edit.component';




@NgModule({
  declarations: [ContractListComponent, ContractCreateComponent, ContractDetailCreateComponent, ContractEditComponent],
  imports: [
    CommonModule,
    ContractRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class ContractModule { }
