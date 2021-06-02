package com.meli.squaremeters.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms;

    public double calculateTotalSquareMeters() {
        int total = 0;
        for (Room room : rooms)
            total += room.calculateSquareMeters();
        return rooms.stream().mapToDouble(x -> x.calculateSquareMeters()).sum();
    }

    public double getHouseValue(double price) {
        return calculateTotalSquareMeters() * price;
    }

    public Room findLargestRoom() {
        return rooms.stream()
                .max((elem1, elem2) ->
                        (int) (elem1.calculateSquareMeters() - elem2.calculateSquareMeters()))
                .get();
    }

    public List<RoomDTO> getRoomDTO() {
        return rooms.stream().map(x -> createRoomDTO(x)).collect(Collectors.toList());
    }

    private RoomDTO createRoomDTO(Room room) {
        return new RoomDTO(room.getName(),room.calculateSquareMeters());
    }
}
