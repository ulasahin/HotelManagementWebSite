package com.example.easystay.service.abstracts;

import com.example.easystay.model.enums.RoomType;
import com.example.easystay.service.dtos.requests.room.AddRoomRequest;
import com.example.easystay.service.dtos.requests.room.UpdateRoomRequest;
import com.example.easystay.service.dtos.responses.room.AddRoomResponse;
import com.example.easystay.service.dtos.responses.room.DeleteRoomResponse;
import com.example.easystay.service.dtos.responses.room.GetRoomResponse;
import com.example.easystay.service.dtos.responses.room.ListRoomResponse;

import java.util.List;

public interface RoomService {
    List<ListRoomResponse> getAll();
    AddRoomResponse add(AddRoomRequest request);
    AddRoomResponse update(UpdateRoomRequest request);
    DeleteRoomResponse delete(long id);
    GetRoomResponse getById(long id);
    List<ListRoomResponse> findByRoomType(RoomType roomType);


}
