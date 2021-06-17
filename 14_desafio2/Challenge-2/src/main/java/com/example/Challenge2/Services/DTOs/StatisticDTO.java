package com.example.Challenge2.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class StatisticDTO {

    private double propertyM2;
    private double value;
    private RoomDTO biggestRoom;
    private List<RoomDTO> rooms;

}
