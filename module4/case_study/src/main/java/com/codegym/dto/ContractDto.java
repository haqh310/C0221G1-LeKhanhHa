package com.codegym.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class ContractDto implements Validator {
    private Long id;
    @NotBlank
    private String contractStartDate ;
    @NotBlank
    private String contractEndDate ;
    @Pattern(regexp = "^[0-9]+$",message = "Number format 0-9 and great 0")
    private String contractDeposit;
    private String contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;
    private boolean flag=true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        try{
            Date date1=formatter.parse(contractDto.getContractStartDate());
            Date date2=formatter.parse(contractDto.getContractEndDate());
            if(date2.compareTo(date1) <=0){
                errors.rejectValue("contractEndDate", "contract.validDate", "End date must great start date");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
