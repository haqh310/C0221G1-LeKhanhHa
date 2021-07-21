package com.codegym.model.entity.user;

import com.codegym.model.entity.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String username;

    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
