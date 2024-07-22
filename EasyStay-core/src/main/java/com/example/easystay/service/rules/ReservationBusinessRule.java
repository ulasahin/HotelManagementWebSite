package com.example.easystay.service.rules;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.model.entity.Room;
import com.example.easystay.model.enums.RoomStatus;
import com.example.easystay.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationBusinessRule {

    @Autowired
    private RoomRepository roomRepository;

    public void isRoomFull(Room room){
        if(room.getStatus()== RoomStatus.OCCUPIED){
            throw new BusinessException(ErrorMessages.ROOM_FULL);
        }
    }
}
