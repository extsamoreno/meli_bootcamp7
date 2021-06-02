package com.example.spring2.classes;

import com.example.spring2.dto.HouseDTO;
import lombok.*;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private String name;
    private String address;
    private HashMap<String, Room> rooms;

    public House(String name, String address) {
        this.name = name;
        this.address = address;
        this.rooms = new HashMap<>();
    }

    public House(HouseDTO dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.rooms = new HashMap<>();
    }

    public void addRoom(Room value) {
        this.rooms.put(value.getName(), value);
    }

    public void removeRoom(Room value) {
        this.rooms.remove(value.getName());
    }
}
