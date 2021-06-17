package com.meli.desafio2.unit.service;

import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.exception.PropertyAlreadyExistsException;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.exception.PropertyWithoutRoomsException;
import com.meli.desafio2.model.*;
import com.meli.desafio2.unit.repository.IPropertyRepository;
import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.unit.service.dto.RoomDTO;
import com.meli.desafio2.unit.service.dto.RoomSquareMDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Double calculateSquareMeters(Long id) {
        //Get property
        Property prop = propertyRepository.fetch(id);
        if (prop == null) throw new PropertyNotFoundException(id);

        //Calculate Square Meters
        return calculateSquareMeters(prop);
    }

    @Override
    public void create(PropertyDTO propertyDTO) {
        Double district_price = propertyRepository.fetch(propertyDTO.getDistrict().getName());
        if (district_price == null) throw new DistrictNotFoundException(propertyDTO.getDistrict().getName());

        //Map DTO to Model
        Property property = mapper.map(propertyDTO, Property.class);
        //Manage district price

        property.getDistrict().setPrice(district_price);

        //Create Property in DataBase
        propertyRepository.create(property);
    }

    @Override
    public Double calculateValue(Long id) {
        //Get property
        Property prop = propertyRepository.fetch(id);
        if (prop == null) throw new PropertyNotFoundException(id);

        return calculateSquareMeters(prop) * prop.getDistrict().getPrice();
    }

    @Override
    public RoomDTO biggestRoom(Long id) {
        //Get property
        Property prop = propertyRepository.fetch(id);
        if (prop == null) throw new PropertyNotFoundException(id);

        Room result = prop.getRooms().stream().max(Comparator.comparing(room -> room.getLength()*room.getWidth())).orElseThrow(PropertyWithoutRoomsException::new);

        //Map Model to DTO
        RoomDTO roomDTO = mapper.map(result, RoomDTO.class);
        return roomDTO;
    }

    @Override
    public List<RoomSquareMDTO> roomsWithSquareMeters(Long id) {

        //Get property
        Property prop = propertyRepository.fetch(id);
        if (prop == null) throw new PropertyNotFoundException(id);

        List<RoomSquareMDTO> roomsDTO = prop.getRooms()
                .stream()
                .map(room -> mapper.map(room, RoomSquareMDTO.class))
                .collect(Collectors.toList());

        System.out.println(roomsDTO);

        roomsDTO.stream().forEach(item -> item.setSquareMeters(item.getWidth() * item.getLength()));

        return roomsDTO;
    }

    private Double calculateSquareMeters(Property prop) {
        return prop.getRooms().stream().map(item -> item.getWidth() * item.getLength()).reduce(0d, (a, b) -> a + b);
    }
}
