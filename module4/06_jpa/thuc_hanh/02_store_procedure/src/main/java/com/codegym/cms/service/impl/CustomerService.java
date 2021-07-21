package com.codegym.cms.service.impl;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.ICustomerRepository;
import com.codegym.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}