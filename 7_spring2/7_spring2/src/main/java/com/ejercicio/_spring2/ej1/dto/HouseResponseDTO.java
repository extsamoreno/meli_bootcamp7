package com.ejercicio._spring2.ej1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseResponseDTO  {
    private double squareFeet;
    private double price;
    private String biggestRoom;
    private Map<String,Double> roomsSquareFeet;

    public HouseResponseDTO(HouseDTO house) {
    }
}