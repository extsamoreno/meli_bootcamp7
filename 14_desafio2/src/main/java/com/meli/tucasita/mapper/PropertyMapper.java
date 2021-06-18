package com.meli.tucasita.mapper;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.models.Property;
import com.meli.tucasita.models.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyMapper {

    public static Property mapPropertyFromDTO(PropertyDTO propertyDTO) {

        Property property = new Property();

        property.setName(propertyDTO.getName());
        property.setDistrict(propertyDTO.getDistrict());
        property.setRooms(mapRoomsFromRoomsDTO(propertyDTO.getRooms()));

        return property;
    }

    private static List<Room> mapRoomsFromRoomsDTO(List<RoomDTO> roomDTOList) {

        List<Room> rooms = new ArrayList<>();
        roomDTOList.forEach(r -> rooms.add(mapFromRoomDTO(r)));

        return rooms;
    }

    private static Room mapFromRoomDTO(RoomDTO roomDTO){

        Room room = new Room();

        room.setName(roomDTO.getName());
        room.setWidth(roomDTO.getWidth());
        room.setLength(roomDTO.getLength());

        return room;
    }
}
