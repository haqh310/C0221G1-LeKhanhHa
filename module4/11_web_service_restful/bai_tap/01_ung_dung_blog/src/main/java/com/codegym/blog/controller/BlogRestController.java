package com.codegym.blog.controller;

import com.codegym.blog.model.entity.Blog;
import com.codegym.blog.model.entity.Category;
import com.codegym.blog.model.service.impl.BlogServiceImpl;
import com.codegym.blog.model.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BlogRestController {
    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/blogs")
    public ResponseEntity<List<Blog>> findAllBlog(){
        List<Blog> blogs = blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        List<Blog> blogs = blogService.findAllByCategory(category);
        if(category== null || blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping(value = "/blogs/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @PostMapping(value = "/blogs/create")
    public ResponseEntity<List<FieldError>> createBlog(@RequestBody @Valid Blog blog, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
