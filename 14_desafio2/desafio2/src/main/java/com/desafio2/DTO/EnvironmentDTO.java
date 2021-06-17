package com.desafio2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class EnvironmentDTO {
    private String name;
    private double squareMeters;
}
