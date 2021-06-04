package com.example.springclase2.dto;

import lombok.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String houseName;
    private String address;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int pricePerSqMeter = 800;
    private Double price = getPricePerSqMeter() * getArea();
    private Double area;
}
