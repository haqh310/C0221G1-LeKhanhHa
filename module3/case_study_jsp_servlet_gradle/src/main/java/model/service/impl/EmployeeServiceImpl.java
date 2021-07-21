package model.service.impl;

import model.bean.User.User;
import model.bean.employee.*;
import model.repository.EmployeeRepository;
import model.service.Interface.IEmployeeService;
import model.service.common.Validate;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    Validate validate = new Validate();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
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
    public List<String> insert(Employee employee) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateDate(employee.getEmployee_birthday()));
        messages.add(validate.validateIdCard(employee.getEmployee_id_card()));
        messages.add(validate.validateTypeDouble(employee.getEmployee_salary()));
        messages.add(validate.validatePhone(employee.getEmployee_phone()));
        messages.add(validate.validateEmail(employee.getEmployee_email()));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( employeeRepository.insert(employee)){
                messages.add("New employee was created");
            }
        }
        return messages;
    }

    @Override
    public List<String> update(int employee_id, Employee employee) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateDate(employee.getEmployee_birthday()));
        messages.add(validate.validateIdCard(employee.getEmployee_id_card()));
        messages.add(validate.validateTypeDouble(employee.getEmployee_salary()));
        messages.add(validate.validatePhone(employee.getEmployee_phone()));
        messages.add(validate.validateEmail(employee.getEmployee_email()));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( employeeRepository.update(employee_id,employee)){
                messages.add("Employee information was updated");
            }
        }
        return messages;
    }

    @Override
    public boolean remove(int employee_id) {
        return employeeRepository.delete(employee_id);
    }

    @Override
    public List<Position> findAllPosition() {
        return employeeRepository.findAllPosition();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return employeeRepository.findAllEducationDegree();
    }

    @Override
    public List<Division> findAllDivision() {
        return employeeRepository.findAllDivision();
    }

    @Override
    public List<User> findAllUser() {
        return employeeRepository.findUser();
    }
}
