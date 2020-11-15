package com.project.demo.persitance.dto;


import java.util.List;

public class PrivilegeDto {
    private long id;

    private String name;

    private List<RoleDto> rolelist;

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

    public List<RoleDto> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<RoleDto> rolelist) {
        this.rolelist = rolelist;
    }
}
