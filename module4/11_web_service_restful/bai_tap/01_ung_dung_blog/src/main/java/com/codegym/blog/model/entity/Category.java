package com.codegym.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category() {
    }
    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
