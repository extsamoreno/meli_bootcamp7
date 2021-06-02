package com.example.SpringClase2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class House {

    private String name;
    private String address;
    private ArrayList<RoomDTO> roomList;

    public float totalArea() {
        return (float) roomList.stream().mapToDouble(room -> room.area()).sum();
    }

    public double totalPrice() {
        return 400 * totalArea();
    }

    public RoomDTO mainRoom() {
        RoomDTO mainRoom = new RoomDTO();
        float maxArea = 0;
        for (RoomDTO room : roomList) {
            if (maxArea < room.area()) {
                maxArea = room.area();
                mainRoom = room;
            }
        }
        return mainRoom;
    }

    public ArrayList<RoomDTOArea> meterPerRoom(){
        ArrayList<RoomDTOArea> rooms = new ArrayList<>();
        roomList.forEach(room ->
                            rooms.add(new RoomDTOArea(room.getName(), room.area())));
        return rooms;
    }
}
