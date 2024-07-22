package com.example.easystay.mapper;

import com.example.easystay.model.entity.Reservation;
import com.example.easystay.model.entity.User;
import com.example.easystay.service.dtos.requests.reservation.AddReservationRequest;
import com.example.easystay.service.dtos.responses.reservation.AddReservationResponse;
import com.example.easystay.service.dtos.responses.reservation.DeleteReservationResponse;
import com.example.easystay.service.dtos.responses.reservation.GetResevationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "checkInDate", target = "checkInDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "checkOutDate", target = "checkOutDate", dateFormat = "yyyy-MM-dd")
    Reservation reservationFromRequest(AddReservationRequest request);


    @Mapping(target = "firstName",source = "user.firstName")
    @Mapping(target = "lastName",source = "user.lastName")
    AddReservationResponse reservationFromResponse(Reservation reservation);

    DeleteReservationResponse reservationFromDeleteResponse(Reservation reservation);
    GetResevationResponse reservationFromGetResponse(Reservation reservation);
}
