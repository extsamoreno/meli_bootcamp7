package com.meli.squaremeters.services;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.HouseDTO;

public class HouseService {
    public static HouseDTO getHouseData(House house) {
        return new HouseDTO(house.calculateTotalSquareMeters(),
                house.getHouseValue(800),
                house.findLargestRoom(),
                house.getRoomDTO());
    }
}
