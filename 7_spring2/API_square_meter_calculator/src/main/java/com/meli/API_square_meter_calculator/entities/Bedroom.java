package com.meli.API_square_meter_calculator.entities;

import lombok.*;

@Getter
@Setter
public class Bedroom {
    private String name;
    private int widthMeters;
    private int longMeters;
    private double squareMeter;

    public Bedroom(String name, int widthMeters, int longMeters) {
        this.name = name;
        this.widthMeters = widthMeters;
        this.longMeters = longMeters;
        this.squareMeter = widthMeters * longMeters;
    }
}
