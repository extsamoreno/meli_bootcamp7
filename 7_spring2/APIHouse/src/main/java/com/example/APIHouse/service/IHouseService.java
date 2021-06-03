package com.example.APIHouse.service;

import com.example.APIHouse.repository.House;
import com.example.APIHouse.service.dto.HouseResponseDTO;



public interface IHouseService {
    HouseResponseDTO getHouseInfo(House house);
}
