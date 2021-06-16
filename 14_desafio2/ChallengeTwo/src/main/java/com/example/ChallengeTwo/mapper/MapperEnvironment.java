package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.BiggerEnvironmentDTO;
import com.example.ChallengeTwo.model.Environment;

public class MapperEnvironment {
    public static BiggerEnvironmentDTO toBiggerEnvironment(Environment environment, String houseName){
        return new BiggerEnvironmentDTO(houseName, environment.getEnvironmentName(),environment.getTotalArea());
    }
}
