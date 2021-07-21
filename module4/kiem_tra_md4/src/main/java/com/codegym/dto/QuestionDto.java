package com.codegym.dto;

import com.codegym.model.entity.QuestionType;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class QuestionDto{
    private Long id;
    @NotBlank
    @Size(min = 5,max = 100)
    private String title;
    @NotBlank
    @Size(min = 10,max = 500)
    private String question;
    @NotNull
   private QuestionType questionType;

}
