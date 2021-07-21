package com.codegym.product.model.service.impl;


import com.codegym.product.model.entity.Product;
import com.codegym.product.model.repository.IProductRepository;
import com.codegym.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findByName(String name,Pageable pageable) {
        return productRepository.findByName(name,pageable);
    }

    @Override
    public void save(Product product) {
    productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
            productRepository.deleteById(id);
    }
}
