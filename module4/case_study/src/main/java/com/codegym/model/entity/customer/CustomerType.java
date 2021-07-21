package com.codegym.model.entity.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Long id;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

}
