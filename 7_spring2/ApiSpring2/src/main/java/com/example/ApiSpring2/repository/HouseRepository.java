package com.example.ApiSpring2.repository;

import com.example.ApiSpring2.entities.House;
import com.example.ApiSpring2.entities.Room;

import java.util.ArrayList;

public class HouseRepository {
    private static ArrayList<House> houses = new ArrayList<House>();
    private static Integer count = 0;

    public static ArrayList<House> getHouse(){return houses;}

    public static void addHouse(String name, String direction, Room[] rooms){
        houses.add( new House(count, name,direction, rooms));
        count++;
    }
}
