package com.meli.tucasita.util;

import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;

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

}
