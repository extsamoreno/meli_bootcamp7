package com.example.desafio2.services;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.exceptions.PropertyIdNotValidException;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;
import com.example.desafio2.repositories.IDistrictRepository;
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

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public int add(PropertyDTO prop) throws DistrictIdNotValidException {
        if(iDistrictRepository.getById(prop.getDistrictId()) == null)
            throw new DistrictIdNotValidException(prop.getDistrictId());

        return iPropertyRepository.add(PropertyMapper.toModel(prop));
    }

    @Override
    public double getArea(int propertyId) throws PropertyIdNotValidException {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            throw new PropertyIdNotValidException(propertyId);

        return PropertyUtil.getArea(property);
    }

    @Override
    public RoomDTO getBiggestRoom(int propertyId) throws PropertyIdNotValidException {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            throw new PropertyIdNotValidException(propertyId);

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
    public List<RoomAreaDTO> getRoomsAreas(int propertyId) throws PropertyIdNotValidException {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            throw new PropertyIdNotValidException(propertyId);

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
    public double getPrice(int propertyId) throws PropertyIdNotValidException {
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if(property == null)
            throw new PropertyIdNotValidException(propertyId);

        double area = PropertyUtil.getArea(property);
        double pricePerSqMeter = iDistrictRepository.getById(property.getDistrictId()).getPrice();

        return area * pricePerSqMeter;
    }
}
