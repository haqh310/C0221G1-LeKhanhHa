package model.service.impl;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repository.EmployeeRepository;
import model.service.IService;

import java.util.List;

public class EmployeeServiceImpl implements IService<Employee> {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean save(Employee employee) {
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee findById(int employee_id) {
        return employeeRepository.findById(employee_id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public boolean update(int employee_id, Employee employee) {
        return employeeRepository.update(employee_id, employee);
    }

    @Override
    public boolean remove(int employee_id) {
        return employeeRepository.delete(employee_id);
    }

    public List<Position> findAllPosition() {
        return employeeRepository.findAllPosition();
    }

    public List<EducationDegree> findAllEducationDegree() {
        return employeeRepository.findAllEducationDegree();
    }

    public List<Division> findAllDivision() {
        return employeeRepository.findAllDivision();
    }
}
