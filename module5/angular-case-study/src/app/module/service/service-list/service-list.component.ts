import {Component, OnInit} from '@angular/core';
import {Service} from '../../../model/service/service';
import {ServiceService} from '../../../service/service-service/service.service';
import {RentType} from '../../../model/service/rent-type';
import {ConfirmDialogService} from '../../../modal-delete/confirm/confirm-dialog.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: Service[];
  name: string;
  p = 0;
  idDelete: number;
  message: string;
  serviceForm: FormGroup;
  rentTypes: RentType[];
  id: number;
  constructor(private serviceService: ServiceService,
              private confirmDialogService: ConfirmDialogService) {
    this.createForm();
    this.getListRentType();
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.serviceService.getAll().subscribe(services => {
      this.services = services;
    });
  }

  Search() {
    if (this.name === '') {
      this.ngOnInit();
    } else {
      this.services = this.services.filter(service => {
        return service.serviceName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
    this.p = 0;
  }

  openConfirmationDialog(serviceId: number, serviceName: string) {
    this.confirmDialogService.confirm('service name: ' + serviceName)
      .then((confirmed) => {
        if (confirmed) {
          this.serviceService.deleteService(serviceId).subscribe(() => {
            console.log('OK');
            this.ngOnInit();
          }, e => {
            console.log(e);
          });
        }
      }).catch(() => console.log('error'));
  }

  deleteId(id: number, serviceName: string) {
    this.idDelete = id;
    this.message = serviceName;
  }

  deleteService() {
    this.serviceService.deleteService(this.idDelete).subscribe(() => {
      console.log('OK');
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }
  createForm() {
    this.serviceForm = new FormGroup({
      serviceCode: new FormControl('', [Validators.required, Validators.pattern('^DV-[0-9]{4}$')]),
      serviceName: new FormControl('', [Validators.required]),
      serviceArea: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
      serviceCost: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
      serviceMaxPeople: new FormControl('', [Validators.required, Validators.pattern('[0-9]+'), Validators.min(0)]),
      serviceStatus: new FormControl(''),
      rentType: new FormControl('')
    });
  }
  getListRentType() {
    this.serviceService.getListRentType().subscribe(rentTypes => {
      this.rentTypes = rentTypes;
    });
  }
  getService(id: number) {
    this.serviceService.findById(id).subscribe(service => {
      this.id = service.id;
      this.serviceForm.setValue({
        serviceCode: service.serviceCode,
        serviceName: service.serviceName,
        serviceArea: service.serviceArea,
        serviceCost: service.serviceCost,
        serviceMaxPeople: service.serviceMaxPeople,
        serviceStatus: service.serviceStatus,
        rentType: service.rentType
      });
    });
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
  editService() {
    const service = this.serviceForm.value;
    this.serviceService.updateService(this.id, service).subscribe(() => {
      document.getElementById("btnClose").click();
     setTimeout( ()=>{alert('Successfully')},200);
     this.getAll();
    }, e => {
      console.log(e);
    });
  }
}
