package com.meli.desafio.utils;

import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static HouseDTO getTotalHouse(String name){
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder()
                .name("Room1")
                .width(25)
                .length(25)
                .build());
        rooms.add(Room.builder()
                .name("Room2")
                .width(20)
                .length(12)
                .build());

        DistrictDTO district = DistrictDTO.builder()
                .name("Avellaneda")
                .price(100)
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
}
