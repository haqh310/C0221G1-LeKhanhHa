package model.repository;

import model.bean.Product;

import java.util.*;

public class ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "tulanh", 1000, "tiet kiem", "sony"));
        products.put(2, new Product(2, "maygiat", 2000, "nhanh", "lg"));
        products.put(3, new Product(3, "dieuhoa", 3000, "lam mat", "panasonic"));
        products.put(4, new Product(4, "tivi", 2500, "sieu mong", "LG"));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Product findById(int id) {
        return products.get(id);
    }

    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Set<Integer> keySet = products.keySet();
        for (int key : keySet) {
            if (products.get(key).getName().contains(name)) {
                productList.add(products.get(key));
            }
        }
        return productList;
    }

    public void update(int id, Product product) {
        products.put(id, product);
    }

    public void remove(int id) {
        products.remove(id);
    }
}
