package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.*;
import com.desafrio2.Desafio1.Model.Environment;

import java.util.List;

public interface IPropService {


    PropDTOTMeters totalSquareMeters(PropRequest prop);

    PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExist;

    EnvironmentDTO bigEnvironment(PropRequest prop);

    PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop);

}
