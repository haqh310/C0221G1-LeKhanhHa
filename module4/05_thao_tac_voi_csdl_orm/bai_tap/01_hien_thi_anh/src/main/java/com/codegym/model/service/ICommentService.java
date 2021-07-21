package com.codegym.model.service;

import com.codegym.model.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    Comment findOne(int id);

    Comment save(Comment comment);

    void like(int id);

}
