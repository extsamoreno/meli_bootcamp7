package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.BiggerEnvironmentDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.model.Environment;

public class MapperEnvironment {
    public static BiggerEnvironmentDTO toBiggerEnvironment(Environment environment, String houseName){
        return new BiggerEnvironmentDTO(houseName, environment.getEnvironmentName(),environment.getTotalArea());
    }
    public static EnvironmentAreaDTO toEnvironmentAreaDTO(Environment environment){
        return new EnvironmentAreaDTO(environment.getEnvironmentName(),environment.getTotalArea());
    }
}
