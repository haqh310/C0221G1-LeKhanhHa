package model.service.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.CustomerRepository;
import model.service.Interface.ICustomerService;
import model.service.common.Validate;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    Validate validate = new Validate();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
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
    public List<String> insert(Customer customer) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateCustomerCode(customer.getCustomer_code()));
        messages.add(validate.validateDate(customer.getCustomer_birthday()));
        messages.add(validate.validateIdCard(customer.getCustomer_id_card()));
        messages.add(validate.validatePhone(customer.getCustomer_phone()));
        messages.add(validate.validateEmail(customer.getCustomer_email()));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( customerRepository.insert(customer)){
                messages.add("New customer was created");
            }
        }
        return messages;
    }

    @Override
    public List<String> update(int customer_id, Customer customer) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateCustomerCode(customer.getCustomer_code()));
        messages.add(validate.validateDate(customer.getCustomer_birthday()));
        messages.add(validate.validateIdCard(customer.getCustomer_id_card()));
        messages.add(validate.validatePhone(customer.getCustomer_phone()));
        messages.add(validate.validateEmail(customer.getCustomer_email()));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( customerRepository.update(customer_id,customer)){
                messages.add("Customer information was updated");
            }
        }
        return messages;
    }

    @Override
    public boolean remove(int customer_id) {
        return customerRepository.delete(customer_id);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerRepository.findAllCustomerType();
    }
}
