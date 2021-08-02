import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ServiceService} from '../../../service/service-service/service.service';
import {RentType} from '../../../model/service/rent-type';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  serviceForm: FormGroup;
  id: number;
  rentTypes: RentType[];

  constructor(private serviceService: ServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.createForm();
    });
  }

  ngOnInit(): void {
    this.getListRentType();
    this.getService(this.id);
  }

  getListRentType() {
    this.serviceService.getListRentType().subscribe(rentTypes => {
      this.rentTypes = rentTypes;
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

  getService(id: number) {
    this.serviceService.findById(id).subscribe(service => {
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

  editService() {
    const service = this.serviceForm.value;
    this.serviceService.updateService(this.id, service).subscribe(() => {
        this.router.navigate(['service/list']);
    }, e => {
      console.log(e);
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
