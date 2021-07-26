import {Employee} from '../employee/employee';
import {Customer} from '../customer/customer';
import {Service} from '../service/service';

export interface Contract {
  id?: number;
  contractStartDate?: string;
  contractEndDate?: string ;
  contractDeposit?: number;
  contractTotalMoney?: number;
  customer?: Customer;
  employee?: Employee;
  service?: Service;
}
