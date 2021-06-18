package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.BiggestEnvironmentDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.model.Environment;

public class MapperEnvironment {
    public static BiggestEnvironmentDTO toBiggerEnvironment(Environment environment, String houseName){
        return new BiggestEnvironmentDTO(houseName, environment.getEnvironmentName(),environment.getTotalArea());
    }
    public static EnvironmentAreaDTO toEnvironmentAreaDTO(Environment environment){
        return new EnvironmentAreaDTO(environment.getEnvironmentName(),environment.getTotalArea());
    }
}
