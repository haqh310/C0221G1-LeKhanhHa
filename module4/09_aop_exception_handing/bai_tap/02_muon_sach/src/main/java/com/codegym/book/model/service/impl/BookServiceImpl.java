package com.codegym.book.model.service.impl;

import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.ManagementBook;
import com.codegym.book.model.repository.IBookRepository;
import com.codegym.book.model.repository.IManagementBookRepository;
import com.codegym.book.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }



}
