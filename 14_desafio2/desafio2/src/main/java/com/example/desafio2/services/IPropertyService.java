package com.example.desafio2.services;


import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;

import java.util.List;

public interface IPropertyService {
    void add(PropertyDTO prop);
    double getArea(int propertyId);
    RoomDTO getBiggestRoom(int propId);
    List<RoomAreaDTO> getRoomsAreas(int propertyId);
    double getPrice (int propertyId);
}
