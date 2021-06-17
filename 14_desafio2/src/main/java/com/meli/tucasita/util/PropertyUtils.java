package com.meli.tucasita.util;

import com.meli.tucasita.dto.BiggestRoomDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.models.Room;

import java.util.ArrayList;
import java.util.List;

public class PropertyUtils {

    public static List<RoomAreaDTO> calculateRoomsDTOAreas(List<RoomDTO> rooms) {

        List<RoomAreaDTO> roomAreaDTOList = new ArrayList<>();

        for (RoomDTO r : rooms) {
            RoomAreaDTO roomAreaDTO = new RoomAreaDTO();
            roomAreaDTO.setArea(calculateRoomArea(r.getWidth(), r.getLength()));
            roomAreaDTO.setName(r.getName());
            roomAreaDTOList.add(roomAreaDTO);
        }
        return roomAreaDTOList;
    }

    public static double calculatePropertyPrice(double meters, double meterPrice) {
        return meters * meterPrice;
    }

    public static double calculatePropTotalArea(List<RoomDTO> rooms) {

        double totalArea = 0;
        for (RoomDTO r : rooms) {
            totalArea += calculateRoomArea(r.getWidth(), r.getLength());
        }
        return totalArea;
    }

    private static double calculateRoomArea(double width, double length) {
        return width * length;
    }


    //TODO Estos son los métodos utilitarios que usan los métodos que estoy sacando
    // Si los saco, eliminar estos métodos
/*
    private double calculateTotalArea(List<Room> rooms) {

        double totalArea = 0;
        for (Room r : rooms) {
            totalArea += calculateRoomArea(r.getWidth(), r.getLength());
        }
        return totalArea;
    }

    private List<RoomAreaDTO> calculateRoomsAreas(List<Room> rooms) {

        List<RoomAreaDTO> roomAreaDTOList = new ArrayList<>();

        for (Room r : rooms) {
            RoomAreaDTO roomAreaDTO = new RoomAreaDTO();
            roomAreaDTO.setArea(calculateRoomArea(r.getWidth(), r.getLength()));
            roomAreaDTO.setName(r.getName());
            roomAreaDTOList.add(roomAreaDTO);
        }
        return roomAreaDTOList;
    }

    public static BiggestRoomDTO calculateBiggestRoom(BiggestRoomDTO biggestRoomDTO, List<Room> rooms) {

        String biggestRoom = "";
        double roomArea = 0;

        for (Room r : rooms) {
            double area = calculateRoomArea(r.getWidth(), r.getLength());
            if (area > roomArea) {
                roomArea = area;
                biggestRoom = r.getName();
            }
        }

        biggestRoomDTO.setBiggestRoom(biggestRoom);
        biggestRoomDTO.setRoomArea(roomArea);

        return biggestRoomDTO;
    }

    */

}
