package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;

public interface IPropertyService {

    String newProperty(PropertyInputDTO propertyInput);

    PropertyFullDTO getProperty(int id);

    PropertySquareDTO getSquareMeters(int id);

    PropertyValueDTO getValue(int id);

    PropertyBiggestEnvironmentDTO getBiggestEnvironment(int id);

    PropertyAllSquareDTO getEnvironmentsSquare(int id);
}
