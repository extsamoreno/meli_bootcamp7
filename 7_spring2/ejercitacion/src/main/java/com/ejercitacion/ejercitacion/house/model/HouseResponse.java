package com.ejercitacion.ejercitacion.house.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class HouseResponse {

    private double price;
    @JsonProperty("square_meters")
    private double squareMeters;
    @JsonProperty("biggest_room")
    private Room biggestRoom;
    @JsonProperty("rooms_square_meters")
    private Map<String, Double> roomsSquareMeters;

    public HouseResponse(double price, double squareMeters, Room biggestRoom, Map<String, Double> roomsSquareMeters) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.biggestRoom = biggestRoom;
        this.roomsSquareMeters = roomsSquareMeters;
    }

    public HouseResponse() {
        this.roomsSquareMeters = new HashMap<>();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Room getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(Room biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public Map<String, Double> getRoomsSquareMeters() {
        return roomsSquareMeters;
    }

    public void setRoomsSquareMeters(Map<String, Double> roomsSquareMeters) {
        this.roomsSquareMeters = roomsSquareMeters;
    }
}
