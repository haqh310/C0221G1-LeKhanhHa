package com.codegym.model.entity.service;

import com.codegym.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;
    private String serviceCode;
    private String serviceName;
    private String serviceArea;
    private String serviceCost;
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;
    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;
    public Service() {
    }
}
