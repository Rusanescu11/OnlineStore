package com.project.demo.persitance.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {


        private Long id;
        private String name;

        private CategoryDto parent;

        private List<CategoryDto> subcategories = new ArrayList<>();


        private List<ProductDto> products = new ArrayList<>();

        public List<ProductDto> getProducts() {
            return products;
        }

        public void setProducts(List<ProductDto> products) {
            this.products = products;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    public List<CategoryDto> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CategoryDto> subcategories) {
        this.subcategories = subcategories;
    }

    public CategoryDto getParent() {
        return parent;
    }

    public void setParent(CategoryDto parent) {
        this.parent = parent;
    }
}
