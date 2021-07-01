package com.meli.desafio2.Service;

import com.meli.desafio2.DTOS.*;

public interface IPropertyService {
    PropertyResponseTotalSquareMetersDTO calculateTotalSquareMeters(PropertyDTO property);
    PropertyResponseValueDTO calculatePrice(PropertyDTO property);
    EnvironmentDTO getBiggestEnvironment(PropertyDTO property);
    PropertyResponseSquareMetersPerEnvDTO calculateSquareMetersPerEnv(PropertyDTO property);
}
