package com.codegym.model.service.impl;

import com.codegym.model.entity.Comment;
import com.codegym.model.repository.ICommentRepository;
import com.codegym.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Long id) {
        commentRepository.deleteById(id);
    }
}
