package com.project.demo.controller;


import com.project.demo.persitance.dto.CategoryDto;
import com.project.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/category")
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.add(categoryDto);
    }
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
    }
    @GetMapping("/category")
    public List<CategoryDto> getCategory() {
        return categoryService.getCategories();
    }
    @GetMapping("/categorySub")
    public List<CategoryDto> getSubCategory() {
        return categoryService.getSubCategories();
    }
    @GetMapping("/category/{id}")
    public CategoryDto getCategory(@PathVariable(name = "id") Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping("/category")
    public void update(@RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryDto);
    }
    @GetMapping("/categorySubById/{id}")
    public List<CategoryDto> getSubCategory(@PathVariable(name = "id") Long id) {
        return categoryService.findCategoriesByParent(id);
    }
}
