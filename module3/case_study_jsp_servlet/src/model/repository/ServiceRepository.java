package model.repository;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IRepository<Service> {
    private BaseRepository repository = new BaseRepository();
    private final String SELECT_ALL_SERVICE = "select * from service";
    private final String SELECT_SERVICE_BY_ID = "select * from service where service_id=?";
    private final String SELECT_SERVICE_BY_NAME = "select * from service where service_name like ?";
    private final String INSERT_SERVICE = " insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)" +
            "values(?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_SERVICE_BY_ID = "update service " +
            "set service_name=?,service_area=?,service_cost=?,service_max_people=?,rent_type_id=?,service_type_id=?,standard_room=?,description_other_convenience=?,pool_area=?,number_of_floors=?" +
            "where service_id=?";
    private final String DELETE_SERVICE_BY_ID = "delete from service where service_id=?";
    private final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";
    private final String SELECT_ALL_RENT_TYPE = "select * from rent_type";

    @Override
    public List<Service> findAll() {
        List<Service> services = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                String pool_area = resultSet.getString("pool_area");
                String number_of_floors = resultSet.getString("number_of_floors");
                services.add(new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public Service findById(int id) {
        Service service = null;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                String pool_area = resultSet.getString("pool_area");
                String number_of_floors = resultSet.getString("number_of_floors");
                service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> findByName(String name) {
        List<Service> services = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_SERVICE_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                String pool_area = resultSet.getString("pool_area");
                String number_of_floors = resultSet.getString("number_of_floors");
                services.add(new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }


    @Override
    public boolean insert(Service service) {
        boolean rowInsert = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_SERVICE);
            statement.setString(1, service.getService_name());
            statement.setInt(2, service.getService_area());
            statement.setDouble(3, service.getService_cost());
            statement.setInt(4, service.getService_max_people());
            statement.setInt(5, service.getRent_type_id());
            statement.setInt(6, service.getService_type_id());
            statement.setString(7, service.getStandard_room());
            statement.setString(8, service.getDescription_other_convenience());
            statement.setString(9, service.getPool_area());
            statement.setString(10, service.getNumber_of_floors());
            rowInsert = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean update(int service_id, Service service) {
        boolean rowUpdate = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE_BY_ID);
            statement.setString(1, service.getService_name());
            statement.setInt(2, service.getService_area());
            statement.setDouble(3, service.getService_cost());
            statement.setInt(4, service.getService_max_people());
            statement.setInt(5, service.getRent_type_id());
            statement.setInt(6, service.getService_type_id());
            statement.setString(7, service.getStandard_room());
            statement.setString(8, service.getDescription_other_convenience());
            statement.setString(9, service.getPool_area());
            statement.setString(10, service.getNumber_of_floors());
            statement.setInt(11, service_id);
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int service_id) {
        boolean rowDelete = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
            statement.setInt(1, service_id);
            rowDelete = statement.executeUpdate() > 0;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<ServiceType> findAllServiceType() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(service_type_id, service_type_name));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }

    public List<RentType> findAllRentType() {
        List<RentType> rentTypes = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int rent_type_id = resultSet.getInt("rent_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                double rent_type_cost = resultSet.getDouble("rent_type_cost");
                rentTypes.add(new RentType(rent_type_id, rent_type_name, rent_type_cost));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }
}
