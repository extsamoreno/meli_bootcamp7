package com.example.springclase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomName;
    private Double roomArea;

    public RoomDTO(Room room)
    {
        setRoomName(room.getRoomName());
        setRoomArea(room.getArea());
    }

}


