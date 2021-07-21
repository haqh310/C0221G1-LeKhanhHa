package model.service;

import model.bean.User;

import java.util.List;

public interface IService {

    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) ;

    boolean updateUser(User user) ;

    List<User> findByCountry(String country);

    List<User> sortByName();
}
