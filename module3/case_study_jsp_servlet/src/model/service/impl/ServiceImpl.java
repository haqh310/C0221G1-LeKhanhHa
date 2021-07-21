package model.service.impl;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.repository.ServiceRepository;
import model.service.IService;

import java.util.List;

public class ServiceImpl implements IService<Service> {
    ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean save(Service service) {
        return serviceRepository.insert(service);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public boolean update(int id, Service service) {
        return serviceRepository.update(id, service);
    }

    @Override
    public boolean remove(int id) {
        return serviceRepository.delete(id);
    }

    public List<ServiceType> findAllServiceType() {
        return serviceRepository.findAllServiceType();
    }

    public List<RentType> findAllRentType() {
        return serviceRepository.findAllRentType();
    }
}
