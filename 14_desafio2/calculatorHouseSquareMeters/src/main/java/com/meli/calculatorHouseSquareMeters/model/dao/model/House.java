package com.meli.calculatorHouseSquareMeters.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String houseName;
    private District district;
    private int numberRooms = 0;
    private double totalSquareMeters;
    private double totalPrice;
    private ArrayList<Room> rooms = new ArrayList<>();
}
