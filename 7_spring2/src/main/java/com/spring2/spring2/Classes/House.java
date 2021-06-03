package com.spring2.spring2.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms = new ArrayList<>();

    public double getTotalSquareMeters(){
        double meters = 0;
        for (Room h : this.rooms){
            meters += h.getLarge() * h.getWide();
        }
        return meters;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public House(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
