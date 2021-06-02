package com.example.SpringClase2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class HomeDTO {

    private float totalArea;
    private double price;
    private RoomDTO mainRoom;
    private ArrayList<RoomDTOArea> metersPerRoom;

}
