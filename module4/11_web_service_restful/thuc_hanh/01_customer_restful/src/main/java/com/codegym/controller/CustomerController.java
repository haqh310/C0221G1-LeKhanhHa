package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                                   @RequestBody Customer customer){
        Customer customer1 = customerService.findById(id);
        if(customer1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customer1.getId());
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customer,HttpStatus.NO_CONTENT);
    }
}
