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

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping(value = "/list")
    public ModelAndView listSmartphone(){
        List<Smartphone> smartphones = smartphoneService.findAll();
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones",smartphones);
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<List<Smartphone>> allPhones(){
        return new ResponseEntity<>(this.smartphoneService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deletePhone(@PathVariable Long id){
        Smartphone smartphone = this.smartphoneService.findById(id);
        if(smartphone == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone,HttpStatus.NO_CONTENT);
    }
}
