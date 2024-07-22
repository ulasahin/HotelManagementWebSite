package com.example.easystay.controller;

import com.example.easystay.service.abstracts.ReviewService;
import com.example.easystay.service.dtos.requests.review.AddReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("reviews")
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(AddReviewRequest request){
        reviewService.addReview(request);
    }

}
