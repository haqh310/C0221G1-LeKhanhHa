import { Component, OnInit } from '@angular/core';
import {Service} from '../../../model/service/service';
import {ServiceService} from '../../../service/service-service/service.service';
import {RentType} from '../../../model/service/rent-type';
import {ConfirmDialogService} from '../../../modal-delete/confirm/confirm-dialog.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: Service[];
  name: string ;
  p = 0;
  constructor(private serviceService: ServiceService,
              private confirmDialogService: ConfirmDialogService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.serviceService.getAll().subscribe(services => {
      this.services = services;
    });
  }

  Search() {
    if (this.name === ''){
      this.ngOnInit();
    }else {
      this.services = this.services.filter(service => {
        return service.serviceName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
  }

  openConfirmationDialog(serviceId: number, serviceName: string) {
    this.confirmDialogService.confirm('service name: ' + serviceName)
      .then((confirmed) => {
        if (confirmed){
          this.serviceService.deleteService(serviceId).subscribe(() => {
            console.log('OK');
            this.ngOnInit();
          }, e => {
            console.log(e);
          });
        }
      }).catch(() => console.log('error'));
  }
}
