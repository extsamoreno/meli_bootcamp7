package com.ejerciciotm.clase2.services;

import com.ejerciciotm.clase2.models.House;
import com.ejerciciotm.clase2.models.HouseDTO;
import com.ejerciciotm.clase2.models.Room;
import com.ejerciciotm.clase2.models.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class HouseService {

    public HouseDTO calculateSquareMettersByHouse(House house){
        HouseDTO response = new HouseDTO();
        double squareMetters = squareMetterByHouse(house);
        response.setHouse(house);
        response.setSquareMetters(squareMetters);
        return response;
    }

    public HouseDTO calculateAmountByHouse(House house){
        HouseDTO response = new HouseDTO();
        double amount = squareMetterByHouse(house) * 800;
        response.setHouse(house);
        response.setAmount(amount);
        return response;
    }


    public HouseDTO calculateBiggestRoom(House house){
        HouseDTO response = new HouseDTO();
        ArrayList<Room> arrayRooms = house.getRooms();
        double aux = squareMetterByRoom(house.getRooms().get(0));
        Room biggestRoom = new Room(house.getRooms().get(0).getWidth(), house.getRooms().get(0).getHeight());
        for (int i = 1; i < arrayRooms.size(); i++){
            double squareMetter = squareMetterByRoom(arrayRooms.get(i));
            if(squareMetter > aux){
                aux = squareMetter;
                biggestRoom.setHeight(arrayRooms.get(i).getHeight());
                biggestRoom.setWidth(arrayRooms.get(i).getWidth());
            }
        }
        response.setBiggestRoom(biggestRoom);
        response.setHouse(house);
        return response;
    }

    public HouseDTO calculateSquareMettersByRoom(House house){
        HouseDTO response = new HouseDTO();
        ArrayList<RoomDTO> roomsDTO = new ArrayList<RoomDTO>();
        for (Room room: house.getRooms()) {
            roomsDTO.add(new RoomDTO(room, squareMetterByRoom(room)));
        }
        response.setRooms(roomsDTO);
        return response;
    }

    private double squareMetterByHouse(House house){
        double value = 0;
        for (Room room: house.getRooms()) {
            value += squareMetterByRoom(room);
        }

        return value;
    }

    private double squareMetterByRoom(Room room){
        return room.getWidth() * room.getHeight();
    }

}
