package com.example.easystay.mapper;

import com.example.easystay.model.entity.Room;
import com.example.easystay.service.dtos.responses.room.DeleteRoomResponse;
import com.example.easystay.service.dtos.responses.room.GetRoomResponse;
import com.example.easystay.service.dtos.responses.user.DeleteUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
    DeleteRoomResponse roomFromDeleteResponse(Room room);
    GetRoomResponse roomFromGetResponse(Room room);
}
