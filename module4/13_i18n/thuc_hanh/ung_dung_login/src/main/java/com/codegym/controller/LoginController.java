package com.codegym.controller;

import com.codegym.model.entity.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String goLogin(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/doLogin")
    public String loginUser(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);
        return "dashboard";
    }
}
