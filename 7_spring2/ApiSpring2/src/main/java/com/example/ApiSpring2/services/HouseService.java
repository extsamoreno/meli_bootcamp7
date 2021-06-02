package com.example.ApiSpring2.services;

import com.example.ApiSpring2.dto.HouseDTO;
import com.example.ApiSpring2.entities.House;
import com.example.ApiSpring2.entities.Room;
import com.example.ApiSpring2.entities.SquareMeterRoom;
import com.example.ApiSpring2.repository.HouseRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HouseService {
    public void mockDB(){
        Room[] room = {new Room("Kitchen",50,2),new Room("DinnerRoom",15,20)};
        Room[] room2 = {new Room("Bathroom",8,19),new Room("BedRoom1",10,10),new Room("BedRoom2",17,19)};

        HouseRepository.addHouse("House 1","av. abcd 123", room);
        HouseRepository.addHouse("House 2","route 19", room2);
    }

    public HouseDTO getHouse(Integer id){
        House house = HouseRepository.getHouse().get(id);
        return new HouseDTO(house.getName(),house.getDirection(),house.getRooms());
    }

    public Integer getSquareMeters(Room[] rooms){
        Integer total = 0;
        for(Room room : rooms){
            total += room.getWith() * room.getLength();
        }
        return total;
    }

    public Integer getPrice(Room[] rooms){
        Integer total = 0;
        for(Room room : rooms){
            total += (room.getWith() * room.getLength())*800;
        }
        return total;
    }

    public Room getMaxHabitacion(Room[] rooms){
        Room bigestRoom = rooms[0];
        for(Room room : rooms){
            if (bigestRoom.getSquareMeters() < room.getSquareMeters()){
                bigestRoom = room;
            }
        }
        return bigestRoom;
    }

    public ArrayList<SquareMeterRoom> getSquareMeterByRoom(Room[] rooms){
        ArrayList<SquareMeterRoom> squareMeterRoom = new ArrayList<>();
        for(Room room : rooms){
            squareMeterRoom.add(new SquareMeterRoom(room.getName(),room.getSquareMeters()));
        }
        return squareMeterRoom;
    }
}
