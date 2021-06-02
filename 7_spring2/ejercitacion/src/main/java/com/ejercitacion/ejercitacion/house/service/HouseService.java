package com.ejercitacion.ejercitacion.house.service;

import com.ejercitacion.ejercitacion.house.model.House;
import com.ejercitacion.ejercitacion.house.model.HouseResponse;
import com.ejercitacion.ejercitacion.house.model.Room;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HouseService {

    public HouseResponse calculateHouseData(House house) {

        HouseResponse response = new HouseResponse();
        double totalSquareMeters = 0;
        double biggestRoomSqMt = 0;
        Room biggestRoom = null;
        Map<String, Double> roomsSqMt = new HashMap<>();

        for (Room room : house.getRooms()) {
            if (calculateSqMt(room) > biggestRoomSqMt) {
                biggestRoom = room;
                biggestRoomSqMt = calculateSqMt(room);
            }
            totalSquareMeters += calculateSqMt(room);
            roomsSqMt.put(room.getName(), calculateSqMt(room));
        }

        response.setPrice(800 * totalSquareMeters);
        response.setSquareMeters(totalSquareMeters);
        response.setRoomsSquareMeters(roomsSqMt);
        response.setBiggestRoom(biggestRoom);
        return response;
    }

    private Double calculateSqMt(Room room) {
        return room.getLength() * room.getWidth();
    }

}
