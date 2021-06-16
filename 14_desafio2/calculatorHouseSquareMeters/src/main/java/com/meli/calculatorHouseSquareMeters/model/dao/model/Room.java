package com.meli.calculatorHouseSquareMeters.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name;
    private double width;
    private double length;
}
