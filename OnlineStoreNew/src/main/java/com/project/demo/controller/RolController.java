package com.project.demo.controller;

import com.project.demo.persitance.dto.RoleDto;
import com.project.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RolController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public void add(@RequestBody RoleDto roleDto) {
        roleService.add(roleDto);
    }

    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        roleService.delete(id);
    }

    @GetMapping("/role")
    public List<RoleDto> getRoles() {
        return roleService.getAll();
    }

    @GetMapping("/role/{id}")
    public RoleDto getRole(@PathVariable(name = "id") Long id) {
        return roleService.getRole(id);
    }

    @PutMapping("/role")
    public void update(@RequestBody RoleDto roleDto) {
        roleService.update(roleDto);

    }
}
