package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping(value = {"/","/product"})
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listProduct(Model model){
        List<Product> productList =productService.findAll();
        model.addAttribute("products",productList);
        return "/product/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Created product successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product,
                        RedirectAttributes redirect){
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("success", "Updated product information successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam int id, Model model){
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
    public String viewProduct(@RequestParam int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/view";
    }
    @GetMapping("/search")
    public String findProduct(@RequestParam String name,Model model){
        model.addAttribute("products",productService.findByName(name));
        return "/product/index";
    }
}