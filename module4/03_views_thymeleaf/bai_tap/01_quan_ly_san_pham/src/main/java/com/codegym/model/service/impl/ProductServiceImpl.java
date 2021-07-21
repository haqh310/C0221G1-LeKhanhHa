package com.codegym.model.service.impl;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products ;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"tivi",1500,"sieu phang","LG"));
        products.put(2, new Product(2,"tu lanh",2500,"lam lanh","Aqua"));
        products.put(3, new Product(3,"dieu hoa",3000,"tiet kiem","LG"));
        products.put(4, new Product(4,"dien thoai",1800,"pin trau","SamSung"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Set<Integer> setKey = products.keySet();
        for(int key : setKey){
            if(products.get(key).getName().contains(name)){
                productList.add(products.get(key));
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
