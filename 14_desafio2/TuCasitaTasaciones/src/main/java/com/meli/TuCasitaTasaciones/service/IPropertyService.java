package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.model.Environment;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.HouseDTO;

import java.util.List;

public interface IPropertyService {
//    Property getPropertyById(int idProperty);
//     double getAreaProperty(int idProperty);
//
//       double getPriceProperty(int idProperty);

//    double getAreaBigger();


    double calculateArea(List<Environment> environments);
    double calculatePrice(HouseDTO houseDTO);
    EnvironmentAreaResponseDTO environmentsBigger(List<Environment> environments);
    List<EnvironmentAreaResponseDTO> environmentArea(List<Environment> environments);

}
