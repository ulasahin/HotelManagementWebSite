package com.example.easystay.controller;

import com.example.easystay.model.entity.Reservation;
import com.example.easystay.model.entity.User;
import com.example.easystay.repository.ReservationRepository;
import com.example.easystay.repository.UserRepository;
import com.example.easystay.service.abstracts.ReservationService;
import com.example.easystay.service.dtos.requests.reservation.AddReservationRequest;
import com.example.easystay.service.dtos.requests.reservation.UpdateReservationRequest;
import com.example.easystay.service.dtos.responses.reservation.AddReservationResponse;
import com.example.easystay.service.dtos.responses.reservation.DeleteReservationResponse;
import com.example.easystay.service.dtos.responses.reservation.ListMyReservationResponse;
import com.example.easystay.service.dtos.responses.reservation.ListReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("reservs")
@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final UserRepository userRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("allReservs")
    @ResponseStatus(HttpStatus.OK)
    public List<ListReservationResponse> getAll(){
       return reservationService.getAll();
    }

    @PostMapping("addReservs")
    @ResponseStatus(HttpStatus.CREATED)
    public AddReservationResponse add(AddReservationRequest request){
     return reservationService.add(request);
    }

    @GetMapping("myReservations")
    public List<ListMyReservationResponse> getMyReservations(){
        return reservationService.getUserReservations();
    }

    @PutMapping("editReservs")
    @ResponseStatus(HttpStatus.OK)
    public AddReservationResponse controlReservation(@RequestBody UpdateReservationRequest request){
        return reservationService.update(request);
    }
    @PutMapping("cancelReservation")
    @ResponseStatus(HttpStatus.OK)
    public void cancelReservation(@RequestParam long id){
        reservationService.cancelReservation(id);
    }
    @DeleteMapping("deleteReservation")
    public DeleteReservationResponse delete(@RequestParam long id){
        return reservationService.delete(id);
    }
}
