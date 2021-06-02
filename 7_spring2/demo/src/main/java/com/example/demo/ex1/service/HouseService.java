package com.example.demo.ex1.service;

import com.example.demo.ex1.dto.HouseDto;
import com.example.demo.ex1.dto.HouseResponseDto;
import com.example.demo.ex1.dto.RoomDto;

public class HouseService {

    public HouseResponseDto getInfoHouse(HouseDto hd) {
        HouseResponseDto res = new HouseResponseDto();
        double maxSize = 0;
        double size = 0;
        RoomDto bigRoom = hd.getRooms().get(0);


        for (RoomDto r : hd.getRooms()) {
            double roomSize = getSize(r);
            res.getRoomSize().put(r.getName(), roomSize);
            size = +roomSize;
            if (roomSize > maxSize) {
                maxSize = getSize(r);
                bigRoom = r;
            }
        }
        res.setHouseSize(size);
        res.setPrice(size * 800);
        res.setBiggerRoom(bigRoom);
        return res;
    }

    private double getSize(RoomDto room) {
        return room.getHigh() * room.getSide();
    }
}
