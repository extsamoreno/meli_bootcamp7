package com.meli.desafio.utils;

import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static House getTotalHouse(String name){
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder()
                .name("Room1")
                .width(25.00)
                .length(25.00)
                .build());
        rooms.add(Room.builder()
                .name("Room2")
                .width(20.00)
                .length(12.00)
                .build());
        return House.builder()
                .id(1)
                .districtId(1)
                .rooms(rooms)
                .build();
    }

    public static HouseDTO getTotalHouseDTO(String name){
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder()
                .name("Room1")
                .width(25.00)
                .length(25.00)
                .build());
        rooms.add(Room.builder()
                .name("Room2")
                .width(20.00)
                .length(12.00)
                .build());

        DistrictDTO district = DistrictDTO.builder()
                .name("Avellaneda")
                .build();

        return HouseDTO.builder()
                .name(name)
                .district(district)
                .rooms(rooms)
                .build();
    }

    public static ErrorDTO getValidationError(String message){
        return ErrorDTO.builder()
                .name("MethodArgumentNotValidException")
                .message(message)
                .build();
    }

    public static District getDistrict(String name) {
        return District.builder()
                .name(name)
                .price(100)
                .id(1)
                .build();
    }

    public static DistrictDTO getDistrictDTO(String name) {
        return DistrictDTO.builder().name(name).build();
    }
}
