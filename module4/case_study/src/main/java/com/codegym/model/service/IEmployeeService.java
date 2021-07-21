package com.codegym.model.service;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;

import java.util.List;

public interface IEmployeeService extends IGenerateService<Employee> {
    List<Division> listDivision();

    List<Position> listPosition();

    List<EducationDegree> listEducationDegree();

    Employee findEmployeeByUser(String username);
}
