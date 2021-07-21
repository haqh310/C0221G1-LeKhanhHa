package com.codegym.book.model.service;

import com.codegym.book.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable);
    Book findById(Long id);

}
