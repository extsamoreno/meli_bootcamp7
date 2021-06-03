package com.example.APIHouse.repository;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    private String name;
    private double width,length;

    public double getAreaRoom(){
        return width*length;
    }

}
