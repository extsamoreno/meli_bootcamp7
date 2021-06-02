package com.meli.squaremeters.service;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.Room;
import com.meli.squaremeters.domain.HouseDTO;
import com.meli.squaremeters.domain.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private double price = 800;

    public HouseDTO getHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setTotalMeters(calculateTotalSquareMeters(house.getRooms()));
        houseDTO.setHouseValue(getHouseValue(price, house.getRooms()));
        houseDTO.setLargestRoom(findLargestRoom(house.getRooms()));
        houseDTO.setRooms(this.getRoomsDTO(house.getRooms()));
        return houseDTO;
    }

    public double calculateTotalSquareMeters(List<Room> rooms) {
        return rooms.stream().mapToDouble(f -> calculateSquareMeters(f)).sum();
    }

    public double getHouseValue(double price, List<Room> rooms) {
        return calculateTotalSquareMeters(rooms) * price;
    }

    public Room findLargestRoom(List<Room> rooms) {
        final Optional<Room> max = rooms.stream().max((elem1, elem2) -> (int) (calculateSquareMeters(elem1) - calculateSquareMeters(elem2)));
        return max.get();
    }

    public double calculateSquareMeters(Room room) {
        return room.getWidth() * room.getLength();
    }

    public List<RoomDTO> getRoomsDTO(List<Room> rooms) {
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room r : rooms) {
            roomsDTO.add(createRoomDTO(r));
        }
        return roomsDTO;
    }

    private RoomDTO createRoomDTO(Room room) {
        return new RoomDTO(room.getName(), calculateSquareMeters(room));
    }

}
