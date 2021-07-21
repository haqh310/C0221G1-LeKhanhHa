package com.codegym.picture.controller;


import com.codegym.picture.exception.BadWordException;
import com.codegym.picture.model.entity.Comment;
import com.codegym.picture.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = {"/","comment"})
public class CommentController {
    @Autowired
    private ICommentService service;
    @GetMapping("")
    public String goHome(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Comment> comments = service.findAll(pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "home";
    }


    @PostMapping("/save")
    public String comment(@ModelAttribute("comment") Comment comment) throws BadWordException {
        service.save(comment);
        return "redirect:/comment/";
    }

    @GetMapping("/like")
    public String like(@RequestParam Long id){
        service.update(id);
        return "redirect:/comment/";
    }

    @ExceptionHandler(BadWordException.class)
    public ModelAndView showInputNotAccept(){
        return new ModelAndView("inputs-not-acceptable");
    }
}
