import { Injectable } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ModalDeleteComponent} from '../modal-delete.component';

@Injectable({
  providedIn: 'root'
})
export class ConfirmDialogService {
  constructor(private modalService: NgbModal) { }

  public confirm(
    message: string,
    dialogSize: 'sm'|'md' = 'md'): Promise<boolean> {
    const modalRef = this.modalService.open(ModalDeleteComponent, { size: dialogSize });
    modalRef.componentInstance.message = message;
    return modalRef.result;
  }
}
