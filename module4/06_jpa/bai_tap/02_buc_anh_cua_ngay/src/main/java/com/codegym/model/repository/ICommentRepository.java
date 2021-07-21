package com.codegym.model.repository;

import com.codegym.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Long> {

}
