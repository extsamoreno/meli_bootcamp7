package com.example.desafio2.services.mappers;

import com.example.desafio2.dtos.HouseDTO;
import com.example.desafio2.models.House;

public class HouseMapper {
    public static House toModel(HouseDTO house){
        House modelHouse = new House();

        modelHouse.setName(house.getName());
        modelHouse.setRoomList(RoomMapper.toModelList(house.getRoomList()));
        modelHouse.setDistrict(DistrictMapper.toModel(house.getDistrict()));

        return modelHouse;
    }
}
