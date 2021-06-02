package com.meli.squaremeters.service;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.Room;
import com.meli.squaremeters.domain.HouseDTO;
import com.meli.squaremeters.domain.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    private double price = 800;

    public HouseDTO getHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setTotalMeters(house.calculateTotalSquareMeters());
        houseDTO.setHouseValue(house.getHouseValue(price));
        houseDTO.setLargestRoom(house.findLargestRoom());
        houseDTO.setRooms(this.getRoomsDTO(house.getRooms()));
        return houseDTO;
    }

    public List<RoomDTO> getRoomsDTO(List<Room> rooms) {
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room r : rooms) {
            roomsDTO.add(createRoomDTO(r));
        }
        return roomsDTO;
    }

    private RoomDTO createRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.calculateSquareMeters());
    }

}
