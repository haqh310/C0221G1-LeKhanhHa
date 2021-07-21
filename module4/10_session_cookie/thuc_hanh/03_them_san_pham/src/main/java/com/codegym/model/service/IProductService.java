package com.codegym.model.service;

import com.codegym.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
