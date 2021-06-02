package com.meli.API_square_meter_calculator.entities;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class House {
    private int id;
    private String name;
    private String address;
    private ArrayList<Bedroom> bedrooms;
    private static int counter = 0;
    public final static int VALUEFORMETER = 800;

    public House(String name, String address, ArrayList<Bedroom> bedrooms) {
        this.name = name;
        this.address = address;
        this.bedrooms = bedrooms;
        this.id = House.counter++;
    }
}
