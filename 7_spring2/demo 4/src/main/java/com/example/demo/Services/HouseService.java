package com.example.demo.Services;


import com.example.demo.Services.DTO.HouseDTO;
import com.example.demo.Services.DTO.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    private double price = 800;

    public HouseDTO getHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName(house.getName());
        houseDTO.setMeter2(getTotalMetters(house.getRooms()));
        houseDTO.setPrice(getTotalMetters(house.getRooms())*price);
        houseDTO.setBiggerRoom(getBiggerRoom(house.getRooms()));
        houseDTO.setRooms(setMettersRooms(house.getRooms()));
        return houseDTO;
    }

    public double getTotalMetters(List<Room> rooms){
        double total = 0;
        for(int i=0; i<rooms.size();i++){
            total += rooms.get(i).getLength()*rooms.get(i).getWidth();
        }
        return total;
    }

    private Room getBiggerRoom(List<Room> rooms){
        double total = rooms.get(0).getLength()*rooms.get(0).getWidth();
        Room room = rooms.get(0);
        for(int i=1; i<rooms.size();i++){
            if(rooms.get(i).getLength()*rooms.get(i).getWidth() > total){
                total += rooms.get(i).getLength()*rooms.get(i).getWidth();
                room = rooms.get(i);
            }
        }
        return room;
    }

    public List<RoomDTO> setMettersRooms(List<Room> rooms){

        List<RoomDTO> list = new ArrayList<>();
        double metter = 0;
        RoomDTO room;
        for(int i=0; i<rooms.size();i++){
            metter = rooms.get(i).getWidth() * rooms.get(i).getLength();
            room = new RoomDTO(rooms.get(i).getName(), metter);
            list.add(room);
        }
        return list;
    }
}
