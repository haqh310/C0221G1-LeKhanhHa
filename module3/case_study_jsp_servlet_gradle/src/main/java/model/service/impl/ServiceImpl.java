package model.service.impl;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.repository.ServiceRepository;
import model.service.Interface.IServices;
import model.service.common.Validate;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements IServices {
    ServiceRepository serviceRepository = new ServiceRepository();
    Validate validate = new Validate();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
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
    public List<String> insert(Service service) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateServiceCode(service.getService_code()));
        messages.add(validate.validateTypeInt(service.getService_area()));
        messages.add(validate.validateTypeDouble(service.getService_cost()));
        messages.add(validate.validateTypeInt(service.getService_max_people()));
        messages.add(validate.validateTypeDouble(Double.parseDouble(service.getPool_area())));
        messages.add(validate.validateTypeInt(Integer.parseInt(service.getNumber_of_floors())));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( serviceRepository.insert(service)){
                messages.add("New service was created");
            }
        }
        return messages;
    }

    @Override
    public List<String> update(int id, Service service) {
        List<String> messages = new ArrayList<>();
        boolean check=false;
        messages.add(validate.validateServiceCode(service.getService_code()));
        messages.add(validate.validateTypeInt(service.getService_area()));
        messages.add(validate.validateTypeDouble(service.getService_cost()));
        messages.add(validate.validateTypeInt(service.getService_max_people()));
        messages.add(validate.validateTypeDouble(Double.parseDouble(service.getPool_area())));
        messages.add(validate.validateTypeInt(Integer.parseInt(service.getNumber_of_floors())));
        for (String message: messages) {
            if(message != null){
                check=true;
                break;
            }
        }
        if(!check){
            if( serviceRepository.update(id,service)){
                messages.add("Service information was updated");
            }
        }
        return messages;
    }

    @Override
    public boolean remove(int id) {
        return serviceRepository.delete(id);
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceRepository.findAllServiceType();
    }

    @Override
    public List<RentType> findAllRentType() {
        return serviceRepository.findAllRentType();
    }
}
