package com.example.easystay.service.dtos.responses.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomResponse {
    private int roomNumber;
    private double price;
}
