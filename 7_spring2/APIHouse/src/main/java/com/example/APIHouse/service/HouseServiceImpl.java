package com.example.APIHouse.service;

import com.example.APIHouse.repository.House;
import com.example.APIHouse.repository.Room;
import com.example.APIHouse.service.dto.HouseResponseDTO;
import com.example.APIHouse.service.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl  implements IHouseService{



    public double totalArea(House house){
        double totalArea=0;
        for (Room room: house.getRooms()) {
            totalArea+=room.getAreaRoom();
        }
        return totalArea;
    }
    public double getHousePrice(House house){
        double housePrice=house.getTotalHouseArea()*800;
        return housePrice;
    }
    public Room getBiggerRoom(House house){
        Room bigeerRoom=null;
        double aux =0;
        for (Room room:house.getRooms()) {
            if(room.getAreaRoom()>aux){
                aux= room.getAreaRoom();
                bigeerRoom=room;
            }
        }
        return bigeerRoom;
    }
    public List<RoomDTO> getListRoomsArea(House house){
        List<RoomDTO> list = new ArrayList<>();
        for (Room room: house.getRooms()) {
            list.add(new RoomDTO(room.getName(), room.getAreaRoom()));
        }
        return list;
    }
    @Override
    public HouseResponseDTO getHouseInfo(House house) {
        return new HouseResponseDTO(house.getName(),totalArea(house),getHousePrice(house),getBiggerRoom(house),getListRoomsArea(house));
    }


}
