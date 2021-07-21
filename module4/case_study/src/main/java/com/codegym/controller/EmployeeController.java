package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.user.User;
import com.codegym.model.service.IEmployeeService;
import com.codegym.model.service.IUserService;
import com.codegym.util.EncrytedPasswordUtils;
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
@RequestMapping(value = "/employees")
@SessionAttributes("user")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IUserService userService;
    @ModelAttribute("divisions")
    public List<Division> divisionList(){
        return employeeService.listDivision();
    }
    @ModelAttribute("positions")
    public List<Position> positionList(){
        return employeeService.listPosition();
    }
    @ModelAttribute("educationDegrees")
    public List<EducationDegree> educationDegreeList(){
        return employeeService.listEducationDegree();
    }

    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWord,
                               @RequestParam("page") Optional<Integer> page) {
        Pageable pageable= PageRequest.of(page.orElse(0),5);
        Page<Employee> employees = employeeService.findAll(keyWord.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list","employees",employees);
        modelAndView.addObject("keyWord",keyWord.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute @Valid EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        User user = new User(employeeDto.getUser(), EncrytedPasswordUtils.encrytePassword("123"));
        employee.setUser(user);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Create new Employee successfully!!!");
        return "redirect:/employees";
    }

    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam Long id, Model model){
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        employeeDto.setUser(employee.getUser().getUsername());
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@ModelAttribute @Valid EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setUser(userService.findUser(employeeDto.getUser()));
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Update Employee information successfully!!!");
        return "redirect:/employees";
    }


    @PostMapping(value = "/delete")
    public String deleteCustomer(@RequestParam Long id,RedirectAttributes redirectAttributes){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete employee successfully!!!");
        return "redirect:/employees";
    }
}
