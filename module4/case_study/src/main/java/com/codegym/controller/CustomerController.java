package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
@SessionAttributes("user")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes() {
        return customerService.listCustomerType();
    }

    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWord,
                               @RequestParam("page") Optional<Integer> page){
        Pageable pageable= PageRequest.of(page.orElse(0),5);
        Page<Customer> customers = customerService.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list","customers",customers);
        modelAndView.addObject("keyWord", keyWord.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Create new Customer successfully!!!");
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam Long id, Model model){
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Update customer information successfully!!!");
        return "redirect:/customers";
    }


    @PostMapping(value = "/delete")
    public String deleteCustomer(@RequestParam Long id,RedirectAttributes redirectAttributes){
       customerService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete customer successfully!!!");
        return "redirect:/customers";
    }
}
