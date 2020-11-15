package com.project.demo.persitance.dto;



import com.project.demo.persitance.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerDto {
    private long id;
    private String name;
    private List<ProductModel> products = new ArrayList();

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

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
