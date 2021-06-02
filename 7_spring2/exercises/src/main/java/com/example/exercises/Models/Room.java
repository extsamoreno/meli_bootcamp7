package com.example.exercises.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Room {
    private String name;
    private double width;
    private double length;

    public double calculateSquareMeters() {
        return this.width * this.length;
    }
}
