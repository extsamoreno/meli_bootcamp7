package com.example.desafio2.dtos;

import com.example.desafio2.models.EnvironmentDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBiggestEnvironmentDTO {
    private String propertyName;
    private double totalSquareMeters;
    private EnvironmentDTO environment;
}
