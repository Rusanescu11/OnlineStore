package com.project.demo.persitance.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
        private List<PrivilegeModel> privileges;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="roles_users",
            joinColumns = @JoinColumn(
                    name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"))
    private List<UserModel> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrivilegeModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeModel> privileges) {
        this.privileges = privileges;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
