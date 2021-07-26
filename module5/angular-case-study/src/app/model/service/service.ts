import {RentType} from './rent-type';

export interface Service {
  id?: number;
  serviceCode?: string;
  serviceName?: string;
  serviceArea?: number;
   serviceCost?: number;
   serviceMaxPeople?: number;
   serviceStatus?: string;
   rentType?: RentType;
}
