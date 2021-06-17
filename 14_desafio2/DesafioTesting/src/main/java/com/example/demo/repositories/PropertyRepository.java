package com.example.demo.repositories;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.services.dtos.*;

public interface PropertyRepository {
    void loadData();
    PropertyM2ResponseDTO getSquareMeter(int propId) throws PropertyDontFoundException;
    PropertyPriceResponseDTO getPrice(int propId) throws PropertyDontFoundException;
    BiggestPropResponseDTO getBiggestEnvProp(int propId) throws PropertyDontFoundException;
    PropertyM2EnvsResponseDTO getMeterSquareEnvs(int propId) throws PropertyDontFoundException;
    PropertyRequestDTO addProperty(PropertyRequestDTO propertyRequestDTO);
    Property findPropertyById(int propId) throws PropertyDontFoundException;
}
