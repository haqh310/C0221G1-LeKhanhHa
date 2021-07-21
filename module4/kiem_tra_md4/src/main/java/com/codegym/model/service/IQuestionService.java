package com.codegym.model.service;

import com.codegym.model.entity.Question;
import com.codegym.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IQuestionService {
    Page<Question> findAll(String keyWord1, String keyWord2 , Pageable pageable);
    Question findById(Long id);
    void save(Question question);
    void remove(Long id);
    List<QuestionType> findAll();
}
