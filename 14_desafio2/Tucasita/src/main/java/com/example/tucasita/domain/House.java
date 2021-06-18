package com.example.tucasita.domain;

import com.example.tucasita.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class House {
    private String name;
    private District district;
    private List<Room> rooms;

    /**
     * calculates and returns the total square meters of the house based in the square meters of the rooms in the house
     *
     * @return
     */
    public double getTotalMeters() {
        return rooms.stream().mapToDouble(Room::squareMeters).sum();
    }

    /**
     * calculates and returns the total value un U$S based in the District Price and the house total meters
     *
     * @return
     */
    public double getTotalValue() {
        return this.district.getPrice() * getTotalMeters();
    }

    /**
     * find and return the largest room (by square meters) if exists
     *
     * @return
     */
    public Room getLargestRoom() {
        return rooms.stream().max(Comparator.comparing(Room::squareMeters)).orElseThrow(() -> new NotFoundException("Largest Room"));
    }
}
