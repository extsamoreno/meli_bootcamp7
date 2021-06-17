package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.PropertyNotFoundException;

public interface IPropertyService {

    int newProperty(PropertyInputDTO propertyInput);

    PropertyFullDTO getProperty(int id);

    PropertySquareDTO getSquareMeters(int id);

    PropertyValueDTO getValue(int id);

    PropertyBiggestEnviromentDTO getBiggestEnviroment(int id);

    PropertyAllSquareDTO getEnviromentsSquare(int id);
}
