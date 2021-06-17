package com.meli.calculatorHouseSquareMeters.model.mapper;

import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dto.RoomResponseDTO;

public class RoomMapper {
    public static RoomResponseDTO toRoomResponseDTO(Room room) {
        return new RoomResponseDTO(room.getName(), (room.getWidth() * room.getLength()));
    }
}
