package com.example.easystay.service.abstracts;

import com.example.easystay.service.dtos.requests.review.AddReviewRequest;

public interface ReviewService {
    void addReview(AddReviewRequest request);
}
