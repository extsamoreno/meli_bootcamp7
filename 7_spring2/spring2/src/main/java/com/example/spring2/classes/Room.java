package com.example.spring2.classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private String name;
    private double wide;
    private double large;

    public double getSquareMeters() {
        return this.wide * this.large;
    }
}
