package model.service.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.CustomerRepository;
import model.service.IService;

import java.util.List;

public class CustomerServiceImpl implements IService<Customer> {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer findById(int customer_id) {
        return customerRepository.findById(customer_id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public boolean update(int customer_id, Customer customer) {
        return customerRepository.update(customer_id, customer);
    }

    @Override
    public boolean remove(int customer_id) {
        return customerRepository.delete(customer_id);
    }

    public List<CustomerType> findAllCustomerType() {
        return customerRepository.findAllCustomerType();
    }
}
