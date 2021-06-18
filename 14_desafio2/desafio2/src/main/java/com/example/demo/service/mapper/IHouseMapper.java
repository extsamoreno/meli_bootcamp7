package com.example.demo.service.mapper;


import com.example.demo.models.House;
import com.example.demo.service.dto.HouseDTO;
import com.example.demo.service.dto.ResponseHouseDTO;

public interface IHouseMapper {
    House houseDTOToHouse(HouseDTO houseDTO);
    HouseDTO houseToHouseDTO(House house);
}
