package com.example.easystay.controller;

import com.example.easystay.model.enums.RoomType;
import com.example.easystay.repository.RoomRepository;
import com.example.easystay.service.abstracts.RoomService;
import com.example.easystay.service.dtos.requests.room.AddRoomRequest;
import com.example.easystay.service.dtos.requests.room.UpdateRoomRequest;
import com.example.easystay.service.dtos.responses.room.AddRoomResponse;
import com.example.easystay.service.dtos.responses.room.DeleteRoomResponse;
import com.example.easystay.service.dtos.responses.room.GetRoomResponse;
import com.example.easystay.service.dtos.responses.room.ListRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("allRooms")
    @ResponseStatus(HttpStatus.OK)
    private List<ListRoomResponse> getAll(){
        return roomService.getAll();
    }

    @GetMapping("ByRoomType")
    @ResponseStatus(HttpStatus.OK)
    private List<ListRoomResponse> getRoomType(@RequestParam RoomType roomType){return roomService.findByRoomType(roomType);
    }
    @PostMapping("addRoom")
    @ResponseStatus(HttpStatus.CREATED)
    private AddRoomResponse add(AddRoomRequest request){
        return roomService.add(request);
    }

    @DeleteMapping("deleteRoom")
    public DeleteRoomResponse delete(@RequestParam long id){
        return roomService.delete(id);
    }
    @PutMapping("updateRoom")
    @ResponseStatus(HttpStatus.OK)
    public AddRoomResponse update(@RequestBody UpdateRoomRequest request){
        return roomService.update(request);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetRoomResponse getById(long id){
        return roomService.getById(id);
    }

}
