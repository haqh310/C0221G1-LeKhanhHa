package com.codegym.picture.model.service.impl;

import com.codegym.picture.model.entity.Comment;
import com.codegym.picture.model.repository.ICommentRepository;
import com.codegym.picture.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public void update(Long id) {
//        Comment comment = this.findById(id);
//        comment.setLikes(comment.getLikes()+1);
//        this.save(comment);
        commentRepository.updateLike(id);
    }
}
