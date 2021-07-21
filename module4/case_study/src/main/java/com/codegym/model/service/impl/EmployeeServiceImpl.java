package com.codegym.model.service.impl;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.repository.employee.IDivisionRepository;
import com.codegym.model.repository.employee.IEducationDegreeRepository;
import com.codegym.model.repository.employee.IEmployeeRepository;
import com.codegym.model.repository.employee.IPositionRepository;
import com.codegym.model.service.IEmployeeService;
import com.codegym.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IDivisionRepository divisionRepository;
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Autowired
    private IUserService userService;

    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByUser(String username) {
        return employeeRepository.findEmployeeByUser(username);
    }

    @Override
    public Page<Employee> findAll(String keyWord, Pageable pageable) {
        return employeeRepository.findAllByKeyWord(keyWord, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        userService.save(employee.getUser());
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        Employee employee = this.findById(id);
        employee.setFlag(false);
        save(employee);
    }

}
