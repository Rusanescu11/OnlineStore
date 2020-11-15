package com.project.demo.service;

import com.project.demo.persitance.dto.ManufacturerDto;
import com.project.demo.persitance.model.ManufacturerModel;
import com.project.demo.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerDto> getManufacturer() {
        List<ManufacturerModel> manufacturerModelList = manufacturerRepository.findAll();
        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();
        for (ManufacturerModel manufacturerModel : manufacturerModelList) {
            ManufacturerDto manufacturerDto = new ManufacturerDto();
            manufacturerDto.setId(manufacturerModel.getId());
            manufacturerDto.setName(manufacturerModel.getName());
            manufacturerDtoList.add(manufacturerDto);
        }
        return manufacturerDtoList;
    }

    public void addManufacturer(ManufacturerDto manufacturerDto) {
        ManufacturerModel manufacturerModel = new ManufacturerModel();
        manufacturerModel.setId(manufacturerDto.getId());
        manufacturerModel.setName(manufacturerDto.getName());
        manufacturerRepository.save(manufacturerModel);
    }

    public void deleteById(Long Id) {
        manufacturerRepository.deleteById(Id);

    }

    public ManufacturerDto get(long id){
        ManufacturerModel manufacturerModel = manufacturerRepository.findById(id).orElse(null);
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        manufacturerDto.setId(manufacturerModel.getId());
        manufacturerDto.setName(manufacturerDto.getName());
        return manufacturerDto;

    }

    public void update(ManufacturerDto manufacturerDto) {
        Optional<ManufacturerModel> manufacturerModelOptional = manufacturerRepository.findById(manufacturerDto.getId());
        if (manufacturerModelOptional.isPresent()) {
            ManufacturerModel manufacturerModel = manufacturerModelOptional.get();
            manufacturerModel.setId(manufacturerDto.getId());
            manufacturerModel.setName(manufacturerDto.getName());
            manufacturerRepository.save(manufacturerModel);
        }
    }
}
