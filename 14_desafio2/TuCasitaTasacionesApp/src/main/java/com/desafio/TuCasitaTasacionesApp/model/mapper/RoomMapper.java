package com.desafio.TuCasitaTasacionesApp.model.mapper;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Room;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RoomMapper {
    public RoomDTO mapToRoomDTO(Room room){
        return new RoomDTO(room.getName(), room.getWidth(), room.getLenght());
    }

    public List<RoomDTO> mapToRoomDTOList(List<Room> roomList){
        List <RoomDTO> roomDTOList =  new ArrayList<>();
        for(Room r : roomList) roomDTOList.add(mapToRoomDTO(r));
        return roomDTOList;
    }

    public Room mapToRoomEntity(RoomDTO roomDTO){
        return new Room(roomDTO.getName(), roomDTO.getWidth(), roomDTO.getLenght());
    }

    public List<Room> mapToRoomEntityList(List<RoomDTO> roomDTOList){
        List <Room> roomList =  new ArrayList<>();
        for(RoomDTO r : roomDTOList) roomList.add(mapToRoomEntity(r));
        return roomList;
    }
}
