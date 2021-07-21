package com.codegym.controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/blog"})
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping(value = "/")
    public String goList(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping(value = "/create")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
        return "redirect:/blog/";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute Blog blog,  RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update blog information successfully!");
        return "redirect:/blog/";
    }

    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long id,  RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete blog successfully!");
        return "redirect:/blog/";
    }
    @GetMapping(value = "/view")
    public String showView(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

}
