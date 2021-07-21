package com.example.controller;

import com.example.service.ListDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DictionaryController {
    @Autowired
    private ListDictionary listDictionary;

    @GetMapping(value = "/")
    public String goIndex(){
        return "index";
    }
    @PostMapping( value = "/dictionary")
    public ModelAndView result(@RequestParam String name){
       String result = listDictionary.find(name);
        ModelAndView modelAndView = new ModelAndView("result","result",result);
        return  modelAndView;
    }
}
