package com.codegym.exception_handler.repository;


import com.codegym.exception_handler.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
