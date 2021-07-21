package com.codegym.product.model.service;

import com.codegym.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    Page<Product> findByName(String name,Pageable pageable);

    void save(Product product);


    void remove(Long id);
}
