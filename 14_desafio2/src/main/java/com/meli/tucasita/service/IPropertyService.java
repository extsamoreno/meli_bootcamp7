package com.meli.tucasita.service;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;

import java.util.List;

public interface IPropertyService {

    String getPropertyArea(List<RoomDTO> rooms);

    String getPropertyPrice(PropertyPriceRequestDTO propertyPriceRequestDTO) throws InvalidDistrictException;

    String getPropertyBiggestRoom(List<RoomDTO> roomDTOS);

    List<RoomAreaDTO> getRoomsAreas(List<RoomDTO> roomsDTO);

    String insertNewProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, InvalidDistrictException;
}
