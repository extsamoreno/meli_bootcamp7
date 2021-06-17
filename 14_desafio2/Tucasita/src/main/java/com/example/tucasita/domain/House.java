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

    public double getTotalMeters() {
        return rooms.stream().mapToDouble(Room::squareMeters).sum();
    }

    public double getTotalValue() {
        return this.district.getPrice() * getTotalMeters();
    }

    public Room getLargestRoom() {
        return rooms.stream().max(Comparator.comparing(Room::squareMeters)).orElseThrow(() -> new NotFoundException("Largest Room"));
    }
}
