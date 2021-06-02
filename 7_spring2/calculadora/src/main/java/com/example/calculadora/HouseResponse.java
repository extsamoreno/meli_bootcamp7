package com.example.calculadora;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter

public class HouseResponse {
    private double price;
    private double mt2;
    private Room biggestRoom;
    private HashMap<String,Double> rooms;


    public HouseResponse(House house){

        this.price = house.getPrice();
        this.mt2 = house.getMt2();
        this.biggestRoom = house.getBiggestRoom();
        this.rooms = house.getRooms();

    }
}
