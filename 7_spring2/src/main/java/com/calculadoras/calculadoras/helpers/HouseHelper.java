package com.calculadoras.calculadoras.helpers;
import com.calculadoras.calculadoras.entity.House;
import com.calculadoras.calculadoras.entity.Room;
import com.calculadoras.calculadoras.mapper.ResponseDTO;
import com.calculadoras.calculadoras.mapper.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseHelper {

    public static int getTotalSquareMeters(House house){
        int total = 0;
        for (Room room: house.getRooms()
        ) {
            total += room.getHeigth() * room.getWidth();
        }
        return total;
    }

    public static ResponseDTO getBiggerRoom(List<House> houseList){

        House biggerRoomHouse = new House();
        Room biggerRoom = new Room();

        int totalMajor = 0;

        for (House house : houseList
             ) {
            for (Room room : house.getRooms()) {
                if( (room.getWidth()*room.getHeigth())>totalMajor){
                    totalMajor = room.getWidth()*room.getHeigth();
                    biggerRoomHouse = house;
                    biggerRoom = room;
                }
            }
        }

        return new ResponseDTO(biggerRoomHouse,biggerRoom);
    }

    public static List<RoomDTO> metersPerRoom(House house){

        List<RoomDTO> roomDTO = new ArrayList<RoomDTO>(house.getRooms().size());

        for (Room room: house.getRooms()
             ) {
            int meters = room.getWidth()*room.getHeigth();
            roomDTO.add(
                    new RoomDTO(
                            room.getName(),
                            meters
                    )
            );
        }

        return roomDTO;
    }



}
