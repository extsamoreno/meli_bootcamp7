package com.desafio2.demo.Service;

import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.DTO.*;

public interface IPropService {


    PropDTOTMeters totalSquareMeters(PropRequest prop);

    PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExist;

    EnvironmentDTO bigEnvironment(PropRequest prop);

    PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop);

}
