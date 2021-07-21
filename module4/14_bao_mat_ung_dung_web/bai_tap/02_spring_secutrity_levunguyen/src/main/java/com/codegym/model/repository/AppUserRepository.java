package com.codegym.model.repository;
import com.codegym.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    @Query(value = "Select * from app_user e Where e.user_name = :userName ",nativeQuery = true)
    AppUser findUserAccount(String userName);
}
