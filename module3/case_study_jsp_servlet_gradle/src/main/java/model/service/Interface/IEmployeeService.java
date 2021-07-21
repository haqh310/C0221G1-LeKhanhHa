package model.service.Interface;

import model.bean.User.User;
import model.bean.employee.*;

import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    @Override
    List<Employee> findAll();

    @Override
    Employee findById(int id);

    @Override
    List<Employee> findByName(String name);

    @Override
    List<String> insert(Employee employee);

    @Override
    List<String> update(int id, Employee employee);

    @Override
    boolean remove(int id);

    List<Position> findAllPosition();

    List<EducationDegree> findAllEducationDegree();

    List<Division> findAllDivision();
    List<User> findAllUser();
}
