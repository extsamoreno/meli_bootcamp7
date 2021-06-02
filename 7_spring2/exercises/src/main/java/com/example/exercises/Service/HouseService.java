package com.example.exercises.Service;

import com.example.exercises.Models.DTO.HouseDTO;
import com.example.exercises.Models.House;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    public HouseDTO getHouseData(House house) {
        HouseDTO response = new HouseDTO();
        response.setTotalMeters(house.calculateTotalSquareMeters());
        response.setHouseValue(house.getHouseValue(800));
        response.setLargestRoom(house.findLargestRoom());
        response.setRooms(house.getRoomDTO());

        return response;
    }
}
