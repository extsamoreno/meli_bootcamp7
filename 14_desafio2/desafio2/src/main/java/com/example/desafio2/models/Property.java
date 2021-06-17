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
public class Property {
    private String name;
    private int districtId;
    private List<Room> roomList;

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", district=" + districtId +
                ", roomList=" + roomList.size() +
                '}';
    }

    public double getArea(){
        double sqMeters = 0;
        for (Room room : this.getRoomList()) {
            sqMeters += room.getLength() * room.getWidth();
        }
        return sqMeters;
    }
}
