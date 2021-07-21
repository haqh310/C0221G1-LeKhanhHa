package com.codegym.picture.model.repository;

import com.codegym.picture.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment,Long> {
    Page<Comment> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update Comment c set c.likes = c.likes+1 where c.id = ?1", nativeQuery = false)
    void updateLike(Long id);
}
