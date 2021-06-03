package com.example.demo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HouseResponseDTO {

    private double totalArea;
    private double price;
    private RoomDTO mainRoom;
    private Map<String,Double> roomsAreas;

}
