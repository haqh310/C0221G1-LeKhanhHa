package com.codegym.blog.controller;

import com.codegym.blog.model.entity.Blog;
import com.codegym.blog.model.entity.Category;
import com.codegym.blog.model.service.ICategoryService;
import com.codegym.blog.model.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/category"})
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping(value = "")
    public String goList(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @PostMapping(value = "/create")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create new category successfully!");
        return "redirect:/category/";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute Category category,  RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update category information successfully!");
        return "redirect:/category/";
    }

    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long id,  RedirectAttributes redirectAttributes){
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete category successfully!");
        return "redirect:/category/";
    }

    @GetMapping(value = "/view")
    public String showView(@RequestParam Long id, Model model){
        Category categoryOptional = categoryService.findById(id);
        if(categoryOptional == null){
            return "error.404";
        }
        List<Blog> blogs = blogService.findAllByCategory(categoryOptional);
        model.addAttribute("category", categoryOptional);
        model.addAttribute("blogs", blogs);
        return "category/view";
    }

}
