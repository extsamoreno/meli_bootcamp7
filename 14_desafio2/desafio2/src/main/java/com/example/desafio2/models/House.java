package com.example.desafio2.models;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.dtos.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String name;
    private District district;
    private List<Room> roomList;

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", district=" + district.toString() +
                ", roomList=" + roomList.size() +
                '}';
    }
}
