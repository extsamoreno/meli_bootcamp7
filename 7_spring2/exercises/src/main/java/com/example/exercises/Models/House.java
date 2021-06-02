package com.example.exercises.Models;

import com.example.exercises.Models.DTO.RoomDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms;

    public double calculateTotalSquareMeters() {
        int total = 0;
        for (Room room : rooms)
            total += room.calculateSquareMeters();
        return total;
    }

    public double getHouseValue(double price) {
        return calculateTotalSquareMeters() * price;
    }

    public Room findLargestRoom() {
        final Optional<Room> max = rooms.stream().max((elem1, elem2) -> (int) (elem1.calculateSquareMeters() - elem2.calculateSquareMeters()));
        return max.get();
    }

    public List<RoomDTO> getRoomDTO() {
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room r : rooms) {
            roomsDTO.add(createRoomDTO(r));
        }
        return roomsDTO;
    }

    private RoomDTO createRoomDTO(Room room) {
        return new RoomDTO(room.getName(),room.calculateSquareMeters());
    }
}

