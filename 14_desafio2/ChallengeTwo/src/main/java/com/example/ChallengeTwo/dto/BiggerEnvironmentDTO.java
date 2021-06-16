package com.example.ChallengeTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiggerEnvironmentDTO {
    private String houseName, environmentName;
    private double areaEnvironment;
}
