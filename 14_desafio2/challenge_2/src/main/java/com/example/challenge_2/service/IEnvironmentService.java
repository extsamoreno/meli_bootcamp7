package com.example.challenge_2.service;

import com.example.challenge_2.models.Environment;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.EnvironmentSquareMetersDTO;

import java.util.List;

public interface IEnvironmentService {
    double calculateSquareMeters(Environment enviroment);

    EnvironmentDTO getBiggestEnviroment(List<Environment> environments);

    List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(List<Environment> environments);
}
