package com.tuCasita.tuCasita.service;

import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;

public interface iTuCasitaService {

    HouseDTO calculateTotalM2(House house);
    HouseDTO calculateHouseValue(House house);
    void validateDistrict (District district);
    Room biggestRoom(House house);
    ResponseRoomsDTO calculateRoomM2 (House house);
}
