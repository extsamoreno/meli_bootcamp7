package com.example.demo.ex1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class HouseResponseDto {
    private double houseSize;
    private double price;
    private RoomDto biggerRoom;
    private HashMap<String, Double> roomSize;


    public HouseResponseDto() {
        this.roomSize = new HashMap<>();
    }
}
