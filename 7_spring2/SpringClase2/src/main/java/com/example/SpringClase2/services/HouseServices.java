package com.example.springclase2.services;

import com.example.springclase2.dto.*;
import com.example.springclase2.utilities.HouseSqMeterCalculator;

import static com.example.springclase2.utilities.HouseSqMeterCalculator.*;

import java.util.ArrayList;

public class HouseServices {

    private static ArrayList<House> houses = new ArrayList<>();


    public static House saveHouse(House house)
    {
        houses.add(house);
        return house;
    }

    public static HouseDTO getHouseDTO(String houseName)
    {
        int ind = 0;
        for (House h : houses) {
            if (h.getHouseName().equals(houseName))
            {
                ind = houses.indexOf(h);
            }
        }
        return new HouseDTO(houses.get(ind));
    }

    public static Room findBiggestRoom (House house)
    {
        Double maxSuface = 0d;
        int ind = 0;
        for (Room room :
                house.getRooms()){
            Double roomSurface = room.getArea();
            if (roomSurface > maxSuface)
            {
                maxSuface = roomSurface;
                ind = house.getRooms().indexOf(room);
            }
        }

        return house.getRooms().get(ind);
    }

    public static House findHouseWithBiggestRoom (ArrayList<House> houses)
    {
        Double maxSurface = 0d;
        int houseInd = 0;
        for (House house : houses){
            Double biggestRoomArea = findBiggestRoom(house).getArea();
           if (biggestRoomArea > maxSurface)
           {
               maxSurface = biggestRoomArea;
               houseInd = houses.indexOf(house);
           }
        }

        return houses.get(houseInd);
    }

    private Double calculatePrice(House house)
    {
        return HouseSqMeterCalculator.calculateSqMeters(house) * house.getPricePerSqMeter();
    }

    // probar almacenar listas de rooms y de houses en hashtables con key == surfaces

}
