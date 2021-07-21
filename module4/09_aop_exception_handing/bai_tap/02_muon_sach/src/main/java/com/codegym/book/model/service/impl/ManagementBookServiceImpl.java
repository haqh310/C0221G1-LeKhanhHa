package com.codegym.book.model.service.impl;

import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.ManagementBook;
import com.codegym.book.model.repository.IBookRepository;
import com.codegym.book.model.repository.IManagementBookRepository;
import com.codegym.book.model.service.IManagementBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementBookServiceImpl implements IManagementBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    IManagementBookRepository managementBookRepository;

    @Override
    public void borrowBook(Long book_id)throws Exception {
        Long id = Long.parseLong(String.valueOf(Math.round(((Math.random() * 89999) + 10000))));
        Book book = this.bookRepository.findById(book_id).orElse(null);
        if(book.getCount() == 0){
            throw new Exception("Count book = 0");
        }
        managementBookRepository.save(new ManagementBook(id,book));
        book.setCount(book.getCount()-1);
        bookRepository.save(book);
    }

    @Override
    public void remove(Long book_id, Long id) throws Exception{
        if(!managementBookRepository.findById(id).isPresent()){
            throw new Exception("Find not found id");
        }
        managementBookRepository.deleteById(id);
        Book book = this.bookRepository.findById(book_id).orElse(null);
        book.setCount(book.getCount()+1);
        bookRepository.save(book);
    }

}
