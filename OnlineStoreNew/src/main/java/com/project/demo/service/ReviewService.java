package com.project.demo.service;

import com.project.demo.persitance.dto.ProductDto;
import com.project.demo.persitance.dto.ReviewDto;
import com.project.demo.persitance.model.ProductModel;
import com.project.demo.persitance.model.ReviewModel;
import com.project.demo.repository.ProductRepository;
import com.project.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class ReviewService {
        @Autowired
        private ReviewRepository reviewRepository;
        @Autowired
        private ProductRepository productRepository;
        public List<ReviewDto> getAll() {
            List<ReviewModel> reviewModels = reviewRepository.findAll();
            List<ReviewDto> reviewDto = new ArrayList<>();
            for (ReviewModel reviewModel : reviewModels) {
                ReviewDto reviewDto1 = new ReviewDto();
                reviewDto1.setId(reviewModel.getId());
                reviewDto1.setComment(reviewModel.getComment());
                reviewDto1.setRating(reviewModel.getRating());
                reviewDto.add(reviewDto1);
            }
            return reviewDto;
        }
        public void add(ReviewDto reviewDto) {
            ReviewModel reviewModel = new ReviewModel();
            reviewModel.setComment(reviewDto.getComment());
            reviewModel.setRating(reviewDto.getRating());
            ProductDto productDto = reviewDto.getProductDto();
            if(productDto != null){
                ProductModel productModel = productRepository.findById(productDto.getId()).orElse(null);
                reviewModel.setProduct(productModel);
            }reviewRepository.save(reviewModel);
        }
        public ReviewDto getReview(long id) {
            ReviewModel reviewModel = reviewRepository.findById(id).orElse(null);
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setId(reviewModel.getId());
            reviewDto.setComment(reviewModel.getComment());
            reviewDto.setRating(reviewModel.getRating());
            reviewModel.setProduct(reviewModel.getProduct());
            return reviewDto;
        }
        public void delete(long id) {
            reviewRepository.deleteById(id);
        }
        public void update(ReviewDto reviewDto) {
            ReviewModel reviewModel = reviewRepository.findById(reviewDto.getId()).orElse(null);
            reviewModel.setId(reviewDto.getId());
            reviewModel.setRating(reviewDto.getRating());
            reviewModel.setComment(reviewDto.getComment());
            ProductModel productModel =new ProductModel();
            ProductDto productDto=reviewDto.getProductDto();
            productModel.setName(productDto.getName());
            reviewRepository.save(reviewModel);
        }
    }

