package com.example.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HouseRequestDTO {

    private String name;
    private String address;
    private List<RoomDTO> rooms;
}
