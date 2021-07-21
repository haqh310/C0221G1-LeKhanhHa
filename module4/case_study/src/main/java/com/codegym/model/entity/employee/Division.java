package com.codegym.model.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Division() {
    }


}
