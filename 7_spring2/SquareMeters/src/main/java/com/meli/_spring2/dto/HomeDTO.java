package com.meli._spring2.dto;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class HomeDTO {

    private String name;

    private String address;

    private List<RoomDTO> roomDTOList;

    public RoomDTO getBiggetsRoom(){
        Optional<RoomDTO> biggestRoom = roomDTOList.stream().max((room1, room2) -> (int) (room1.getSquareMeters() - room2.getSquareMeters()));
        RoomDTO roomDTO = biggestRoom.get();
        return roomDTO;
    }

}
