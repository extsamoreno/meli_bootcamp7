package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.PropertyDTO;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.responses.BiggestEnvironmentResponse;
import com.meli.desafio2.web.responses.PropertyValueResponse;
import com.meli.desafio2.web.responses.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersResponse;

public interface IPropertyService {
    public SquareMetersResponse getSquareMeters(String name) throws PropertyNameNotFoundException;
    public PropertyValueResponse getValue(String name) throws PropertyNameNotFoundException;
    public BiggestEnvironmentResponse getBiggestEnvironment(String name) throws PropertyNameNotFoundException;
    public SquareMetersEnvironmentResponse getEnvironmentSquareMeters(String name) throws PropertyNameNotFoundException;
    public void addProperty(PropertyDTO propertyDTO) throws PropertyException, DistrictNotFoundException;
}
