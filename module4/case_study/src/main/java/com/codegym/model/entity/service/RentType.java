package com.codegym.model.entity.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String rentTypeName;
    private String rentTypeCost;
    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;

    public RentType() {
    }
}
