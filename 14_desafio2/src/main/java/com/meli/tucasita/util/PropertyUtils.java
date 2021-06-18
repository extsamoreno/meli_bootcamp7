package com.meli.tucasita.util;

import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class PropertyUtils {


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

    public static double calculateRoomArea(double width, double length) {
        return width * length;
    }

}
