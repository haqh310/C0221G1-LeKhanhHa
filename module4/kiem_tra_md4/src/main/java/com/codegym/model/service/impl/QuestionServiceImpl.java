package com.codegym.model.service.impl;

import com.codegym.model.entity.Question;
import com.codegym.model.entity.QuestionType;
import com.codegym.model.repository.IQuestionRepository;
import com.codegym.model.repository.IQuestionTypeRepository;
import com.codegym.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;
    @Override
    public Page<Question> findAll(String keyWord1, String keyWord2, Pageable pageable) {
        return questionRepository.findAll(keyWord1,keyWord2,pageable);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        question.setDateCreate(dtf.format(now));
        question.setStatus("Chờ phản hồi");
        questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
