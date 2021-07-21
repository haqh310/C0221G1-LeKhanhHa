package com.codegym.book.model.repository;

import com.codegym.book.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
