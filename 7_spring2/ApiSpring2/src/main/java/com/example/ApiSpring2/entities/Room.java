package com.example.ApiSpring2.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private String name;
    private int with, length;

    public double getSquareMeters(){
        return with*length;
    }
}
