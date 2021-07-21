package model.service.Interface;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    @Override
    List<Customer> findAll();

    @Override
    Customer findById(int id);

    @Override
    List<Customer> findByName(String name);

    @Override
    List<String> insert(Customer customer);

    @Override
    List<String> update(int id, Customer customer);

    @Override
    boolean remove(int id);
    List<CustomerType> findAllCustomerType();
}
