package com.tucasita.tasaciones.model;

import java.util.List;

public class Property {

    private int id;
    private String name;
    private Neighborhood neighborhood;
    private List<Room> rooms;

    public Property(int id, String name, Neighborhood neighborhood, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.neighborhood = neighborhood;
        this.rooms = rooms;
    }

    public Property() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
