package com.codegym.model.service.impl;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.repository.service.IRentTypeRepository;
import com.codegym.model.repository.service.IServiceRepository;
import com.codegym.model.repository.service.IServiceTypeRepository;
import com.codegym.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class IServiceImpl implements IService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Page<Service> findAll(String keyWord, Pageable pageable) {
        return serviceRepository.findAllByKeyWord(keyWord, pageable);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        Service service = this.findById(id);
        service.setFlag(false);
        this.save(service);
    }

    @Override
    public List<RentType> listRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> listServiceType() {
        return serviceTypeRepository.findAll();
    }

}
