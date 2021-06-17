package com.example.desafio2.services;


import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.exceptions.PropertyIdNotValidException;

import java.util.List;

public interface IPropertyService {
    int add(PropertyDTO prop) throws DistrictIdNotValidException;
    double getArea(int propertyId) throws PropertyIdNotValidException;
    RoomDTO getBiggestRoom(int propId) throws PropertyIdNotValidException;
    List<RoomAreaDTO> getRoomsAreas(int propertyId) throws PropertyIdNotValidException;
    double getPrice (int propertyId) throws PropertyIdNotValidException;
}
