package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee e where e.employee_name like %?1% && e.flag=1", nativeQuery = true)
    Page<Employee> findAllByKeyWord(String keyWord, Pageable pageable);

    @Query(value = "select * from employee e where  e.username = ?1 && e.flag=1",nativeQuery = true)
    Employee findEmployeeByUser(String username);
}
