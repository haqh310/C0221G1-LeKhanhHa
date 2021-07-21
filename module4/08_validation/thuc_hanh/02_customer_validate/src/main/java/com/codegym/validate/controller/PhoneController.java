package com.codegym.validate.controller;

import com.codegym.validate.dto.PhoneNumberDto;
import com.codegym.validate.model.PhoneNumber;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumberDto", new PhoneNumberDto());
        return "/index";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumberDto")PhoneNumberDto phoneNumberDto, BindingResult bindingResult, Model model){
        new PhoneNumberDto().validate(phoneNumberDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            PhoneNumber phoneNumber = new PhoneNumber();
            BeanUtils.copyProperties(phoneNumberDto,phoneNumber);
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}
