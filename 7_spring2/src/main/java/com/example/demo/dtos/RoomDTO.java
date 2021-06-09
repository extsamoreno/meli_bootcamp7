package com.example.demo.dtos;

import lombok.Data;

@Data
public class RoomDTO {

    private String name;
    private double width;
    private double length;

/*    public double calculateArea() {
        return this.width * this.length;
    }*/
}
