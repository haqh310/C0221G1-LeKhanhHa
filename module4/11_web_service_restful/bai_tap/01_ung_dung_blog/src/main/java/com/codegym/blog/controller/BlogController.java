package com.codegym.blog.controller;


import com.codegym.blog.model.entity.Blog;
import com.codegym.blog.model.entity.Category;
import com.codegym.blog.model.service.IBlogService;
import com.codegym.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/", "/blog"})
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping(value = {"/{search}","/"})
    public ModelAndView goList(@RequestParam("search") Optional<String> search,
                            @RequestParam("page") Optional<Integer> page) {
        Pageable pageable= PageRequest.of(page.orElse(0),5, Sort.by("date").descending());
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
            modelAndView.addObject("search", search.get());
        } else {
            blogs = blogService.findAllByOrderByDateDesc(pageable);
        }

        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
        return "redirect:/blog/";
    }

    @GetMapping(value = "/edit")
    public ModelAndView showEditForm(@RequestParam Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update blog information successfully!");
        return "redirect:/blog/";
    }

    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete blog successfully!");
        return "redirect:/blog/";
    }

    @GetMapping(value = "/view")
    public String showView(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

}
