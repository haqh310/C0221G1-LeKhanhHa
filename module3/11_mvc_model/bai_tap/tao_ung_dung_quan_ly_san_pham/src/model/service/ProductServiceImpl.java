package model.service;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.*;

public class ProductServiceImpl implements ProductService {
   ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
