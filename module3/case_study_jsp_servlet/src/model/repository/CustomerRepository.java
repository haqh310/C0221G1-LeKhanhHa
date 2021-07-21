package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.BaseRepository;
import model.repository.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {

    private BaseRepository repository = new BaseRepository();
    private final String SELECT_ALL_CUSTOMER = "select * from customer";
    private final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?";
    private final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";
    private final String INSERT_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email, customer_address) " +
            "values(?,?,?,?,?,?,?,?)";
    private final String UPDATE_CUSTOMER_BY_ID = "update customer " +
            "set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?" +
            "where customer_id=?";
    private final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id=?";
    private final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                Date customer_birthday = resultSet.getDate("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                Date customer_birthday = resultSet.getDate("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                Date customer_birthday = resultSet.getDate("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean insert(Customer customer) {
        boolean rowInsert = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER);
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setDate(3, customer.getCustomer_birthday());
            statement.setString(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            rowInsert = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean update(int customer_id, Customer customer) {
        boolean rowUpdate = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setDate(3, customer.getCustomer_birthday());
            statement.setString(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            statement.setInt(9, customer_id);
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int customer_id) {
        boolean rowDelete = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            statement.setInt(1, customer_id);
            rowDelete = statement.executeUpdate() > 0;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customer_type_id, customer_type_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }
}
