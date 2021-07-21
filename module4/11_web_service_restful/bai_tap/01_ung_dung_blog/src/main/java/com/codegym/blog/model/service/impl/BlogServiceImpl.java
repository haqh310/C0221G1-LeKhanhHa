package com.codegym.blog.model.service.impl;

import com.codegym.blog.model.entity.Blog;
import com.codegym.blog.model.entity.Category;
import com.codegym.blog.model.repository.IBlogRepository;
import com.codegym.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
//        blogRepository.save(blog);
        blogRepository.saveBlog(blog.getTitle(),blog.getContent(),blog.getCategory().getId());
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByOrderByDateDesc(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public  Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.searchByTitle(title, pageable);
    }
}
