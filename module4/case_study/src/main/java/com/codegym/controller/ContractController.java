package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import com.codegym.model.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/contracts")
@SessionAttributes("user")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IService service;

    @ModelAttribute("customers")
    public Page<Customer> customerPage(Pageable pageable) {
        return customerService.findAll("",pageable);
    }
    @ModelAttribute("employees")
    public Page<Employee> employeePage(Pageable pageable) {
        return employeeService.findAll("",pageable);
    }
    @ModelAttribute("services")
    public Page<Service> servicePage(Pageable pageable){
        return service.findAll("",pageable);
    }

    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWord,
                               @RequestParam("page") Optional<Integer> page){
        Pageable pageable= PageRequest.of(page.orElse(0),5);
        Page<Contract> contracts = contractService.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("contract/list","contracts",contracts);
        modelAndView.addObject("keyWord", keyWord.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","Create new contract successfully!!!");
        return "redirect:/contracts";
    }

    @GetMapping(value = "/edit")
    public ModelAndView showFormEdit(@RequestParam Long id){
        Contract contract = contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract,contractDto);
        ModelAndView modelAndView = new ModelAndView("contract/edit","contractDto",contractDto);
        return modelAndView;
    }
    @PostMapping(value = "/edit")
    public String updateContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "contract/edit";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","Update contract information successfully!!!");
        return "redirect:/contracts";
    }

    @PostMapping(value = "/delete")
    public String deleteContract(@RequestParam Long id,
                                 RedirectAttributes redirectAttributes){
        contractService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete contract successfully!!!");
        return "redirect:/contracts";
    }
}
