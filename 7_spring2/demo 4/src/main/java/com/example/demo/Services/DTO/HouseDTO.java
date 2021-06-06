package com.example.demo.Services.DTO;

import com.example.demo.Services.Room;
import lombok.AllArgsConstructor;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

    private String name;
    private double meter2;
    private double price;
    private Room biggerRoom;
    private List<RoomDTO> rooms;
}
