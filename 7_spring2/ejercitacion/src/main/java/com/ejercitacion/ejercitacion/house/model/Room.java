package com.ejercitacion.ejercitacion.house.model;

public class Room {

    private String name;
    private double length;
    private double width;


    public Room(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
