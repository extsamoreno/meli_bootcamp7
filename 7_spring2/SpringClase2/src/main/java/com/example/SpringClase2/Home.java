package com.example.SpringClase2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class Home {

    private String name;
    private String address;
    private ArrayList<RoomDTO> roomList;

    public float totalArea() {
        float area = 0;
        for (RoomDTO room : roomList) {
            area += room.area();
        }
        return area;
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

    public HashMap<String, Float> metersPerRoom() {
        HashMap<String, Float> mapsRooms = new HashMap<>();

        for (RoomDTO room : roomList) {
            mapsRooms.put(room.getName(), room.area());
        }
        return mapsRooms;
    }
}
