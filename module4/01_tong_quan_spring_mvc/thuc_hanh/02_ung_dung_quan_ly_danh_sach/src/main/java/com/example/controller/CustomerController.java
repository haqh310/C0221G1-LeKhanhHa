package com.example.controller;


import com.example.model.bean.Customer;
import com.example.model.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    @GetMapping("/")
    public ModelAndView listCustomer(){
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list","customers",customers);
        return  modelAndView;
    }

}
