package com.codegym.sign_up.controller;


import com.codegym.sign_up.dto.UserDto;
import com.codegym.sign_up.model.entity.User;
import com.codegym.sign_up.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/")
    public String goForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/register";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/register";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return "/result";
    }
}
