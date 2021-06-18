package meli.bootcamp.tucasita.service;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.service.dto.EnviromentResponseDTO;
import meli.bootcamp.tucasita.service.dto.EnviromentsMetersResponseDTO;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyResponseDTO;

public interface IPropertyService {

    PropertyResponseDTO getMetersProperty(PropertyDTO property);

    PropertyResponseDTO getMetersProperty(String propertyId) throws PropertyNotFoundException;

    PropertyResponseDTO getPricePropertyById(String nameProperty) throws PropertyNotFoundException;

    EnviromentResponseDTO getLargerEnvironmentPropertyById(String nameProperty) throws PropertyNotFoundException;

    EnviromentsMetersResponseDTO getMetersEnvironmentPropertyById(String nameProperty) throws PropertyNotFoundException;
}
