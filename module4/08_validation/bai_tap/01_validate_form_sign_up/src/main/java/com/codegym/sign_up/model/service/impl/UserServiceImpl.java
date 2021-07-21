package com.codegym.sign_up.model.service.impl;

import com.codegym.sign_up.model.entity.User;
import com.codegym.sign_up.model.repository.IUserRepository;
import com.codegym.sign_up.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
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
}
