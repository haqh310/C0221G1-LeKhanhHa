package com.codegym.blog.model.service.impl;


import com.codegym.blog.model.entity.Category;
import com.codegym.blog.model.repository.ICategoryRepository;
import com.codegym.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
