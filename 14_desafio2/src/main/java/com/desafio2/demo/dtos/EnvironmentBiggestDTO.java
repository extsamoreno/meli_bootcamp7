package com.desafio2.demo.dtos;

import com.desafio2.demo.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnvironmentBiggestDTO {
    private String propertyName;
    private double  totalSquareMeters;
    private Environment environment;
}
