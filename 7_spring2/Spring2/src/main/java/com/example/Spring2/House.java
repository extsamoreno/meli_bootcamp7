package com.example.Spring2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private int id;
    private String name;
    private String address;
    private ArrayList<Room> listRoom;

/*    public void createHouseDefault(){

        ArrayList<Room> roomHouse1 = new ArrayList<>();
        roomHouse1.add(new Room("Room1", 5, 10));
        roomHouse1.add(new Room("Room2", 6, 11));
        House h1 = new House(0, "casa1", "direccion 1", roomHouse1);
    }*/
}
