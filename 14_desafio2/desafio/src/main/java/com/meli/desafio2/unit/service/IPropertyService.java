package com.meli.desafio2.unit.service;

import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.unit.service.dto.RoomDTO;
import com.meli.desafio2.unit.service.dto.RoomSquareMDTO;

import java.util.List;

public interface IPropertyService {

    Double calculateSquareMeters(Long id);

    void create(PropertyDTO propertyDTO);

    Double calculateValue(Long id);

    RoomDTO biggestRoom(Long id);

    List<RoomSquareMDTO> roomsWithSquareMeters(Long id);
}
