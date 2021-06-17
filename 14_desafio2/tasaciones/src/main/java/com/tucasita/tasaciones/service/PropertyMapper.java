package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;

import java.util.ArrayList;
import java.util.List;

public class PropertyMapper {

    public static Property toEntity(PropertyDTO dto) {
        Neighborhood neighborhood = new Neighborhood(dto.getNeighborhood().getName(), dto.getNeighborhood().getPrice());
        List<Room> rooms = new ArrayList<>();
        for (RoomDTO room : dto.getRooms()) {
           Room r = new Room(room.getName(), room.getLength(), room.getWidth());
           rooms.add(r);
        }
        return new Property(0, dto.getName(), neighborhood, rooms);
    }

    public static RoomDTO toRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.getWidth(), room.getLength());
    }
}
