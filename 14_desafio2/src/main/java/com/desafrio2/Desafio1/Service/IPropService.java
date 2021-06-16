package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.Environment;

import java.util.List;

public interface IPropService {

    double totalSquarMeters();

    double priceProp();

    Environment bigEnviroment();

    List<EnvironmentDTO> meterByEnviaroment();

}
