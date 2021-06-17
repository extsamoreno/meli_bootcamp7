package com.example.desafio2.service.Mapper;

import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import com.example.desafio2.service.DTO.NeighborhoodDTO;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.RoomDTO;

import java.util.LinkedList;
import java.util.List;

public class PropertyMapper {
    public static RoomDTO roomtoRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.getWidth(), room.getLength());
    }

    public static Property propDTOtoProp(PropertyDTO property) {
        return new Property(property.getName(), neighborhoodDTOtoNeighborhood(property.getNeighborhood()), roomDTOtoRoom(property.getRooms()));
    }

    public static Neighborhood neighborhoodDTOtoNeighborhood(NeighborhoodDTO neighborhood){
        return new Neighborhood(neighborhood.getName(), neighborhood.getPrice());
    }
    public static Room roomDTOtoRoom(RoomDTO room){
        return new Room(room.getName(),room.getWidth(),room.getLength());
    }
    public static List<Room> roomDTOtoRoom(List<RoomDTO> rooms){
        List<Room> roomsMapped = new LinkedList<>();
        for(RoomDTO room : rooms){
            roomsMapped.add(roomDTOtoRoom(room));
        }
        return roomsMapped;
    }
}
