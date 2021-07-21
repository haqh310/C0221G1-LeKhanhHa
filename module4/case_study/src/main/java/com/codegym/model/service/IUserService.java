package com.codegym.model.service;

import com.codegym.model.entity.user.User;

public interface IUserService extends IGenerateService<User> {
    User findUser(String username);
}
