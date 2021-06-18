package com.example.tucasita.service;

import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.HouseWithLargestRoomDTO;
import com.example.tucasita.dto.response.HouseWithRoomsMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalValueDTO;

public interface IHouseService {

    HouseWithTotalMetersDTO calculateTotalMeters(HouseDTO houseDto);

    HouseWithTotalValueDTO calculateTotalValue(HouseDTO houseDto);

    HouseWithLargestRoomDTO calculateLargestRoom(HouseDTO houseDto);

    HouseWithRoomsMetersDTO calculateRoomsSquareMeters(HouseDTO houseDto);
}
