package com.codegym.controller;

import com.codegym.dto.QuestionDto;
import com.codegym.model.entity.Question;
import com.codegym.model.entity.QuestionType;
import com.codegym.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/","/questions"})
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @ModelAttribute("questionTypes")
    public List<QuestionType> questionTypes() {
        return questionService.findAll();
    }


    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("keyWord1") Optional<String> keyWord1,
                                @RequestParam("keyWord2") Optional<String> keyWord2,
                               @RequestParam("page") Optional<Integer> page){
        Pageable pageable= PageRequest.of(page.orElse(0),1);
        Page<Question> questions = questionService.findAll(keyWord1.orElse(""),keyWord2.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("question/list","questions",questions);
        modelAndView.addObject("keyWord1", keyWord1.orElse(""));
        modelAndView.addObject("keyWord2", keyWord2.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("questionDto", new QuestionDto());
        return "question/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute @Valid QuestionDto questionDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/question/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg","Create new question successfully!!!");
        return "redirect:/questions";
    }


    @PostMapping(value = "/delete")
    public String deleteCustomer(@RequestParam Long id,RedirectAttributes redirectAttributes){
        Question question = questionService.findById(id);
        if(question == null){
            return "/message";
        }
        questionService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete question successfully!!!");
        return "redirect:/questions";
    }


}
