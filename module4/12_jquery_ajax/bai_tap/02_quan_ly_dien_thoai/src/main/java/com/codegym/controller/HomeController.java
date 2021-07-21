package com.codegym.controller;

import com.codegym.model.entity.Smartphone;
import com.codegym.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/smartphones"})
public class HomeController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping(value = "/list")
    public ModelAndView listSmartphone(){
        List<Smartphone> smartphones = smartphoneService.findAll();
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones",smartphones);
        return modelAndView;
    }

}
