package model.service;

import model.bean.User;
import model.repository.UserRepository;

import java.util.List;

public class UserService implements IService{
    UserRepository userRepository = new UserRepository();
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        userRepository.addUserTransaction(user, permisions);
    }
}
