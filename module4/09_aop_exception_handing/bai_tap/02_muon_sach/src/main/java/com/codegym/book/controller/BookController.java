package com.codegym.book.controller;

import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.ManagementBook;
import com.codegym.book.model.service.IBookService;
import com.codegym.book.model.service.IManagementBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/","/book"})
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IManagementBookService managementBookService;

    @GetMapping(value = "")
    public ModelAndView gotoList(@PageableDefault(value = 1) Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
    @GetMapping(value = "/view")
    public ModelAndView showView(@RequestParam() Long id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("book",book);
        return modelAndView;
    }
    @GetMapping(value = "/borrow")
    public ModelAndView borrowBook(@RequestParam("book_id") Long id) throws Exception{
        managementBookService.borrowBook(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }
    @PostMapping(value = "/pay")
    public ModelAndView payBook(@RequestParam("book_id") Long book_id,
                                @RequestParam("id") Long id) throws Exception{
        managementBookService.remove(book_id,id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("book", bookService.findById(book_id));
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView errorFind(){
        return new ModelAndView("error-404");
    }
}
