package com.example.easystay.service.dtos.requests.reservation;

import com.example.easystay.model.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationRequest {
    private long id;
    private ReservationStatus status;
}
