package com.example.tucasita.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room implements Comparable<Room> {
    private String name;
    private double width;
    private double length;

    public double squareMeters() {
        return width * length;
    }

    @Override
    public int compareTo(Room room) {
        return (int) (this.squareMeters()- room.squareMeters());
    }
}
