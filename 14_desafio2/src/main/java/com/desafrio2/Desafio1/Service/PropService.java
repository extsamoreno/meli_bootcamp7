package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.Environment;
import com.desafrio2.Desafio1.Model.Prop;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropService implements IPropService {

    @Autowired
    IPropRepository PropRequestRepository;

    @Override
    public PropDTOTMeters totalSquarMeters(PropRequest prop) {
        double totalArea = prop.getEnvironments().stream()
                .mapToDouble(Environment::area).sum();
        PropDTOTMeters proTotalMeters = new PropDTOTMeters(prop.getName(), totalArea);
        return proTotalMeters;
    }

    @Override
    public double priceProp(PropRequest prop) {
        return 0;
    }

    @Override
    public Environment bigEnviroment(PropRequest prop) {
        return null;
    }

    @Override
    public List<EnvironmentDTO> meterByEnviaroment(PropRequest prop) {
        return null;
    }
}