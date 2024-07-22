package com.example.easystay.service.dtos.requests.room;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.model.enums.RoomType;
import com.example.easystay.model.enums.RoomStatus;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomRequest {
    private long id;
    @Pattern(regexp = "\\d+",message = ErrorMessages.JUST_NUMERIC_CHAR_FOR_ROOM_NUMBER)
    private int roomNumber;

    @Pattern(regexp = "\\d+",message = ErrorMessages.JUST_NUMERIC_CHAR_FOR_ROOM_PRICE)
    private double price;

    private RoomType roomType;

    private RoomStatus status;
}
