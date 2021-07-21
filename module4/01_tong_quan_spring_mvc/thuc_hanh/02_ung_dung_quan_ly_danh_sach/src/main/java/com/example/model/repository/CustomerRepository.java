package com.example.model.repository;

import com.example.model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository repository = new BaseRepository();
    private final String SELECT_ALL = "select * from customer";
    private final String SELECT_BY_ID = "select * from customer where id=?";

    public List<Customer> selectAll() {
        Connection connection = repository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
               customers.add(new Customer(id,name,email,address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer selectById(int id) {
        Connection connection = repository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer=new Customer(id,name,email,address);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
