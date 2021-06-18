package com.example.demo.service.mapper;

import com.example.demo.models.House;
import com.example.demo.service.dto.HouseDTO;
import com.example.demo.service.dto.ResponseHouseDTO;

public class HouseMapper implements IHouseMapper{
    @Override
    public House houseDTOToHouse(HouseDTO houseDTO) {
        House house = new House();
        house.setProp_name(houseDTO.getProp_name());
        house.setDistric_name(houseDTO.getDistric_name());
        house.setEnvironmentArrayList(houseDTO.getEnvironmentArrayList());
        return house;
    }

    @Override
    public HouseDTO houseToHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setDistric_name(house.getDistric_name());
        houseDTO.setProp_name(house.getProp_name());
        houseDTO.setEnvironmentArrayList(house.getEnvironmentArrayList());
        return houseDTO;
    }
}
