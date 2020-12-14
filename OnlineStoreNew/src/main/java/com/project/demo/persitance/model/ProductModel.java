package com.project.demo.persitance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("product")
    private List<OrderLineModel> orderlines;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    private CategoryModel category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    private ManufacturerModel manufacturer;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.MERGE,orphanRemoval = true)
    @JsonIgnoreProperties("product")
    private PhotoP photos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", orphanRemoval = false)
    @JsonIgnoreProperties("product")
    private List<ReviewModel>reviewModelList =new ArrayList<>();
    public List<OrderLineModel> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLineModel> orderlines) {
        this.orderlines = orderlines;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ManufacturerModel getManufacturer() {
        return manufacturer;
    }

    public PhotoP getPhotos() {
        return photos;
    }

    public void setPhotos(PhotoP photos) {
        this.photos = photos;
    }

    public void setManufacturer(ManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<ReviewModel> getReviewModelList() {
        return reviewModelList;
    }

    public void setReviewModelList(List<ReviewModel> reviewModelList) {
        this.reviewModelList = reviewModelList;
    }
}
