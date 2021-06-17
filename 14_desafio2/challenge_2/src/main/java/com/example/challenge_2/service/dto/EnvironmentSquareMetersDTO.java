package com.example.challenge_2.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class EnvironmentSquareMetersDTO {
    private String name;
    private double squareMeters;
}
