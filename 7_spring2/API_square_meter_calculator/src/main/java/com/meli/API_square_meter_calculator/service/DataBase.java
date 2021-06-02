package com.meli.API_square_meter_calculator.service;

import com.meli.API_square_meter_calculator.dto.BedrommDTO;
import com.meli.API_square_meter_calculator.dto.HouseDTO;
import com.meli.API_square_meter_calculator.entities.Bedroom;
import com.meli.API_square_meter_calculator.entities.House;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<House> houses = new ArrayList<>();

    public static void addHouse(House house) {
        DataBase.houses.add(house);
    }

    public static String getTotalSquareMetersOfHouseAt(int index) {
        ArrayList<Bedroom> bedrooms = DataBase.houses.get(index).getBedrooms();
        double sizeHouse = 0;
        for (Bedroom iBedrom: bedrooms) {
            sizeHouse = sizeHouse + (iBedrom.getSquareMeter());
        }
        return "The total square meters of the house " + DataBase.houses.get(index).getName()+ " are: " +
                sizeHouse + " square metes";
    }

    public static Bedroom returnMaxBedroom(int id) {
        ArrayList<Bedroom> bedrooms = DataBase.houses.get(id).getBedrooms();
        Bedroom bedroom = null;
        int sizeBedrom = 0;
        for (Bedroom iBedrom: bedrooms) {
            if ((iBedrom.getWidthMeters() * iBedrom.getLongMeters()) > sizeBedrom) {
                bedroom = iBedrom;
            }
        }
        return bedroom;
    }

    public static String getHomeValue(int id) {
        ArrayList<Bedroom> bedrooms = DataBase.houses.get(id).getBedrooms();
        double sizeHouse = 0;
        for (Bedroom iBedrom: bedrooms) {
            sizeHouse = sizeHouse + (iBedrom.getSquareMeter());
        }
        return "The value of the house in dollars " + DataBase.houses.get(id).getName() + " is USD$" +
                sizeHouse * House.VALUEFORMETER;
    }

    public static Bedroom getMaxBedroom() {
        Bedroom bedroomMax = null;
        double sizeMax = 0;
        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < houses.get(i).getBedrooms().size(); j++) {
                double size = houses.get(i).getBedrooms().get(j).getSquareMeter();
                if( size > sizeMax) {
                    bedroomMax = houses.get(i).getBedrooms().get(j);
                    sizeMax = size;
                }
            }
        }
        return bedroomMax;
    }

    public static HouseDTO getBetroomsFromHouse(int id) {
        House house = DataBase.houses.get(id);
        HouseDTO houseDTO = new HouseDTO(house.getName(), new ArrayList<BedrommDTO>());
        double sizeMax = 0;
        for (Bedroom bedroom: house.getBedrooms()) {
            houseDTO.getBedrooms().add(new BedrommDTO(bedroom.getName(), bedroom.getSquareMeter()));
        }
        return houseDTO;
    }
}
