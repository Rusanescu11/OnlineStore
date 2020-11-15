package com.project.demo.persitance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


    @Entity
    public class ReviewModel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String comment;
        private int rating;
        @ManyToOne(fetch = FetchType.EAGER)
        @JsonIgnoreProperties("reviewModelList")
        private ProductModel product;
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
        public ProductModel getProduct() {
            return product;
        }
        public void setProduct(ProductModel product) {
            this.product = product;
        }
    }

