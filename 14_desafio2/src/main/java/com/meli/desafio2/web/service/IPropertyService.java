package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.request.PropertyDTO;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.response.BiggestEnvironmentResponse;
import com.meli.desafio2.web.response.PropertyValueResponse;
import com.meli.desafio2.web.response.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.response.SquareMetersResponse;

public interface IPropertyService {
    public SquareMetersResponse getSquareMeters(String name) throws PropertyNameNotFoundException;
    public PropertyValueResponse getValue(String name) throws PropertyNameNotFoundException;
    public BiggestEnvironmentResponse getBiggestEnvironment(String name) throws PropertyNameNotFoundException;
    public SquareMetersEnvironmentResponse getEnvironmentSquareMeters(String name) throws PropertyNameNotFoundException;
    public void addProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException, DistrictNotFoundException;
}
