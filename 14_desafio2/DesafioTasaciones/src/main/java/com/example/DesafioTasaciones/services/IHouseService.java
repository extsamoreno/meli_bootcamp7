package com.example.DesafioTasaciones.services;

import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.models.Room;

import java.util.List;

public interface IHouseService {

    ResponseDTO totalSquareMeters(Integer propertyId);
    ResponseDTO propertyValue(Integer propertyId);
    ResponseDTO largestEnvironment(Integer propertyId);
    ResponseDTO roomsSquareMeters(Integer propertyId);
    void createProperty(HouseDTO property);
    List<HouseDTO> getAllProperties();
}
