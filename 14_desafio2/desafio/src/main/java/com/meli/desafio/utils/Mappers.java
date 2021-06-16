package com.meli.desafio.utils;

import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.HouseDTO;

public class Mappers {

    public static HouseDTO houseToDTO(House house){
        return HouseDTO.builder()
                .name(house.getName())
                .district(house.getDistrict())
                .rooms(house.getRooms())
                .build();
    }

    public static DistrictDTO DistrictToDTO(District district){
        return DistrictDTO.builder()
                .name(district.getName())
                .price(district.getPrice())
                .build();
    }
}
