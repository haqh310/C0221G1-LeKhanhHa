package com.codegym.model.repository;

import com.codegym.model.entity.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<UserRole,Long> {

    @Query(value = "SELECT ar.role_name FROM user_role ur join app_role ar on ur.role_id= ar.role_id where ur.user_id = :userId", nativeQuery = true)
    List<String> getRoleNames(Long userId);
}
