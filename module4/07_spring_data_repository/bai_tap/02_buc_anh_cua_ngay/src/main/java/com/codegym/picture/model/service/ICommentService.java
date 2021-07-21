package com.codegym.picture.model.service;


import com.codegym.picture.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService extends IGeneralService<Comment> {

    Page<Comment> findAll(Pageable pageable);
    void update(Long id);
}
