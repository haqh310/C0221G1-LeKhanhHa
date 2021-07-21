package com.codegym.customer_manager.repository;


import com.codegym.customer_manager.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
