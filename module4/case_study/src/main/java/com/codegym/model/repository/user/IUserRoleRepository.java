package com.codegym.model.repository.user;

import com.codegym.model.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "SELECT r.role_name FROM user_role ur join `role` r on ur.role_id= r.role_id where ur.username = :username", nativeQuery = true)
    List<String> getRoleNames(String username);
}
