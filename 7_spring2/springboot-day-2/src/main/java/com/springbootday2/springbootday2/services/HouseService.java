package com.springbootday2.springbootday2.services;

import com.springbootday2.springbootday2.dtos.HouseDTO;
import com.springbootday2.springbootday2.dtos.RoomDTO;
import com.springbootday2.springbootday2.entities.House;
import com.springbootday2.springbootday2.entities.Room;

import java.util.HashMap;
import java.util.Objects;

public class HouseService {
    private HashMap<Integer, House> houseHashMap;

    public HouseService() {
        this.houseHashMap = new HashMap<>();
    }

    public String addHouse(HouseDTO houseDTO) {

        House house = new House(houseHashMap.size()+1,
                                    houseDTO.getName(),
                                    houseDTO.getAdress(),
                                    houseDTO.getRoomsLst());

        this.houseHashMap.put(house.getId(), house);
        return "Casa creada - id: " + house.getId();
    }

    public HouseDTO getMeterPow2ByHouse(int idHouse) {
        House house = houseHashMap.get(idHouse);

        if (Objects.isNull(house)) return  null;

        float meters = calculateMeterByHouse(house.getRoomsLst());

        HouseDTO houseDTO = new HouseDTO(house.getId(), house.getName(), house.getAdress(), house.getRoomsLst(), meters);

        return houseDTO;
    }

    public float getPrice(int idHouse) {
        House house = houseHashMap.get(idHouse);

        if (Objects.isNull(house)) return  0f;

        float meters = calculateMeterByHouse(house.getRoomsLst());

        return meters * 800;
    }

    public RoomDTO getBigRoom(int idHouse) {
        RoomDTO[] roomDTOS = getMeterPow2ByRoom(idHouse);

        if (Objects.isNull(roomDTOS)) return null;

        RoomDTO biggestRoom = new RoomDTO("Dummy", 0f);
        for (RoomDTO roomDTO :
                roomDTOS) {
            biggestRoom = roomDTO.getMeters() > biggestRoom.getMeters() ? roomDTO : biggestRoom;
        }
        return biggestRoom;
    }

    public RoomDTO[] getMeterPow2ByRoom(int idHouse) {
        RoomDTO[] roomDTO;

        Room[] rooms = houseHashMap.get(idHouse).getRoomsLst();

        if (Objects.isNull(rooms)) return  null;

        roomDTO = new RoomDTO[rooms.length];

        for (int i = 0; i < roomDTO.length; i++) {
            roomDTO[i] = new RoomDTO(rooms[i].getName(), calculateMeterByRoom(rooms[i]));
        }

        return roomDTO;
    }

    private float calculateMeterByRoom(Room room) {
        return room.getHigh() * room.getWidth();
    }
    private float calculateMeterByHouse(Room[] rooms) {
        float meters = 0f;

        for (Room room :
                rooms) {
            meters += calculateMeterByRoom(room);
        }
        return meters;
    }
}
