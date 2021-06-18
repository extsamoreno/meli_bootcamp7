package com.example.challenge2.serivces;

import com.example.challenge2.dtos.*;
import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.Property;

public interface IPropertyService {
    Property create(Property property) throws DistrictNotFoundException;

    SizeResponseDTO getSize(String propertyName);

    PriceResponseDTO getPrice(String propertyName);

    BiggerEnvironmentResponseDTO getBiggerEnvironment(String propertyName);

    EnvironmentSizesDTO getEnvironments(String propertyName);

}
