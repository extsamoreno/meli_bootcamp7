package com.example.tucasita.service;

import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.HouseWithLargestRoom;
import com.example.tucasita.dto.response.HouseWithRoomsMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalMeters;
import com.example.tucasita.dto.response.HouseWithTotalValue;

public interface IHouseService {

    HouseWithTotalMeters calculateTotalMeters(HouseDTO houseDto);

    HouseWithTotalValue calculateTotalValue(HouseDTO houseDto);

    HouseWithLargestRoom calculateLargestRoom(HouseDTO houseDto);

    HouseWithRoomsMetersDTO calculateRoomsSquareMeters(HouseDTO houseDto);
}
