package com.codegym.model.service.impl;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.repository.customer.ICustomerRepository;
import com.codegym.model.repository.customer.ICustomerTypeRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAll(String keyWord, Pageable pageable) {
        return customerRepository.findAllByKeyWord(keyWord, pageable);
    }


    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
      Customer customer=this.findById(id);
      customer.setFlag(false);
      save(customer);
    }

    @Override
    public List<CustomerType> listCustomerType() {
        return customerTypeRepository.findAll();
    }

}
