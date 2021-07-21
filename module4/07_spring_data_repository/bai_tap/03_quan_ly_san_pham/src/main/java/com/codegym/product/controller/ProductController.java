package com.codegym.product.controller;


import com.codegym.product.model.entity.Product;
import com.codegym.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = {"/","/product"})
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listProduct(Model model,
                              @PageableDefault(value = 3) Pageable pageable,
                              @RequestParam Optional<String> keyword){
        Page<Product> productList =productService.findByName(keyword.orElse(""), pageable);
        model.addAttribute("products",productList);
        model.addAttribute("keyword",keyword.orElse(""));
        return "/product/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "Created product successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product,
                        RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "Updated product information successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/product/delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/view")
    public String viewProduct(@RequestParam Long id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/view";
    }

}
