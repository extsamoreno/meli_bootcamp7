package com.example.DesafioTasaciones.services;

import com.example.DesafioTasaciones.dtos.PropertyDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.models.Room;

import java.util.List;

public interface IPropertyService {

    ResponseDTO totalSquareMeters(Integer propertyId);
    ResponseDTO propertyValue(Integer propertyId);
    ResponseDTO largestEnvironment(Integer propertyId);
    ResponseDTO roomsSquareMeters(Integer propertyId);
    void createProperty(PropertyDTO house);
    List<PropertyDTO> getAllProperties();
    RoomDTO findBiggestEnvironment(List<Room> rooms);
}
