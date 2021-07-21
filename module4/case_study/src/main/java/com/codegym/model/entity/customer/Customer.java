package com.codegym.model.entity.customer;


import com.codegym.model.entity.contract.Contract;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    private String customerCode;
    private String customerName;
    private String customerBirthday;
    private String customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    private boolean flag;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }
}
