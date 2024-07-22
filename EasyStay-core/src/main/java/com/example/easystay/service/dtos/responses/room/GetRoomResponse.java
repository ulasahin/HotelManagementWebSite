package com.example.easystay.service.dtos.responses.room;

import com.example.easystay.model.enums.RoomType;
import com.example.easystay.model.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomResponse {
    private long id;
    private int roomNumber;
    private double price;
    private RoomStatus status;
    private RoomType roomType;
}
