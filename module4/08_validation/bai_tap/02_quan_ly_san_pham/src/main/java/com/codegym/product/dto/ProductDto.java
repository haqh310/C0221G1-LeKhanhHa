package com.codegym.product.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto implements Validator {
    private Long id;
    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Double price;

    @NotBlank
    private String description;

    @NotBlank
    private String manufacturer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
       if(!productDto.getDescription().matches("^[a-zA-Z]+$")){
           errors.rejectValue("description","string.valid","String format a-z");
       }
    }
}
