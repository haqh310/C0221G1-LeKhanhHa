package com.codegym.customer_manager.model.repository;


import com.codegym.customer_manager.model.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
