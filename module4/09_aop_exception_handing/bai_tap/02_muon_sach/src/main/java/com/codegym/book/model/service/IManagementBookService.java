package com.codegym.book.model.service;

public interface IManagementBookService {

    void borrowBook(Long book_id)throws Exception;

   void remove(Long book_id, Long id) throws Exception;
}
