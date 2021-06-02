package com.example.ejercicio1.domain;

import com.example.ejercicio1.dto.RoomDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms;

    public double calculateTotalSquareMeters() {
        return rooms.stream().mapToDouble(f -> f.calculateSquareMeters()).sum();
    }

    public double getHouseValue(double price) {
        return calculateTotalSquareMeters() * price;
    }

    public Room findLargestRoom() {
        final Optional<Room> max = rooms.stream().max((elem1, elem2) -> (int) (elem1.calculateSquareMeters() - elem2.calculateSquareMeters()));
        return max.get();
    }


}