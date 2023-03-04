import {Customer} from './customer';
import {Facility} from './facility';
import {Employee} from './employee';

export interface Contract {
  id: number;
  startDate: string;
  endDate: string;
  deposit: number;
  totalMoney: number;
  employee: Employee;
  customer: Customer;
  service: Facility;
}
