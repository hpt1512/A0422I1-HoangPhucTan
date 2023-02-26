import {RentType} from './rent-type';
import {ServiceType} from './service-type';

export interface Facility {
  id: number;
  name: string;
  image: string;
  area: number;
  cost: number;
  peopleMax: number;
  rentType: RentType;
  serviceType: ServiceType;
  standardRoom: string;
  descriptionOtherConvenience: string;
  poolArea: number;
  floor: number;
}
