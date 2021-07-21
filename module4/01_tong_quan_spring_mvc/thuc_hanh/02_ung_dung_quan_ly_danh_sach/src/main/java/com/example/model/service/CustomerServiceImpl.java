package com.example.model.service;

import com.example.model.bean.Customer;
import com.example.model.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.selectAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.selectById(id);
    }
}
