package com.codegym.model.repository;

import com.codegym.model.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}
