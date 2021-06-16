package com.example.desafio2.services;

import com.example.desafio2.dtos.HouseDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.House;
import com.example.desafio2.models.Room;
import com.example.desafio2.repositories.IHouseRepository;
import com.example.desafio2.services.mappers.HouseMapper;
import com.example.desafio2.services.mappers.RoomMapper;
import com.example.desafio2.services.utils.HouseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService implements IHouseService{
    @Autowired
    IHouseRepository iHouseRepository;

    @Override
    public void add(HouseDTO house) {
        iHouseRepository.add(HouseMapper.toModel(house));
    }

    @Override
    public double getTotalSquareMeters(int houseId) {
        House house = iHouseRepository.getHouseById(houseId);
        if(house == null)
            return 0;
            //TODO: throw exception

        return HouseUtil.calculateArea(house);
    }

    @Override
    public RoomDTO getBiggestRoom(int houseId) {
        House house = iHouseRepository.getHouseById(houseId);
        if(house == null)
            //TODO: throw exception
            return null;

        double maxArea = 0;
        Room selectedRoom = null;

        for (Room room : house.getRoomList()) {
            double area = room.getWidth()*room.getLength();
            if(area > maxArea){
                maxArea = area;
                selectedRoom = room;
            }
        }

        return RoomMapper.toDTO(selectedRoom);
    }

    @Override
    public List<RoomAreaDTO> getRoomsAreas(int houseId) {
        House house = iHouseRepository.getHouseById(houseId);
        if(house == null)
            //TODO: throw exception
            return null;

        List<RoomAreaDTO> roomAreaList = new ArrayList<>();
        RoomAreaDTO roomArea;
        for (Room room : house.getRoomList()) {
            roomArea = new RoomAreaDTO();

            roomArea.setName(room.getName());
            roomArea.setSquareMeters(room.getLength()*room.getWidth());

            roomAreaList.add(roomArea);
        }

        return roomAreaList;
    }

    @Override
    public double getPrice(int houseId) {
        House house = iHouseRepository.getHouseById(houseId);
        if(house == null)
            //TODO: throw exception
            return 0;

        double area = HouseUtil.calculateArea(house);
        double pricePerSqMeter = HouseUtil.calculatePricePerSqMeter(house.getDistrict());

        return area * pricePerSqMeter;
    }
}
