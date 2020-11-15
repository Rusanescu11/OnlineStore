package com.project.demo.controller;

import com.project.demo.persitance.dto.PrivilegeDto;
import com.project.demo.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping("/privilege")
    public void add(@RequestBody PrivilegeDto privilegeDto) {
        privilegeService.add(privilegeDto);
    }
    @DeleteMapping("/privilege/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        privilegeService.delete(id);
    }
    @GetMapping("/privilege")
    public List<PrivilegeDto> getAll() {
        return privilegeService.getAll();
    }

    @GetMapping("/privilege/{id}")
    public PrivilegeDto get(@PathVariable(name = "id") Long id) {
        return privilegeService.getPrivilege(id);
    }

    @PutMapping("/privilege")
    public void update(@RequestBody PrivilegeDto privilegeDto) {
        privilegeService.update(privilegeDto);

    }
}
