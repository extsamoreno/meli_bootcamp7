package com.example.desafio2.service;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyAlreadyExistsException;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import com.example.desafio2.repository.IPropertyRepository;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import com.example.desafio2.service.Mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{
    @Autowired
    IPropertyRepository iPropertyRepository;
    @Override
    public Double getTotalMetres(String name) throws PropertyExceptionNotFound {
        Property property = iPropertyRepository.findPropertyByName(name);
        double total = 0;
        for(Room room : property.getRooms()){
            total += room.getLength() * room.getWidth();
        }
        return total;
    }

    @Override
    public Double getValue(String name) throws PropertyExceptionNotFound {
        Property property = iPropertyRepository.findPropertyByName(name);
        double total = 0;
        for(Room room : property.getRooms()){
            total += room.getLength() * room.getWidth() * property.getNeighborhood().getPrice();
        }
        return total;
    }
    @Override
    public RoomDTO getBiggestRoom(String name) throws PropertyExceptionNotFound {
        Property property = iPropertyRepository.findPropertyByName(name);
        double total = 0;
        Room biggest = property.getRooms().get(0);
        for(int i=1; i<property.getRooms().size();i++) {
            Room room = property.getRooms().get(i);
            double roomTotal = room.getLength() * room.getWidth() * property.getNeighborhood().getPrice();
            if(roomTotal>total) {
                total = roomTotal;
                biggest = room;
            }
        }
        return PropertyMapper.roomtoRoomDTO(biggest);
    }
    @Override
    public List<PropertyTotalMetresRoomDTO> getTotalEachRoom(String name) throws PropertyExceptionNotFound {
        Property property = iPropertyRepository.findPropertyByName(name);
        List<PropertyTotalMetresRoomDTO> propertiesMetres = new LinkedList<>();
        for(Room room : property.getRooms()){
            PropertyTotalMetresRoomDTO propertyMetresTotal = new PropertyTotalMetresRoomDTO(room.getName(),room.getLength() * room.getWidth());
            propertiesMetres.add(propertyMetresTotal);
        }
        return propertiesMetres;
    }
    @Override
    public void createProperty(PropertyDTO property) throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException {
        List<Property> properties = iPropertyRepository.getProperties();
        for(Property prop : properties){
            if(prop.getName().equals(property.getName()))
                throw new PropertyAlreadyExistsException(property.getName());
        }
        Neighborhood neighborhood = iPropertyRepository.findNeighborhoodByName(property.getNeighborhood().getName());
        properties.add(PropertyMapper.propDTOtoProp(property));
    }
}

