package com.example.desafio2.service;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyAlreadyExistsException;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPropertyService {
    Double getTotalMetres(String name) throws PropertyExceptionNotFound;
    Double getValue(String name) throws PropertyExceptionNotFound;
    RoomDTO getBiggestRoom(String name) throws PropertyExceptionNotFound;
    List<PropertyTotalMetresRoomDTO> getTotalEachRoom(String name) throws PropertyExceptionNotFound;
    void createProperty(PropertyDTO property) throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException;
}
