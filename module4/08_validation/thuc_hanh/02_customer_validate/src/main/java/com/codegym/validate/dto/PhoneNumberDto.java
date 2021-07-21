package com.codegym.validate.dto;

import com.codegym.validate.model.PhoneNumber;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumberDto implements Validator {
    private String number;

    public PhoneNumberDto() {
    }

    public PhoneNumberDto(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }
    }
}
