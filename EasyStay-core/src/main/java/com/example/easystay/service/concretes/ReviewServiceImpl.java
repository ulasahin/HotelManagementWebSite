package com.example.easystay.service.concretes;

import com.example.easystay.model.entity.Reservation;
import com.example.easystay.model.entity.Review;
import com.example.easystay.repository.ReviewRepository;
import com.example.easystay.service.abstracts.ReservationService;
import com.example.easystay.service.abstracts.ReviewService;
import com.example.easystay.service.dtos.requests.review.AddReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final ReservationService reservationService;

    @Override
    public void addReview(AddReviewRequest request) {


        //TODO: if token user is not reservation user throw an error!

        Review review = new Review();
        review.setReviewText(request.getReviewText());
        review.setRating(request.getRating());


        repository.save(review);
    }
}
