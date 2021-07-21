package com.codegym.controller;

import com.codegym.model.entity.Comment;
import com.codegym.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/","comment"})
public class CommentController {
    @Autowired
    private ICommentService service;
    @GetMapping("")
    public String goHome(Model model) {
        List<Comment> comments = service.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "home";
    }


    @PostMapping("/save")
    public String comment(@ModelAttribute("comment") Comment comment){
        service.save(comment);
        return "redirect:/comment/";
    }

    @GetMapping("/like")
    public String like(@RequestParam Long id){
        service.update(id);
        return "redirect:/comment/";
    }
}
