package com.project.demo.persitance.model;
import javax.persistence.*;
import java.util.List;
@Entity
public class PrivilegeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "privileges")
    private List<RoleModel> rolelist;

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

    public List<RoleModel> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<RoleModel> rolelist) {
        this.rolelist = rolelist;
    }
}
