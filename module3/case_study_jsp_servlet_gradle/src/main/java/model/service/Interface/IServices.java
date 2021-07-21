package model.service.Interface;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.util.List;

public interface IServices extends IService<Service> {
    @Override
    List<Service> findAll();

    @Override
    Service findById(int id);

    @Override
    List<Service> findByName(String name);

    @Override
    List<String> insert(Service service);

    @Override
    List<String> update(int id, Service service);

    @Override
    boolean remove(int id);
    List<ServiceType> findAllServiceType();

    List<RentType> findAllRentType();
}
