package com.codegym.model.repository;

import com.codegym.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "select * from question q join question_type qt on q.id_question_type= qt.id where q.title like %?1% && qt.name like %?2% order by q.status", nativeQuery = true)
    Page<Question> findAll(String title,String name, Pageable pageable);
}
