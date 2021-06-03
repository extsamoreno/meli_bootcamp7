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

    public HouseDTO calculate(House house){
        HouseDTO response = new HouseDTO();
        double squareMetters = squareMetterByHouse(house);
        double amount = calculateAmountByHouse(house);
        response.setHouse(house);
        response.setSquareMetters(squareMetters);
        response.setAmount(amount);
        response.setBiggestRoom(calculateBiggestRoom(house));
        response.setRooms(calculateSquareMettersByRoom(house));
        return response;
    }

    public double calculateAmountByHouse(House house){
        return squareMetterByHouse(house) * 800;
    }


    public Room calculateBiggestRoom(House house){
        ArrayList<Room> arrayRooms = house.getRooms();
        double aux = squareMetterByRoom(house.getRooms().get(0));
        Room biggestRoom = new Room(house.getRooms().get(0).getName(),house.getRooms().get(0).getWidth(), house.getRooms().get(0).getHeight());
        for (int i = 1; i < arrayRooms.size(); i++){
            double squareMetter = squareMetterByRoom(arrayRooms.get(i));
            if(squareMetter > aux){
                aux = squareMetter;
                biggestRoom.setName(arrayRooms.get(i).getName());
                biggestRoom.setHeight(arrayRooms.get(i).getHeight());
                biggestRoom.setWidth(arrayRooms.get(i).getWidth());
            }
        }

        return biggestRoom;
    }

    public ArrayList<RoomDTO>  calculateSquareMettersByRoom(House house){
        ArrayList<RoomDTO> roomsDTO = new ArrayList<RoomDTO>();
        for (Room room: house.getRooms()) {
            roomsDTO.add(new RoomDTO(room, squareMetterByRoom(room)));
        }
        return roomsDTO;
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
