package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Model.DTO.EnvironmentDTO;
import com.desafrio2.Desafio1.Model.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropService implements IPropService{

    @Override
    public double totalSquarMeters() {
        return 0;
    }

    @Override
    public double priceProp() {
        return 0;
    }

    @Override
    public Environment bigEnviroment() {
        return null;
    }

    @Override
    public List<EnvironmentDTO> meterByEnviaroment() {
        return null;
    }
}
