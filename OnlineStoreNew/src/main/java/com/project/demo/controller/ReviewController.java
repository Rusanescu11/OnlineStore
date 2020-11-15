package com.project.demo.controller;

import com.project.demo.persitance.dto.ReviewDto;
import com.project.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/review")
    public void add(@RequestBody ReviewDto reviewDto) {
        reviewService.add(reviewDto);
    }
    @DeleteMapping("/review/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        reviewService.delete(id);
    }
    @GetMapping("/review")
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }
    @PutMapping("/review")
    public void update(@RequestBody ReviewDto reviewDto) {
        reviewService.update(reviewDto);
    }
    @GetMapping("/review/{id}")
    public ReviewDto get(@PathVariable(name = "id") Long id) {
        return reviewService.getReview(id);
    }
}
