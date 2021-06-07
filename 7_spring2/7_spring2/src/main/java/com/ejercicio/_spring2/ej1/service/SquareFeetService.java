package com.ejercicio._spring2.ej1.service;

import com.ejercicio._spring2.ej1.dto.HouseDTO;
import com.ejercicio._spring2.ej1.dto.HouseResponseDTO;
import com.ejercicio._spring2.ej1.dto.RoomDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SquareFeetService {

    public HouseResponseDTO calculate(HouseDTO house) {
        HouseResponseDTO response = new HouseResponseDTO(house);
        calculateRoom(house, response);
        response.setPrice(calculatePrice(calculateTotalSquareFeet(house.getRooms())));
        response.setRoomsSquareFeet(getRoomsAreas(house.getRooms()));
        return response;
    }


    private double calculateTotalSquareFeet(List<RoomDTO> rooms) {
        return rooms.stream()
                .mapToDouble(f -> calculateRoomSquareFeet(f))
                .sum();
    }

    private double calculateRoomSquareFeet(RoomDTO room) {
        return room.getWidth() * room.getLength();
    }


    private void calculateRoom(HouseDTO house, HouseResponseDTO response) {
        double totalSquareFeet = 0;
        RoomDTO biggest = null;
        double maxRoom = 0;
        for (RoomDTO room : house.getRooms()) {
            double squareFeet = calculateRoomSquareFeet(room);
            totalSquareFeet += squareFeet;
            if (biggest == null || squareFeet > maxRoom) {
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        response.setSquareFeet(totalSquareFeet);
        response.setBiggestRoom(biggest.getName());
    }

    private double calculatePrice(double totalSquareFeet) {
        return totalSquareFeet * 800;
    }

    private Map<String, Double> getRoomsAreas(List<RoomDTO> roomDTOList) {

        Map<String, Double> roomsArea = new HashMap<>();

        for (RoomDTO r : roomDTOList) {
            roomsArea.put(r.getName(), calculateRoomSquareFeet(r));
        }
        return roomsArea;
    }

}
