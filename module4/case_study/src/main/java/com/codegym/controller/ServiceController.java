package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.IService;
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
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/services")
@SessionAttributes("user")
public class ServiceController {
    @Autowired
    private IService service;

    @ModelAttribute("rentTypes")
    public List<RentType> rentTypeList(){
        return service.listRentType();
    }
    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypeList(){
        return service.listServiceType();
    }
    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWord,
                               @RequestParam("page") Optional<Integer> page){
        Pageable pageable= PageRequest.of(page.orElse(0),5);
        Page<Service> services = service.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("service/list","services",services);
        modelAndView.addObject("keyWord", keyWord.orElse(""));
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("service/create","serviceDto",new ServiceDto());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createService(@ModelAttribute @Valid ServiceDto serviceDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        new ServiceDto().validate(serviceDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        this.service.save(service);
        redirectAttributes.addFlashAttribute("msg","Create new service successfully!!!");
        return "redirect:/services";
    }
}
