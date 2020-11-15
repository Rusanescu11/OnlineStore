package com.project.demo.persitance.dto;

public class ReviewDto {
    private long id;
    private String comment;
    private int rating;
    private ProductDto productDto;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public ProductDto getProductDto() {
        return productDto;
    }
    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
