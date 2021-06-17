package com.example.demo.House;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String name;
    private String address;
    private ArrayList<Room> listRoom;

    public void  createHouseDefault(){
        ArrayList<Room> roomsHouse1 = new ArrayList<>();
        roomsHouse1.add(new Room("Room1",5,10));
        roomsHouse1.add(new Room("Room2",6,11));
        roomsHouse1.add(new Room("Room3",7,12));
        House house = new House("house1","address1",roomsHouse1);
    }
}
