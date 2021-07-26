import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {RentType} from '../../../model/service/rent-type';
import {ServiceService} from '../../../service/service-service/service.service';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  serviceForm: FormGroup;
  rentTypes: RentType[];
  constructor(private serviceService: ServiceService,
              private router: Router) { }

  ngOnInit(): void {
    this.createForm();
    this.getListRentType();
  }
  createForm(){
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
  getListRentType(){
    this.serviceService.getListRentType().subscribe(rentTypes => {
      this.rentTypes = rentTypes;
    });
  }

  createService() {
    const service = this.serviceForm.value;
    this.serviceService.saveService(service).subscribe(() => {
      alert('successfully');
      this.router.navigate(['service/list']);
    });
  }
}
