package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.PropertyNotFoundException;

public interface IPropertyService {

    int newProperty(PropertyInputDTO propertyInput);

    PropertyFullDTO getProperty(int id) throws PropertyNotFoundException;

    PropertySquareDTO getSquareMeters(int id) throws PropertyNotFoundException;

    PropertyValueDTO getValue(int id) throws PropertyNotFoundException;

    PropertyBiggestEnviromentDTO getBiggestEnviroment(int id) throws PropertyNotFoundException;

    PropertyAllSquareDTO getEnviromentsSquare(int id) throws PropertyNotFoundException;
}
