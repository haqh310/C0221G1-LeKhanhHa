import {Division} from './division';
import {EducationDegree} from './education-degree';
import {Position} from './position';

export interface Employee {
  id?: number;
  employeeName?: string;
  employeeBirthday?: string;
  employeeIdCard?: string;
  employeeSalary?: number;
  employeePhone?: string;
  employeeEmail?: string;
  employeeAddress?: string;
  division?: Division;
  position?: Position;
  educationDegree?: EducationDegree;
}
