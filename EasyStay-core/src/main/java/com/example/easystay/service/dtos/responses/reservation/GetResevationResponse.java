package com.example.easystay.service.dtos.responses.reservation;

import com.example.easystay.model.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetResevationResponse {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus reservationStatus;
}
