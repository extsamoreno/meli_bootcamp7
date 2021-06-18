package com.example.tucasita.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Room {
    private String name;
    private double width;
    private double length;

    /**
     * returns the square meters of the room
     *
     * @return
     */
    public double squareMeters() {
        return width * length;
    }
}
