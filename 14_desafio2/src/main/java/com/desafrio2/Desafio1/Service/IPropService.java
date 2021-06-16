package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.Environment;
import com.desafrio2.Desafio1.Model.Prop;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPropService {


    PropDTOTMeters totalSquarMeters(PropRequest prop);

    double priceProp(PropRequest prop);

    Environment bigEnviroment(PropRequest prop);

    List<EnvironmentDTO> meterByEnviaroment(PropRequest prop);

}
