package com.example.challenge2.serivces;

import com.example.challenge2.dtos.*;
import com.example.challenge2.models.District;

public interface IPropertyService {
    void create(PropertyDTO property);

    SizeResponseDTO getSize(String propertyName);

    PriceResponseDTO getPrice(String propertyName);

    BiggerEnvironmentResponseDTO getBiggerEnvironment(String propertyName);

    EnvironmentSizesDTO getEnvironments(String propertyName);

    void createDistrict(District district);
}
