package com.example.Spring2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HouseService {

    // Calculate houseM2
    public ResponseHouseDTO calculateM2House(House h) {

        double totalM2 = 0;

        for (Room r : h.getListRoom()) {
            totalM2 += calculateM2Room(r);
        }

        ResponseHouseDTO rh = new ResponseHouseDTO();
        rh.setTotalM2(totalM2);
        rh.setName(h.getName());
        return rh;
    }

    // Calculate roomM2
    public Double calculateM2Room(Room r) {
        return r.getWidth() * r.getHeight();
    }

    // Calculate house value
    public ResponseHouseDTO calculateValue(House h) {

        ResponseHouseDTO rh = calculateM2House(h);
        rh.setHomeValue(rh.getTotalM2() * 800);

        return rh;
    }

    // Return the biggest room
    public ResponseHouseDTO getBiggestRoom(House h) {

        ResponseHouseDTO rh = new ResponseHouseDTO();
        double sizeBiggestRoom = 0, sizeRoom = 0;

        for (Room r : h.getListRoom()) {
            sizeRoom = calculateM2Room(r);

            if (sizeRoom > sizeBiggestRoom) {
                rh.setBiggestRoom(r);
                sizeBiggestRoom = sizeRoom;
            }
        }
        return rh;
    }

    public ResponseHouseDTO getRoomsM2(House h){

        ArrayList<ResponseRoomDTO> listRooms = new ArrayList();

        for (Room r : h.getListRoom()) {
           listRooms.add(new ResponseRoomDTO(r.getName(), calculateM2Room(r)));
        }

        ResponseHouseDTO rh = new ResponseHouseDTO();
        rh.setListRoom(listRooms);

        return rh;
    }
}
