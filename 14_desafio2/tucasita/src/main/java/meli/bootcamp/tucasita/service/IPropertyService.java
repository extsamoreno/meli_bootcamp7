package meli.bootcamp.tucasita.service;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyMetersResponseDTO;

public interface IPropertyService {

    PropertyMetersResponseDTO getMetersProperty(PropertyDTO property);

    PropertyMetersResponseDTO getMetersProperty(String propertyId) throws PropertyNotFoundException;
}
