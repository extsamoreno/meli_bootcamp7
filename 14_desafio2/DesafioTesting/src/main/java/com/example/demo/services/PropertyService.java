package com.example.demo.services;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.dtos.*;

public interface PropertyService {

    PropertyM2ResponseDTO getMeterSquare(int propId) throws PropertyDontFoundException;
    PropertyPriceResponseDTO getPrice(int propId) throws PropertyDontFoundException;
    BiggestPropResponseDTO getBiggestEnvProp(int propId) throws PropertyDontFoundException;
    PropertyM2EnvsResponseDTO getMeterSquareEnvs(int propId) throws PropertyDontFoundException;
    PropertyRequestDTO addProperty(PropertyRequestDTO propertyRequestDTO) throws DistrictDontFoundException;
    Property findPropertyById(int propId) throws PropertyDontFoundException;
}
