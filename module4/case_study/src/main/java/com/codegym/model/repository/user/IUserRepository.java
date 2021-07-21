package com.codegym.model.repository.user;

import com.codegym.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value = "Select * from `user` u Where u.username = :userName ",nativeQuery = true)
    User findUserAccount(String userName);

}
