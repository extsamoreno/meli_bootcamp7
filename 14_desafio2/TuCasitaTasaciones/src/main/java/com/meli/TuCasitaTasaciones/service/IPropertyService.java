package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.model.*;

import java.util.List;

public interface IPropertyService {

    double calculateArea(EnvironmentListDTO environmentDTOS);
    double calculatePrice(HouseDTO houseDTO);
    EnvironmentAreaResponseDTO environmentsBiggest(EnvironmentListDTO environmentDTOS);
    List<EnvironmentAreaResponseDTO> environmentArea(EnvironmentListDTO environmentDTOS);

     void addProperty(PropertyDTO propertyDTO);

}
