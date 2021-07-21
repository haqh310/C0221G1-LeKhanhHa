package com.codegym.controller;

import com.codegym.model.entity.Question;
import com.codegym.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping(value = "/view")
    public ResponseEntity<Question> findQuestion(@RequestParam Long id){
        Question question = questionService.findById(id);
        if(question == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
