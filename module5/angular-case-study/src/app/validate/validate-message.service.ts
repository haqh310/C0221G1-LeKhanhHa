import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidateMessageService{
  constructor() {
  }
  getMessage(){
    return {
      'codeCustomer' :[
        {'type': 'required', msg:'Not empty' },
        {'type': 'pattern', msg: 'Code customer must format KH-XXXX'}
      ],
      'object' : [
        {'type': 'required', msg:'Not empty' }
      ],
      'email' : [
        {'type': 'required', msg:'Not empty' },
        {'type': 'email', msg:'Email format email@' },
      ],
      'date': [
        {'type': 'required', msg:'Not empty' },
        {'type': 'pattern', msg:'Date must format date dd/MM/yyy' },
      ],
      'age':[
        {'type': 'validAge', msg:'Age must be great 18' },
      ],
      'number':[
        {'type': 'required', msg:'Not empty' },
        {'type': 'pattern', msg:'Input must format number' },
        {'type': 'min', msg:'Input must great 0' },
      ],
      'idCard':[
        {'type': 'required', msg:'Not empty' },
        {'type': 'pattern', msg:'Id Card must format XXXXXXXXX or XXXXXXXXXXXX' },
      ],
      'phone':[
        {'type': 'required', msg:'Not empty' },
        {'type': 'pattern', msg:'Phone must format (090 || 091)XXXXXXX' },
      ],
      'name' : [
        {'type': 'required', msg:'Not empty' },
      ]
    }
  }
}
