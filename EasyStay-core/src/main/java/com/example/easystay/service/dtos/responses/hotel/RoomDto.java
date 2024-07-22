package com.example.easystay.service.dtos.responses.hotel;

import com.example.easystay.model.entity.Room;
import com.example.easystay.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private double price;
    private RoomType roomType;
    private int roomNumber;
}
