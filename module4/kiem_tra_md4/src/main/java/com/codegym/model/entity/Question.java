package com.codegym.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String question;
    private String answer;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_question_type")
    private QuestionType questionType;

    private String dateCreate;
    private String status;

}
