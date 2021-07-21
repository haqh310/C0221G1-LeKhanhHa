package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    List<Product> findByName(String name);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);
}
