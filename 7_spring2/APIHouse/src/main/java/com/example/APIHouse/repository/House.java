package com.example.APIHouse.repository;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String name, address;
    private List<Room> rooms;

    public double getTotalHouseArea(){
        double totalHouseArea=0;
        for (Room room: rooms) {
            totalHouseArea+=room.getAreaRoom();
        }
        return totalHouseArea;
    }
}
