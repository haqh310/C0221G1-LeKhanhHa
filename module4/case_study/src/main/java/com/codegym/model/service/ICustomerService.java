package com.codegym.model.service;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IGenerateService<Customer> {
    List<CustomerType> listCustomerType();
}
