package com.codegym.model.service.impl;

import com.codegym.model.entity.user.User;
import com.codegym.model.repository.user.IUserRepository;
import com.codegym.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Page<User> findAll(String keyWord, Pageable pageable) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User findUser(String username) {
        return userRepository.findUserAccount(username);
    }
}
