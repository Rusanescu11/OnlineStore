package com.project.demo.persitance.dto;



public class ProductDto {
    private long id;
    private String name;
    private String photo;
    private String description;
    private double price;

    private OrderLineDto orderline;
    private String productType;
    private CategoryDto subcategory;
    private ManufacturerDto manufacturer;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public OrderLineDto getOrderline() {
        return orderline;
    }

    public void setOrderline(OrderLineDto orderline) {
        this.orderline = orderline;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public CategoryDto getCategory() {
        return subcategory;
    }

    public void setCategory(CategoryDto subcategory) {
        this.subcategory = subcategory;
    }

    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }
}
