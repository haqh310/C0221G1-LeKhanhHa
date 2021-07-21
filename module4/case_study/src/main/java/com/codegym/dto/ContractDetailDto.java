package com.codegym.dto;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;


@Data
public class ContractDetailDto  {
    private Long contractDetailId;
    @Pattern(regexp = "^[0-9]+$",message = "Number format 0-9 and great 0")
    private String quantity;
    private AttachService attachService;
    private Contract contract;
    private boolean flag=true;

}
