package com.codegym.model.entity.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceTypeId;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

    public ServiceType() {
    }
}
