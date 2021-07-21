package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping
    public String home(){
        return "index";
    }

    @PostMapping("/calculator")
    public ModelAndView calculator(@RequestParam double number1,
                                   @RequestParam double number2 ,
                                   @RequestParam String cal){
        double result = calculatorService.calculator(number1,number2,cal);
       ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
