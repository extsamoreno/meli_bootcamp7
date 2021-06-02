package com.example.ejercicio1.domain;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String name;
    private double width;
    private double length;

    public double calculateSquareMeters() {
        return this.width * this.length;
    }
}
