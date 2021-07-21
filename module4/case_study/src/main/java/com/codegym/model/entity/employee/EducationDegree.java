package com.codegym.model.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationDegreeId;
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees;

    public EducationDegree() {
    }

}
