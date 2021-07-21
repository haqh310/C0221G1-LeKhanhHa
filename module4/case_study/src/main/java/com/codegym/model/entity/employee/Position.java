package com.codegym.model.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;
    public Position() {
    }

}
