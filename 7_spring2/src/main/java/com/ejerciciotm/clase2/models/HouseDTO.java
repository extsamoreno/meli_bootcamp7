package com.ejerciciotm.clase2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO{
    private House house;
    private double squareMetters;
    private double amount;
    private Room biggestRoom;
    private ArrayList<RoomDTO> rooms;
}
