package com.example.easystay.repository;

import com.example.easystay.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationStatus(String status);
    List<Reservation> findByUserId(Long userId);
}
