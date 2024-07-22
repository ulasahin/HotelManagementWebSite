package com.example.easystay.service.dtos.requests.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReviewRequest {
    private int rating;
    private String reviewText;
    private int reservationId;
}
