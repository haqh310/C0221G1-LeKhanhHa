package com.codegym.book.model.entity;

import javax.persistence.*;



@Entity
public class ManagementBook {
    @Id
    @Column(unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public ManagementBook() {
    }

    public ManagementBook(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
