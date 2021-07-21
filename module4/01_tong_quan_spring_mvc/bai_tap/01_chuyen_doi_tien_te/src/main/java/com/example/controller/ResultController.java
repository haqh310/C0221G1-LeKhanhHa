package com.example.controller;

import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ResultController {
    @Autowired
    private IService service;

    @GetMapping(value = {"/","/result"})
    public String goHome(){
        return "index";
    }

    @PostMapping("/result")
    public String exchange(@RequestParam int usd,int rate ,Model model) {
        int vnd = service.exchange(usd,rate);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "index";
    }
}
