package com.meli.squaremeters.service;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.HouseDTO;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    public HouseDTO getHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setTotalMeters(house.calculateTotalSquareMeters());
        houseDTO.setHouseValue(house.getHouseValue(800));
        houseDTO.setLargestRoom(house.findLargestRoom());
        houseDTO.setRooms(house.getRoomDTO());

        return houseDTO;
    }
}
