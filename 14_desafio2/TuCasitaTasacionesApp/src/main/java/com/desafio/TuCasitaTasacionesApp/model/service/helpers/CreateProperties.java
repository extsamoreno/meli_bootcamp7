package com.desafio.TuCasitaTasacionesApp.model.service.helpers;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.models.Room;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class CreateProperties {

    public static PropietyDTO create1HouseDTOWith2Rooms1x1(String name, String neighborhood){
        RoomDTO roomDTO1 = new RoomDTO("room1", 1D, 1D);
        RoomDTO roomDTO2 = new RoomDTO("room2", 1D, 1D);
        List<RoomDTO> roomList = new ArrayList<>();
        roomList.add(roomDTO1);
        roomList.add(roomDTO2);

        PropietyDTO PropietyDTOAux = new PropietyDTO();
        PropietyDTOAux.setName(name);
        PropietyDTOAux.setNeighborhood(neighborhood);
        PropietyDTOAux.setRoomList(roomList);

        return PropietyDTOAux;
    }


    public static Propiety create1HouseWith2Rooms1x1(String name, String neighborhood){
        Room roomDTO1 = new Room("room1", 1D, 1D);
        Room roomDTO2 = new Room("room2", 1D, 1D);
        List<Room> roomList = new ArrayList<>();
        roomList.add(roomDTO1);
        roomList.add(roomDTO2);

        Propiety propietyAux = new Propiety();
        propietyAux.setName(name);
        propietyAux.setNeighborhood(neighborhood);
        propietyAux.setRoomList(roomList);

        return propietyAux;
    }

    public static Propiety create1HouseWith2Rooms1x1_1x2(String name, String neighborhood){
        Room roomDTO1 = new Room("room1", 1D, 1D);
        Room roomDTO2 = new Room("room2", 1D, 2D);
        List<Room> roomList = new ArrayList<>();
        roomList.add(roomDTO1);
        roomList.add(roomDTO2);

        Propiety propietyAux = new Propiety();
        propietyAux.setName(name);
        propietyAux.setNeighborhood(neighborhood);
        propietyAux.setRoomList(roomList);

        return propietyAux;
    }


}
