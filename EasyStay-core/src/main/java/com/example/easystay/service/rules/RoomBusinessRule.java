package com.example.easystay.service.rules;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.model.entity.Room;
import com.example.easystay.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomBusinessRule {
    @Autowired
    private RoomRepository roomRepository;

    public void roomNumberShouldNotExist(int roomNumber){
        Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
        if (room.isPresent()){
            throw new BusinessException(ErrorMessages.ROOM_NUMBER_NOT_FOUND);
        }
    }
}
