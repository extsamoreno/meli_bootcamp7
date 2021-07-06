package com.meli.desafio2.services;

import com.meli.desafio2.dtos.*;

public interface IPropertyService {
    PropertyResponseTotalSquareMetersDTO calculateTotalSquareMeters(PropertyDTO property);
    PropertyResponseValueDTO calculatePrice(PropertyDTO property);
    EnvironmentDTO getBiggestEnvironment(PropertyDTO property);
    PropertyResponseSquareMetersPerEnvDTO calculateSquareMetersPerEnv(PropertyDTO property);
}
