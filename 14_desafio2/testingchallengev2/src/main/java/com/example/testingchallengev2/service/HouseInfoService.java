package com.example.testingchallengev2.service;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.Room;
import com.example.testingchallengev2.model.response.*;
import com.example.testingchallengev2.repository.district.IDistrictRepository;
import com.example.testingchallengev2.repository.house.IHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;



@Service
public class HouseInfoService implements IHouseInfoService{
    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IHouseRepository iHouseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DistrictListResponseDTO getDistrictListDTO() {
        return modelMapper.map(iDistrictRepository.getDistricts(), DistrictListResponseDTO.class);
    }

    @Override
    public HouseListResponseDTO getHouseListDTO() {
        return modelMapper.map(iHouseRepository.getHouses(), HouseListResponseDTO.class);
    }

    @Override
    public TotalHouseAreaResponseDTO getTotalHouseAreaResponseDTO(String houseName)
            throws HouseNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        double totalArea = getHouseArea(house);
        return new TotalHouseAreaResponseDTO(houseName, totalArea);
    }

    @Override
    public HouseValueResponseDTO getHouseValueResponseDTO(String houseName)
            throws HouseNotFoundException, DistrictNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        double price = getHousePrice(house);
        return new HouseValueResponseDTO(houseName, price);
    }

    @Override
    public HouseBiggestRoomResponseDTO getHouseBiggestRoomResponseDTO(String houseName)
            throws HouseNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        Room bigRoom = getBiggestRoom(house.getRooms());
        return new HouseBiggestRoomResponseDTO(houseName, bigRoom.getName(), getRoomArea(bigRoom));
    }

    @Override
    public RoomsSizeResponseDTO getRoomsSizeResponseDTO(String houseName)
            throws HouseNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        HashMap<String, Double> roomsSize = new HashMap<>();
        for (Room room :
                house.getRooms()) {
            roomsSize.put(room.getName(), getRoomArea(room));
        }
        return new RoomsSizeResponseDTO(roomsSize);
    }

    private Room getBiggestRoom(ArrayList<Room> rooms)
    {
        Room candidate = rooms.get(0);
        for (Room room :
                rooms) {
            if (getRoomArea(room) > getRoomArea(candidate))
            {
                candidate = room;
            }
        }
        return candidate;
    }

    private double getRoomArea(Room room)
    {
        return Math.round(room.getLength() * room.getWidth() * 100.0)/100.0;
    }

    private double getHouseArea(House house)
    {
        ArrayList<Room> rooms = house.getRooms();
        double houseArea = 0;
        for (Room room :
                rooms) {
            houseArea += getRoomArea(room);
        }
        return Math.round(houseArea*100.0)/100.0;
    }

    private double getHousePrice(House house)
            throws DistrictNotFoundException {
        double houseArea = getHouseArea(house);
        double price = iDistrictRepository.getPriceByName(house.getDistrictName());
        return Math.round(houseArea * price * 100.0)/100.0;
    }
}