package com.codegym.controller;

import com.codegym.model.entity.Smartphone;
import com.codegym.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/smartphones")
public class HomeRestController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
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
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findPhone(@PathVariable Long id){
        Smartphone smartphone = this.smartphoneService.findById(id);
        if(smartphone == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }
}
