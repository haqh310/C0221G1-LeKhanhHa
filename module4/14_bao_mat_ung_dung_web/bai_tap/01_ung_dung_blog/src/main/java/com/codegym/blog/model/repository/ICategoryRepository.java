package com.codegym.blog.model.repository;

import com.codegym.blog.model.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
