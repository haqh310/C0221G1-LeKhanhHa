package com.codegym.dto;

import com.codegym.model.entity.customer.CustomerType;
import lombok.Data;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CustomerDto implements Validator {

    private Long id;
    @NotBlank
    private String customerCode;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerBirthday;
    @NotBlank
    private String customerGender;
    @NotBlank
    private String customerIdCard;
    @NotBlank
    private String customerPhone;
    @Email
    private String customerEmail;
    private String customerAddress;

    private CustomerType customerType;
    private boolean flag = true;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.getCustomerCode().matches("^KH-[0-9]{4}$")) {
            errors.rejectValue("customerCode", "customer.validCode", "Customer code format KH-XXXX");
        }
        if (!customerDto.getCustomerPhone().matches("^(090|091)[0-9]{7}$")) {
            errors.rejectValue("customerPhone", "customer.validPhone", "Customer phone format 091xxxxxxx or 090xxxxxxx");
        }
        if (!customerDto.getCustomerIdCard().matches("^[0-9]{9,10}$")) {
            errors.rejectValue("customerIdCard", "customer.validIdcard", "Customer id card format XXXXXXXXX or XXXXXXXXXXXX ");
        }
    }
}
