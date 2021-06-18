package com.meli.desafio.utils;

import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.DistrictRequestDTO;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.dto.RoomResponseDTO;

public class Mappers {

    public static HouseDTO houseToDTO(House house, DistrictDTO district){
        return HouseDTO.builder()
                .name(house.getName())
                .district(district)
                .rooms(house.getRooms())
                .build();
    }

    public static DistrictDTO districtToDTO(District district){
        return DistrictDTO.builder()
                .name(district.getName())
                .build();
    }

    public static House houseDTOtoHouse(HouseDTO houseDTO, Integer districtId) {
        return House.builder()
                .name(houseDTO.getName())
                .districtId(districtId)
                .rooms(houseDTO.getRooms())
                .build();
    }

    public static RoomResponseDTO roomToResponseDTO(Room r, double metters) {
        return RoomResponseDTO.builder()
                .name(r.getName())
                .totalMeters(metters)
                .build();
    }

    public static District districtRequestToDistrict(DistrictRequestDTO d, Integer id) {
        return District.builder()
                .id(id)
                .name(d.getName())
                .price(d.getPrice())
                .build();
    }
}
