package com.codegym.book.model.repository;

import com.codegym.book.model.entity.ManagementBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManagementBookRepository extends JpaRepository<ManagementBook, Long> {
}
