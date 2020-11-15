package com.project.demo.controller;



import com.project.demo.persitance.dto.ManufacturerDto;
import com.project.demo.persitance.dto.OrderDto;
import com.project.demo.repository.ManufacturerRepository;
import com.project.demo.service.ManufacturerService;
import com.project.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @PostMapping("/manufacturer")
    public void add(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.addManufacturer(manufacturerDto);
    }
    @DeleteMapping("/manufacturer/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        manufacturerService.deleteById(id);
    }
    @GetMapping("/manufacturer")
    public List<ManufacturerDto> getAll() {
        return manufacturerService.getManufacturer();
    }

    @GetMapping("/manufacturer/{id}")
    public ManufacturerDto get(@PathVariable(name = "id") Long id) {
        return manufacturerService.get(id);
    }

    @PutMapping("/manufacturer")
    public void update(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.update(manufacturerDto);

    }


}
