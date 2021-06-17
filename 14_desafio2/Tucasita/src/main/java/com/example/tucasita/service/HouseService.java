package com.example.tucasita.service;

import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.HouseWithLargestRoom;
import com.example.tucasita.dto.response.HouseWithRoomsMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalMeters;
import com.example.tucasita.dto.response.HouseWithTotalValue;
import com.example.tucasita.repository.IDistrictRepository;
import com.example.tucasita.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseRepository houseRepository;
    @Autowired
    IDistrictRepository districtRepository;

    @Override
    public HouseWithTotalMeters calculateTotalMeters(HouseDTO houseDto) {
        return null;
    }

    @Override
    public HouseWithTotalValue calculateTotalValue(HouseDTO houseDto) {
        return null;
    }

    @Override
    public HouseWithLargestRoom calculateLargestRoom(HouseDTO houseDto) {
        return null;
    }

    @Override
    public HouseWithRoomsMetersDTO calculateRoomsSquareMeters(HouseDTO houseDto) {
        return null;
    }
}
