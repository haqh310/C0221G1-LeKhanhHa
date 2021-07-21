package com.codegym.sign_up.model.repository;

import com.codegym.sign_up.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
