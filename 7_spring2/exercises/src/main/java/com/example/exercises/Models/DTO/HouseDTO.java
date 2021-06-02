package com.example.exercises.Models.DTO;

import com.example.exercises.Models.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HouseDTO {
    private double totalMeters;
    private double houseValue;
    private Room largestRoom;
    private List<RoomDTO> rooms;
}
