package com.codegym.model.entity.contract;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;
    private String contractStartDate ;
    private String contractEndDate ;
    private String contractDeposit;
    private String contractTotalMoney;
    private boolean flag;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetailSet;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public Contract() {
    }
}
