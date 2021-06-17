package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Services.DTOs.*;

import java.util.List;

public interface IPropertyService {


    public RoomDTO getBiggestRoom(Long id) throws PropertyNotFoundException;
    public PropertyDTO getPropertyById(Long id) throws PropertyNotFoundException;
    public StructureDTO getPropertyDimensions(Long id) throws PropertyNotFoundException;
    public ValueDTO getPropertyValue(Long id) throws PropertyNotFoundException, DistrictNotFoundException;
    public List<StructureDTO> getDimensionedRooms(Long id) throws PropertyNotFoundException;
}
