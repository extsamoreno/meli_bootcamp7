package com.example.desafio2.services;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.services.mappers.RoomMapper;
import com.example.desafio2.services.utils.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {
    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public void add(PropertyDTO house) {
        iPropertyRepository.add(PropertyMapper.toModel(house));
    }

    @Override
    public double getArea(int propertyId) {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            return 0;
            //TODO: throw exception

        return PropertyUtil.calculateArea(property);
    }

    @Override
    public RoomDTO getBiggestRoom(int propertyId) {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            //TODO: throw exception
            return null;

        double maxArea = 0;
        Room selectedRoom = null;

        for (Room room : property.getRoomList()) {
            double area = room.getWidth()*room.getLength();
            if(area > maxArea){
                maxArea = area;
                selectedRoom = room;
            }
        }

        return RoomMapper.toDTO(selectedRoom);
    }

    @Override
    public List<RoomAreaDTO> getRoomsAreas(int propertyId) {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            //TODO: throw exception
            return null;

        List<RoomAreaDTO> roomAreaList = new ArrayList<>();
        RoomAreaDTO roomArea;
        for (Room room : property.getRoomList()) {
            roomArea = new RoomAreaDTO();

            roomArea.setName(room.getName());
            roomArea.setSquareMeters(room.getLength()*room.getWidth());

            roomAreaList.add(roomArea);
        }

        return roomAreaList;
    }

    @Override
    public double getPrice(int propertyId) {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            //TODO: throw exception
            return 0;

        double area = PropertyUtil.calculateArea(property);
        double pricePerSqMeter = PropertyUtil.calculatePricePerSqMeter(property.getDistrict());

        return area * pricePerSqMeter;
    }
}
