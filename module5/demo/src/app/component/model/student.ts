import {Classroom} from './classroom';
export interface Student {
  id?: number,
  name?:string,
  point: number,
  dateOfBirth?: string,
  classroom?: Classroom
}
