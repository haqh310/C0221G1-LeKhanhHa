package com.codegym.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String employeeBirthday;
    @NotBlank
    private String employeeIdCard;
    @Pattern(regexp = "^[0-9]+$",message = "Number format 0-9 and great 0")
    private String employeeSalary;
    @NotBlank
    private String employeePhone;
    @Email
    private String employeeEmail;
    private String employeeAddress;
    @NotBlank
    private String user;

    private Position position;
    private Division division;
    private EducationDegree educationDegree;
    private boolean flag = true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        if (!employeeDto.getEmployeePhone().matches("^(090|091)[0-9]{7}$")) {
            errors.rejectValue("employeePhone", "employee.validPhone", "Employee phone format 091xxxxxxx or 090xxxxxxx");
        }
        if (!employeeDto.getEmployeeIdCard().matches("^[0-9]{9,10}$")) {
            errors.rejectValue("employeeIdCard", "employee.validIdCard", "Employee id card format XXXXXXXXX or XXXXXXXXXXXX ");
        }
    }
}
