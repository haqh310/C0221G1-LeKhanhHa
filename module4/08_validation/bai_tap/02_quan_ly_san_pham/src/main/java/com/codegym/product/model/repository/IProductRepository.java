package com.codegym.product.model.repository;

import com.codegym.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product where `name` like %?1%", nativeQuery = true)
    Page<Product> findByName(String name, Pageable pageable);
}
