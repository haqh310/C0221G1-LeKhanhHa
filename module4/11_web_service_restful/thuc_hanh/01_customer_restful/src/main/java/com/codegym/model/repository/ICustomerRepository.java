package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
