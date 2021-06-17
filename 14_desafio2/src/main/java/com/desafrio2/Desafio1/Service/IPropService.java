package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTPrice;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.Environment;

import java.util.List;

public interface IPropService {


    PropDTOTMeters totalSquartMeters(PropRequest prop);

    PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExist;

    Environment bigEnviroment(PropRequest prop);

    List<EnvironmentDTO> meterByEnviaroment(PropRequest prop);

}
