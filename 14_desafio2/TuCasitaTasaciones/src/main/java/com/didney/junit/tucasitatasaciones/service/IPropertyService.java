package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.EnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterByEnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterPropertyDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalValuePropertyByEnvironmentDTOResponse;

import java.util.List;

public interface IPropertyService {
    //US-0001 Calcular el total de metros cuadrados de la propiedad
    TotalSquareMeterPropertyDTOResponse getTotalSquareMeterProperty(int id);

    //US-0002 Indicar el valor de una propiedad a partir de sus ambientes y medidas **Precio según Barrio
    TotalValuePropertyByEnvironmentDTOResponse getTotalValuePropertyByEnvironment(int id);

    //US-0003 Determinar el ambiente mas grande -- de la propiedad
    EnvironmentDTOResponse getBiggerEnvironment(int id);

    //US-0004 Determinar la cantidad de metros cuadrados de cada ambiente en una propiedad.
    TotalSquareMeterByEnvironmentDTOResponse getTotalSquareMeterByEnvironment(int id);

    PropertyDTO addProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> addProperties(List<PropertyDTO> propertyDTOList);

    List<PropertyDTO> getPropertiesList();
}
