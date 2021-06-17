package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.HouseDTO;
import com.meli.TuCasitaTasaciones.model.PropertyDTO;

import java.util.List;

public interface IPropertyService {
//    Property getPropertyById(int idProperty);
//     double getAreaProperty(int idProperty);
//
//       double getPriceProperty(int idProperty);

//    double getAreaBigger();


    double calculateArea(List<EnvironmentDTO> environmentDTOS);
    double calculatePrice(HouseDTO houseDTO);
    EnvironmentAreaResponseDTO environmentsBiggest(List<EnvironmentDTO> environmentDTOS);
    List<EnvironmentAreaResponseDTO> environmentArea(List<EnvironmentDTO> environmentDTOS);

     void addProperty(PropertyDTO propertyDTO);

}
