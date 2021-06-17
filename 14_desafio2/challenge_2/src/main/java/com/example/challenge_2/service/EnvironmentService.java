package com.example.challenge_2.service;

import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.EnvironmentSquareMetersDTO;
import com.example.challenge_2.service.mapper.EnviromentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvironmentService implements IEnvironmentService{

    @Autowired
    EnviromentMapper enviromentMapper;

    @Override
    public double calculateSquareMeters(Environment enviroment) {
        return enviroment.getHeight() * enviroment.getWidth();
    }

    @Override
    public EnvironmentDTO getBiggestEnviroment(List<Environment> enviroments) {
        Environment enviromentMax = enviroments.stream().max(Comparator.comparing(this::calculateSquareMeters)).get();

        return enviromentMapper.toDTO(enviromentMax);
    }

    @Override
    public List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(List<Environment> environments) {
        return environments.stream().map(x -> new EnvironmentSquareMetersDTO(x.getName(), calculateSquareMeters(x))).collect(Collectors.toList());
    }
}
