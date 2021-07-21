package com.codegym.model.entity.employee;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;
    private boolean flag;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Employee() {
    }
}
