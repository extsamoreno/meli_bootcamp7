package com.tucasitatasaciones.tucasitatasaciones.services.mappers;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class OwnershipMapper {
    public static Ownership dtoToEntity(OwnershipWithDataDTO ownership) {
        var result = new Ownership();

        result.setId(ownership.getId());
        result.setName(ownership.getName());
        result.setDistrictId(ownership.getDistrict().getId());
        result.setRooms(roomDtoToRoom(ownership.getRooms()));

        return result;
    }

    private static List<Room> roomDtoToRoom(List<RoomDTO> rooms) {
        var result = new ArrayList<Room>();

        for (RoomDTO room : rooms) {
            result.add(roomDtoToRoom(room));
        }

        return result;
    }

    private static Room roomDtoToRoom(RoomDTO room) {
        var result = new Room();

        result.setName(room.getName());
        result.setWidth(room.getWidth());
        result.setHigh(room.getHigh());

        return result;
    }
}
