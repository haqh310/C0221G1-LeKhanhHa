package com.codegym.model.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    private Long roleId;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles;
    public Role() {
    }
}
