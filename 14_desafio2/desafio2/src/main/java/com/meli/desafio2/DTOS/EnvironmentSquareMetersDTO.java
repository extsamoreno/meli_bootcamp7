package com.meli.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentSquareMetersDTO {
    private String name;
    private Integer squareMeters;
}
