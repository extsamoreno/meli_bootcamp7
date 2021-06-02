package com.ejercitacion.ejercitacion.house.model;

import java.util.List;

public class House {

    private String name;
    private String address;
    private List<Room> rooms;

    public House(String name, String address, List<Room> rooms) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public House() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
