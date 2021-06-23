package com.desafio2.demo.Service;

import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Model.DTO.*;

import java.util.List;

public interface IPropService {


    PropDTOTMeters totalSquareMeters(PropRequest prop);

    PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExistException;

    List<EnvironmentDTOResponse> bigEnvironment(PropRequest prop);

    PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop);

}