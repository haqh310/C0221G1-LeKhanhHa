import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {AttachService} from '../../model/contract/attach-service';
import {Contract} from '../../model/contract/contract';
import {ContractDetail} from '../../model/contract/contract-detail';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private http: HttpClient) { }
  getListContract(): Observable<Contract[]> {
    return this.http.get<Contract[]>(API_URL + '/contracts');
  }
  saveContract(contract): Observable<Contract> {
    return this.http.post<Contract>(API_URL + '/contracts', contract);
  }
  getListContractDetail(): Observable<ContractDetail[]> {
    return this.http.get<ContractDetail[]>(API_URL + '/contract-details');
  }
  saveContractDetail(contractDetail): Observable<ContractDetail> {
    return this.http.post<ContractDetail>(API_URL + '/contract-details', contractDetail);
  }
  findById(id: number): Observable<Contract> {
    return this.http.get<Contract>(`${API_URL}/contracts/${id}`);
  }
  updateCustomer(id: number, contract: Contract): Observable<Contract> {
    return this.http.put<Contract>(`${API_URL}/contracts/${id}`, contract);
  }

  deleteContract(id: number): Observable<Contract> {
    return this.http.delete<Contract>(`${API_URL}/contracts/${id}`);
  }
  getAttachService(): Observable<AttachService[]>{
    return this.http.get<AttachService[]>(API_URL + '/attach-services');
  }
}
