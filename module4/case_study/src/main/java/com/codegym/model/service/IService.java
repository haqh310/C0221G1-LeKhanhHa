package com.codegym.model.service;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;

import java.util.List;

public interface IService extends IGenerateService<Service> {
    List<RentType> listRentType();
    List<ServiceType> listServiceType();
}
