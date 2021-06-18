package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.*;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;

import java.util.ArrayList;
import java.util.List;

public class PropertyMapper {

    public static Property toEntity(PropertyDTO dto, Neighborhood neighborhood) {
        List<Room> rooms = new ArrayList<>();
        for (RoomDTO room : dto.getRooms()) {
           Room r = new Room(room.getName(), room.getLength(), room.getWidth());
           rooms.add(r);
        }
        return new Property(0, dto.getName(), neighborhood, rooms);
    }

    public static List<PropertyAllDTO> toAllPropertiesList(List<Property> entities) {
        List<PropertyAllDTO> properties = new ArrayList<>();
        entities.forEach(e -> {
            properties.add(toPropertyAllDTO(e));
        });
        return properties;
    }

    public static PropertyAllDTO toPropertyAllDTO(Property property) {
        List<RoomDTO> rooms = new ArrayList<>();
        property.getRooms().forEach(r -> {
            rooms.add(new RoomDTO(r.getName(), r.getWidth(), r.getLength()));
        });
        return new PropertyAllDTO(property.getName(), toNeighborhoodDTO(property.getNeighborhood()), rooms);
    }

    public static NeighborhoodDTO toNeighborhoodDTO(Neighborhood n) {
        return new NeighborhoodDTO(n.getName(), n.getPrice());
    }

    public static RoomDTO toRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.getWidth(), room.getLength());
    }

    public static RoomSquareMetersDTO toSquareMetersDTO(Room room) {
        return new RoomSquareMetersDTO(room.getName(), room.getLength() * room.getWidth());
    }

    public static Neighborhood toNeighborhoodEntity(NeighborhoodDTO dto) {
        return new Neighborhood(dto.getName(), dto.getPrice());
    }
}
