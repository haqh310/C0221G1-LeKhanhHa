package com.codegym.dto;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.IService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ServiceDto implements Validator {
    @Autowired
    private IService service;

    private Long id;
    @NotBlank
    private String serviceCode;
    @NotBlank
    private String serviceName;
    @NotBlank
    private String serviceArea;
    @Pattern(regexp = "^[0-9]+$",message = "Number format 0-9 and great 0")
    private String serviceCost;
    @NotBlank
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;
    private RentType rentType;
    private ServiceType serviceType;
    private boolean flag=true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.getServiceCode().matches("^DV-[0-9]{4}$")) {
            errors.rejectValue("serviceCode", "service.validCode", "Service code format DV-XXXX");
        }
        if(serviceDto.getNumberOfFloors() != null){
            if (!serviceDto.getNumberOfFloors().matches("^[0-9]+$")) {
                errors.rejectValue("numberOfFloors", "service.validFloor", "Number format 0-9");
            } else if (Integer.parseInt(serviceDto.getNumberOfFloors()) <= 0) {
                errors.rejectValue("numberOfFloors", "service.validFloor", "Number of floors great 0");
            }
        }
    }
}
