import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ServiceListComponent} from './service-list/service-list.component';
import {ServiceCreateComponent} from './service-create/service-create.component';
import {ServiceEditComponent} from './service-edit/service-edit.component';


const routes: Routes = [
  {
    path: 'list',
    component: ServiceListComponent
  },
  {
    path: 'create',
    component: ServiceCreateComponent
  },
  {
    path: 'edit/:id',
    component: ServiceEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceRoutingModule { }
