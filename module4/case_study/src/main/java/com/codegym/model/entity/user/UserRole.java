package com.codegym.model.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public UserRole() {
    }
}
